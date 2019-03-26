package com.iamlook.jvm;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 14:45
 **/
public class Math {

    public static final Integer CONSTANCE = 666;


    public int math(){

        int a = 1;
        int b = 2;
        int c = (a+b) * 10;
        return c;
    }

    public static void main(String[] args) {

        Math math = new Math();
        int result = math.math();
        System.out.println(result);

    }
}
