package com.iamlook.controller;

import com.iamlook.service.IUserService;
import com.iamlook.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/redis")
@RestController
public class RedisController {

    @Autowired
    private IUserService userService;


    @PostMapping(value = "getUserList")
    public List<String> getUserList(HashMap paraMap){
        List list = userService.queryUserList(paraMap);
        return list;

    }



}
