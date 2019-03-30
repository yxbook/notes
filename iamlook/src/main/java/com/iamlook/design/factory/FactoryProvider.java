package com.iamlook.design.factory;

import org.springframework.util.StringUtils;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:49
 **/
public class FactoryProvider {

    private FactoryProvider() {
    }

    public static RegionAbstractFactory getFactory(String factoryType) {    //对外暴露api
        return getInstance(factoryType);
    }

    private static RegionAbstractFactory getInstance(String factoryType) {    //核心逻辑封装成私有方法
        if (StringUtils.isEmpty(factoryType)) return null;
        if ("tangshanCity".equalsIgnoreCase(factoryType)) {
            return new TangShanCity();
        } else return null;
    }
}
