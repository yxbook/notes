package com.iamlook.concurrent;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/***
* @Description:
 *
 *
    等待多线程完成的CountDownLatch


    CountDownLatch允许一个或多个线程等待其他线程完成操作。

    假如有这样一个需求：我们需要解析一个Excel里多个sheet的数据，此时可以考虑使用多线程，
    每个线程解析一个sheet里的数据，等到所有的sheet都解析完之后，程序需要提示解析完成（或者汇总结果）。
    在这个需求中，要实现主线程等待所有线程完成sheet的解析操作，最简单的做法是使用join()方法

*/
public class JoinCountDownLatchTest {


    private static Random sr=new Random(47);


    private static AtomicInteger result=new AtomicInteger(0);


    private static int threadCount=10;


    private static class Parser implements Runnable{
        String name;
        public Parser(String name){
            this.name=name;
        }
        public void run() {
            int sum=0;
            int seed=Math.abs(sr.nextInt()) ;
            Random r=new Random(47);
            for(int i=0;i<100;i++){
                sum+=r.nextInt(seed);
            }
            result.addAndGet(sum);
            System.out.println(name+"线程的解析结果："+sum);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads=new Thread[threadCount];
        for(int i=0;i<threadCount;i++){
            threads[i]=new Thread(new Parser("Parser-"+i));
        }
        for(int i=0;i<threadCount;i++){
            threads[i].start();
        }
        for(int i=0;i<threadCount;i++){
            threads[i].join();
        }
        System.out.println("所有线程解析结束！");
        System.out.println("所有线程的解析结果："+result);
    }
}
