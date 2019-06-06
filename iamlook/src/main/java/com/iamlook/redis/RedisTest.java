package com.iamlook.redis;

import com.iamlook.service.IUserService;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;


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
public class RedisTest {


    private IUserService userService;

    private int threadCount=10;//线程数量

    private CountDownLatch countDown=new CountDownLatch(threadCount);//CountDownLatch


    @Test
    public void testRedis(){

      for (int i = 0; i < threadCount; i++){

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        countDown.await();
                        System.out.println(Thread.currentThread().getName());
                        userService.queryUserList(3);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }



                }
            }).start();

            countDown.countDown();

          System.out.println("线程全部执行结束");




      }
  }


}
