package com.iamlook.classload;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-26 10:32
 **/
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass 静态");
    }


    static int a;

    public SubClass(){
        System.out.println("Subclass init");
    }
}
