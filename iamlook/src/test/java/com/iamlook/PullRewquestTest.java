package com.iamlook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-04-03 13:48
 **/
public class LambadaTest {

    @Test
    public void test(){

        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");


        LambadaTest test = new LambadaTest();
        test.sortUsingJava7(names2);
        test.sortUsingJava8(names1);




    }


    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }


    // 类型声明
    MathOperation addition = (int a, int b) -> a + b;

    // 不用类型声明
    MathOperation subtraction = (a, b) -> a - b;

    // 大括号中的返回语句
    MathOperation multiplication = (int a, int b) -> { return a * b; };

    // 没有大括号及返回语句
    MathOperation division = (int a, int b) -> a / b;

    @Test
    public void test2(){
        LambadaTest tester = new LambadaTest();
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        GreetingService greetingService = message -> {

            System.out.println("4234234");
            System.out.println("4234234");
            System.out.println("4234234");
            System.out.println("4234234");
            System.out.println("4234234");
            return "asdasd";

        };
        String rs = greetingService.sayMessage("下坡时");

        System.out.println(rs);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }


    interface MathOperation{
        int operation(int a, int b);
    }

    interface GreetingService {
        String sayMessage(String message);
    }


    @Test
    public void test3(){

        GreetingService greetingService = message -> {

            System.out.println("测试PullRequest");

            return message;
        };

        String result = greetingService.sayMessage("asd");

        System.out.println(result);
    }
}
