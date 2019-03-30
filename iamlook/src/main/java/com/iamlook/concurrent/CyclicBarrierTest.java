package com.iamlook.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/***
* @Description:
 *
 * 同步屏障CyclicBarrier
   CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。
   它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，
   所有被屏障拦截的线程才会继续运行。
   CyclicBarrier默认的构造方法是CyclicBarrier（int parties），其参数表示屏障拦截的线程数量，
   每个线程调用await方法告诉CyclicBarrier我已经到达了屏障，然后当前线程被阻塞。
*/
public class CyclicBarrierTest {

    private static Random sr=new Random(47);

    private static AtomicInteger result=new AtomicInteger(0);


    private static int threadCount=10;
    //屏障后面执行汇总

    private static CyclicBarrier barrier=new CyclicBarrier(threadCount,new Accumulate());


    private static class Parser implements Runnable{
        String name;
        public Parser(String name){
            this.name=name;
        }
        public void run() {
            int sum=0;
            int seed=Math.abs(sr.nextInt()) ;
            Random r=new Random(47);
            for(int i=0;i<(seed%100*100000);i++){
                sum+=r.nextInt(seed);
            }
            result.addAndGet(sum);
            System.out.println(System.currentTimeMillis()+"-"+name+"线程的解析结果："+sum);
            try {
                barrier.await();
                System.out.println(System.currentTimeMillis()+"-"+name+"线程越过屏障！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    static class Accumulate implements Runnable{
        public void run() {
            System.out.println("所有线程解析结束！");
            System.out.println("所有线程的解析结果："+result);
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
    }
}
