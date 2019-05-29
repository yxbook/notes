package com.iamlook.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-04-08 09:55
 **/
public class StramTest {

    @Test
    public void testStream(){

        List<String> strings = Arrays.asList("abc", "", "abc", "efg", "abc","", "jkl");

        List<String> news = strings.stream().filter(a -> !a.isEmpty()).distinct().collect(Collectors.toList());

        String result = strings.stream().filter(a -> !a.isEmpty()).collect(Collectors.joining(","));
        System.out.println(result);

        news.forEach(s -> System.out.println(s));


        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());

        squaresList.forEach(s -> System.out.println(s));

    }

    /**
     *
     *
     * 既然提到了map，又怎能不提到reduce。reduce与map一样，
     * 也是函数式编程里最重要的几个方法之一。。。
     * map的作用是将一个对象变为另外一个，而reduce实现的则是将所有值合并为一个，请看：


     *
     */

    @Test
    public void mapTest() {
        List<Double> cost = Arrays.asList(10.0, 20.0,30.0);
       double s = cost.stream().map(x -> get(x)).reduce((sum, x) -> sum + x).get();
        System.out.println(s);
    }

    private Double get(Double x) {
        return x + 100;
    }

    
    
    @Test
    public void test3(){

        List<String> languages = Arrays.asList("Java","Python","scala","Shell","R");
        System.out.println("Language starts with J: ");
        filterTest(languages,x -> x.startsWith("J"));
        System.out.println("Language ends with a: ");
        filterTest(languages,x -> x.endsWith("a"));
        System.out.println("All languages: ");
        filterTest(languages,x -> true);
        System.out.println("No languages: ");
        filterTest(languages,x -> false);
        System.out.println("Language length bigger three: ");
        filterTest(languages,x -> x.length() > 4);
        
    }

    public void filterTest(List<String> languages, Predicate<String> condition) {
        languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
    }


}
