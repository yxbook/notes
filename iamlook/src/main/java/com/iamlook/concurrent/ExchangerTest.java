package com.iamlook.concurrent;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 *线程间交换数据的Exchanger
 *
 Exchanger（交换者）是一个用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。
 它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，
 它会一直等待第二个线程也执行exchange方法，当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。



 下面来看一下Exchanger的应用场景。
 1、Exchanger可以用于遗传算法，遗传算法里需要选出两个人作为交配对象，这时候会交换两人的数据，
    并使用交叉规则得出2个交配结果。

 2、Exchanger也可以用于校对工作，比如我们需要将纸制银行流水通过人工的方式录入成电子银行流水，为了避免错误，
    采用AB岗两人进行录入，录入到Excel之后，系统需要加载这两个Excel，并对两个Excel数据进行校对，看看是否录入一致.
 *
 *
 *
 *
 */
public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            public void run() {
                try {
                    String A = "银行流水100";// A录入银行流水数据
                    Thread.sleep(10000);
                    String B=exgr.exchange(A);
                    System.out.println("A的视角：A和B数据是否一致：" + A.equals(B) +
                            "，A录入的是：" + A + "，B录入是：" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.execute(new Runnable() {
            public void run() {
                try {
                    String B = "银行流水200";// B录入银行流水数据
                    String A = exgr.exchange(B);
                    System.out.println("B的视角：A和B数据是否一致：" + A.equals(B) +
                            "，A录入的是：" + A + "，B录入是：" + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }
}
