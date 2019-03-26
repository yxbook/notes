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
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping(value = "getUserList")
    public List<String> getUserList(HashMap paraMap){
        List<String> resultList = new ArrayList<>();
        List list = userService.queryUserList(paraMap);
        System.out.println(IUserService.class);
        IUserService service = SpringContextUtil.getBean(IUserService.class);
        List list2 = service.queryUserList2(paraMap);
        resultList.addAll(list);

        resultList.addAll(list2);

        return resultList;

    }



}
