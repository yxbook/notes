package com.iamlook.service;

import com.iamlook.model.User;

import java.util.HashMap;
import java.util.List;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:57
 **/
public interface IUserService {


    List<String> queryUserList(HashMap hashMap);

    List queryAll();

    List<User> queryUserList(int id);
}
