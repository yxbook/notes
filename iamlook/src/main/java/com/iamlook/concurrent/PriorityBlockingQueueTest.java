package com.iamlook.concurrent;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-05 14:07
 **/
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer param, Integer param2) {
                if (param > param2) {
                    return 1;
                } else if (param < param2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        BlockingQueue<Integer> blockingQueue = new PriorityBlockingQueue<>(5,comparator);

        try {
            blockingQueue.put(1);
            blockingQueue.put(23);
            blockingQueue.put(56);
            blockingQueue.put(15);
            blockingQueue.put(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
