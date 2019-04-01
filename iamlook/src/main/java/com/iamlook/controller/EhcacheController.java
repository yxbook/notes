package com.iamlook.controller;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-22 09:41
 **/
@RestController
@RequestMapping(value = "/iamlook")
/*
@CacheConfig(cacheNames = {“myCache”})设置ehcache的名称，这个名称必须在ehcache.xml已配置 。
 */
@CacheConfig(cacheNames = {"myCache"})
public class EhcacheController {

    /*
    @Cacheable
    1、此处value是必需的，它指定了你的缓存存放在哪块命名空间。
    2、此处的key是使用的spEL表达式

    String[] cacheNames() default {}; //和value注解差不多，二选一
    String keyGenerator() default ""; //key的生成器。key/keyGenerator二选一使用
    String cacheManager() default ""; //指定缓存管理器
    String cacheResolver() default ""; //或者指定获取解析器
    String condition() default ""; //条件符合则缓存
    String unless() default ""; //条件符合则不缓存
    boolean sync() default false; //是否使用异步模式


    注意：

    1.当我们要使用root对象的属性作为key时我们也可以将“#root”省略，因为Spring默认使用的就是root对象的属性。 如

    @Cacheable(key = "targetClass + methodName +#p0")

    2.使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”。 如：

    @Cacheable(value="users", key="#id")

    @Cacheable(value="users", key="#p0")

    @Cacheable(cacheNames = "product",key = "#sellerId"，unless = "#result.getCode() != 0")
    依据结果来判断是否缓存 unless = “#result.getCode() != 0”,#result其实就是ResultVO，也就是返回的对象
    unless(除什么之外,如果不 的意思) 如果=0就缓存，需要写成!=0。理解起来就是，除了不等于0的情况之外，才缓存，也就是等于0才缓存。


    @Cacheable(cacheNames = "product",key = "#sellerId"，condition = "#sellerId.length() > 3")
    这样只有条件成立才会直接返回缓存，结果不成立是不缓存的，即使有缓存，也会运行方法








     */
    @PostMapping(value = "/getLookList")
    @Cacheable(key = "targetClass + methodName +#p0")
    public List<String> getLookList(){
        List<String> list = new ArrayList<>();
        try {
            list.add("小米");
            list.add("小名");
            list.add("小先看看");
            list.add("小考试");
            list.add("小离");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    @PostMapping(value = "/queryAll")
    @Cacheable(key = "targetClass + methodName +#p0")
    public List<String> queryAll() {
        List<String> list = new ArrayList<>();
        try {
            list.add("小米1");
            list.add("小名1");
            list.add("小先1");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;

    }





}
