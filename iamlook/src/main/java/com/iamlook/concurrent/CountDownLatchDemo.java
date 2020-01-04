package com.iamlook.concurrent;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private Integer[] nums;//总行数

    public CountDownLatchDemo(Integer line){
        nums = new Integer[line];
    }

    /**
     *
     * @param lineText 行内容
     * @param index 行数
     */
    public void calc(String lineText,Integer index){
        String[] numsArray = lineText.split(",");
        Integer total = 0;
        for(String num : numsArray){
            total += Integer.parseInt(num);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName()+"线程开始计算...."+lineText+",计算结果为："+total);
    }

    public void sum(){
        System.out.println("汇总计算结果开始执行.....");
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total +=nums[i];
        }
        System.out.println("最终的计算结果:"+total);
    }

    public static void main(String[] args) {
        List<String> contents = readFile();
        Integer lineNum = contents.size();
        CountDownLatch count = new CountDownLatch(lineNum);//定义一个计数器
        CountDownLatchDemo demo = new CountDownLatchDemo(lineNum);

        for (int i = 0; i < lineNum; i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.calc(contents.get(j), j);
                    count.countDown();
                }
            }).start();
        }

        //汇总
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.sum();

    }


    private static List<String> readFile() {
        List<String> contents = new ArrayList<>();
        String lineText = null;
        BufferedReader bufferedReader = null;
        try {
            String filePath = "/home/sddt/zm/nums111111.txt";
            bufferedReader = new BufferedReader(new FileReader(filePath));
            while((lineText=bufferedReader.readLine())!=null){
                contents.add(lineText);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contents;
    }



}