package com.iamlook.concurrent;

import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-04 17:13
 **/
public class LinkedBlockingQueueTest {

    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap(); //初始化ConcurrentHashMap
        //新增个人信息
        map.put("id","1");
        map.put("name","andy");
        map.put("sex","男");
        //获取姓名
        String name = map.get("name");
        //计算大小
        int size = map.size();
        System.out.println(name);
        System.out.println(size);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        /*ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);*/

        LinkedBlockingQueueTest test = new LinkedBlockingQueueTest();
        for(int i = 0; i < 1000; i++){
            cachedThreadPool.submit(test.new TakePoll());
        }

    }



    class TakePoll implements Runnable{
        @Override
        public void run() {
            for(int i =0; i < 1000; i++){
                linkedBlockingQueue.add(i);
                System.out.println(linkedBlockingQueue.size());
            }
        }
    }
}
