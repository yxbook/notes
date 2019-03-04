package com.iamlook.concurrent;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-04 11:35
 **/
public class ReentrantLockTest {

    private ArrayList<Integer> arrayList = new ArrayList<Integer>();

    Lock lock = new ReentrantLock();    //注意这个地方


    public static void main(String[] args)  {
        final ReentrantLockTest test = new ReentrantLockTest();
        new Thread(){
            public void run() {
                //test.insert(Thread.currentThread());
                test.tryLock(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                //test.insert(Thread.currentThread());
                test.tryLock(Thread.currentThread());
            };
        }.start();

    }



    /***

     　　tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，
     则返回true，如果获取失败（即锁已被其他线程获取），则返回false，
     也就说这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。

     */
    public void tryLock(Thread thread) {
        if(lock.tryLock()) {
            try {
                System.out.println(thread.getName()+"得到了锁");
                for(int i=0;i<5;i++) {
                    arrayList.add(i);
                }
                Thread.sleep(5000);
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(thread.getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName()+"获取锁失败");
        }
    }


    /***

     　　首先lock()方法是平常使用得最多的一个方法，就是用来获取锁。
        如果锁已被其他线程获取，则进行等待。

     */
    public void insert(Thread thread) {
        //在insert方法中的lock变量是局部变量，每个线程执行该方法时都会保存一个副本，那么理所当然每个线程执行到lock.lock()处获取的是不同的锁
        //Lock lock = new ReentrantLock();    //注意这个地方
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            System.out.println("执行结束返回：" + arrayList.size());
            lock.unlock();
        }
    }
}
