package com.iamlook.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-04 17:13
 **/
public class LinkedBlockingQueueTest {

    LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

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
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

    }
}
