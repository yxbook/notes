package com.iamlook.service.impl;

import com.iamlook.service.IUserService;
import com.alibaba.fastjson.JSON;
import com.iamlook.mapper.UserMapper;
import com.iamlook.model.User;
import com.iamlook.service.IUserService;
import com.iamlook.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:58
 **/
@Service
public class UserServiceImpl implements IUserService{

    Map<String, Lock> lockMap = new ConcurrentHashMap<>();

    Map<String, Object> downMap = new ConcurrentHashMap<>();

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserMapper userMapper;



    @Override
    public List<String> queryUserList(HashMap hashMap) {
        List<String> list = new ArrayList<>();
        list.add("小时");
        list.add("递四方速递");
        list.add("彩信相册V型");
        list.add("尔特人");
        return list;
    }

    @Override
    public List queryUserList2(HashMap paraMap) {
        List<String> list = new ArrayList<>();
        list.add("I am English");
        return list;
    }

    @Override
    public List queryAll(){
        Lock lock = null;
        try {
            //1、先从缓存中获取数据
            String key = "queryUserList_"+123123;
            String value = (String) redisUtils.get(key);
            if(value != null){
                return JSON.parseArray(value, User.class);
            }
            lock = lockMap.putIfAbsent(key, new ReentrantLock());
            if(null == lock){
                lock = lockMap.get(key);
            }

            lock.lock();

            value = (String) redisUtils.get(key);

            if(value == null){
                System.out.println(Thread.currentThread().getName() + "从数据库获取========");
                List<User> list = userMapper.getAll();
                redisUtils.set(key, JSON.toJSONString(list), 10);
                return list;
            }else{
                System.out.println(Thread.currentThread().getName() + "从缓存中获取");
                return JSON.parseArray(value, User.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            lock.unlock();
        }
    }


    /**
     *
     * 缓存失效的情况：
     * 1、高峰期大面积缓存key失效
     * 2、局部高峰，热点缓存失效
     * 3、redis服务重启，内存中缓存数据丢失
     *
     *
     *
     * lock锁的特性：排他，互斥，阻塞
     * 锁方案的优缺点：
     * 1、阻塞其他线程，用户体验不好
     * 2、锁的颗粒度太大，造成阻塞（解决方案，降低锁的粒度，同易类型的查询单独加锁）
     *
     * 缓存降级方案的优缺点：
     * 1、灵活多变，可根据业务场景调整
     * 2、使用场景比较丰富
     *
     * 缓存雪崩推荐使用降级策略
     *
     *
     *
     *
     *
     * 其他问题：
     * redis如何实现 红包。投票。购物车，如何保证一致性
     * 如何实现分布式session
     * 如何实现分布式锁
     *
     *
     */



    @Override
    public List<User> queryUserList(int id) {
        //1、先从缓存中获取数据
        String key = "queryUserList_"+id;


        String value = (String) redisUtils.get(key);

        if(null == value){
            System.out.println(Thread.currentThread().getName() + "从缓存中获取到数据");
            redisUtils.set("aaa", "111", 10);
        }


        //2、锁机制
        /**
         *
         Lock lock = lockMap.get(id);
         if(null == lock){
         lock = new ReentrantLock();
         lockMap.put("queryUserList_"+id, lock);

         }

         lock.lock();
         *
         */

        // --------  加锁的方案---------

        Lock lock = lockMap.putIfAbsent(key, new ReentrantLock());
        if(null == lock){
            lock = lockMap.get(key);
        }
        lock.lock();


        try {

            //3、从数据库中获取
            List<User> list = userMapper.getAll();

            //A、先从缓存中获取、获取不到在查询数据库

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


        //------------------降级方案

        //判断是否有正在进行查询数据库的线程，如果有进行缓存降级策略
        boolean flag = downMap.putIfAbsent(key, "xxxxx") == null;
        if(flag){

            //3、从数据库中获取

            //A、先从缓存中获取、获取不到在查询数据库

        }else {

            //缓存降级方案
            //1、可以重试几次
            //2、返回默认值
            //3、返回提示用户重新操作
            //4、主备策略，双机热备
            //...........

        }

        return null;
    }

    @Override
    public List test() {
        return userMapper.getTestAll();
    }

    @Override
    public List testUpCase() {
        return userMapper.getUserBeanAll();
    }
}
