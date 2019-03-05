package com.iamlook.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * 读写锁Demo
 */
public class ReentrantReadWriteLockDemo {

    class MyObject {

        private Object object;

        private ReadWriteLock lock = new java.util.concurrent.locks.ReentrantReadWriteLock();

        public void get() throws InterruptedException {
            lock.readLock().lock();//上读锁
            try {
                System.out.println(Thread.currentThread().getName() + "准备读取数据");
                Thread.sleep(new Random().nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "读数据为：" + this.object);
            } finally {
                lock.readLock().unlock();
            }
        }

        public void put(Object object) throws InterruptedException {
            lock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + "准备写数据");
                Thread.sleep(new Random().nextInt(1000));
                this.object = object;
                System.out.println(Thread.currentThread().getName() + "写数据为" + this.object);
            } finally {
                lock.writeLock().unlock();
            }
        }
    }

    /*
    (1). newCachedThreadPool
         创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
         线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。

     */
    public static void main(String[] args) {
        final MyObject myObject = new ReentrantReadWriteLockDemo().new MyObject();
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 3; j++) {
                        try {
                            myObject.put(new Random().nextInt(1000));//写操作
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 3; j++) {
                        try {
                            myObject.get();//多个线程读取操作
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        executorService.shutdown();
    }
}