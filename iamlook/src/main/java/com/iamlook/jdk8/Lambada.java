package com.iamlook.jdk8;

import java.util.function.Function;

/**
 * @program:
 *
 * 1、函数式编程
 * 2、lambada表达式及应用场景
 * 3、java8自带函数function接口详解
 * @author: Created by youxun
 * @create: 2019-04-03 13:07
 **/
public class Lambada {

    public static void main(String[] args) {




        new Thread(() -> {

            for(;;){
                System.out.println("AAAAAAAA");
            }

        }).start();


        new Thread(() -> System.out.println("43535435")).start();



    }

    //Function  Predicate
    //基于stream流进行过滤


    public static Integer getName(Function<String, Integer> function, String args){

        return function.apply(args);

    }


    //lambada表达式的3中写法

    //





}
