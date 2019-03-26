package com.iamlook.service;

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

    List queryUserList2(HashMap paraMap);
}
