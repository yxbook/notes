package com.iamlook.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**

 ReadWriteLock也是一个接口，在它里面只定义了两个方法：
 Lock readLock();
 Lock writeLock();

 　　一个用来获取读锁，一个用来获取写锁。也就是说将文件的读写操作分开，
 分成2个锁来分配给线程，从而使得多个线程可以同时进行读操作。

 下面的ReentrantReadWriteLock实现了ReadWriteLock接口。




 **/
public class ReentrantReadWriteLockTest {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args)  {

        final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();

    }

    /*
    　　再举个例子：当有多个线程读写文件时，读操作和写操作会发生冲突现象，
        写操作和写操作会发生冲突现象，但是读操作和读操作不会发生冲突现象。
     */

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        }finally {
            rwl.readLock().unlock();
        }
    }

    /*public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis() - start <= 1) {
            System.out.println(thread.getName()+"正在进行读操作");
        }
        System.out.println(thread.getName()+"读操作完毕");
    }*/
}
