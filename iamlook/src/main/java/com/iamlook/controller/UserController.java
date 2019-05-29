package com.iamlook.controller;

<<<<<<< HEAD
import com.iamlook.service.IUserService;
import com.iamlook.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.iamlook.model.User;
import com.iamlook.service.IUserService;
import com.iamlook.utils.SpringContextUtil;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
>>>>>>> 30f11e3654495d24a4f1456fab79ed8b4dbefdaa
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 11:01
 **/
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

<<<<<<< HEAD
=======
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private Redisson redisson;

>>>>>>> 30f11e3654495d24a4f1456fab79ed8b4dbefdaa

    @PostMapping(value = "getUserList")
    public List<String> getUserList(HashMap paraMap){
        List<String> resultList = new ArrayList<>();
        List list = userService.queryUserList(paraMap);
<<<<<<< HEAD
        System.out.println(IUserService.class);
        IUserService service = SpringContextUtil.getBean(IUserService.class);
        List list2 = service.queryUserList2(paraMap);
=======
        System.out.println(userService);
        System.out.println(IUserService.class);
        IUserService service = SpringContextUtil.getBean(IUserService.class);
        List list2 = service.queryAll();
>>>>>>> 30f11e3654495d24a4f1456fab79ed8b4dbefdaa
        resultList.addAll(list);

        resultList.addAll(list2);

        return resultList;

    }


<<<<<<< HEAD
=======
    @PostMapping(value = "queryAll")
    public List<User> queryAll(Integer id){


        return userService.queryAll();

    }


    /**
     * 模拟减库存，redis分布式锁实现
     * @return
     */
    @PostMapping(value = "reduceStock")
    public String reduceStock(String userName){
        //分布式锁
        String lockKey = "lockKey";
        RLock lock = redisson.getLock(lockKey);
        lock.lock();
        try {
            int stock = (int) redisTemplate.opsForValue().get("stock");
            if(stock > 0){
                int reduce = stock - 1;
                redisTemplate.opsForValue().set("stock", reduce);
                System.out.println("扣除成功，剩余库存=：" + reduce);
            }else {
                System.out.println("库存不足");
            }
        } finally {
            lock.unlock();
        }
        return "success";

    }

>>>>>>> 30f11e3654495d24a4f1456fab79ed8b4dbefdaa

}