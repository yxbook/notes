package com.iamlook.service.impl;

import com.iamlook.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:58
 **/
@Service
public class UserServiceImpl implements IUserService{
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
}
