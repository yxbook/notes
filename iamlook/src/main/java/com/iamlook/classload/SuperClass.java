package com.iamlook.classload;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-26 10:30
 **/
public class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass 静态");

    }

    public static int value = 88;

    public SuperClass(){
        System.out.println("init SuperClass");
    }


}
