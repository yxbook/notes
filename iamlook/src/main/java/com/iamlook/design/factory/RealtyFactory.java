package com.iamlook.design.factory;

import org.springframework.util.StringUtils;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:38
 **/
public class RealtyFactory {

        //对外暴露api，强调一点：返回值为Realty，使用多态特性，达到引用扩大化，多态是工厂模式核心。
    public static Realty provider(String realtyType){
        return getRealtyInstance(realtyType);
    }

    //增加非静态化方法，具体原因将从下文展开。
    public Realty getInstance(String realtyType){
        return getRealtyInstance(realtyType);
    }

    private static Realty getRealtyInstance(String realtyType) {
        if (StringUtils.isEmpty(realtyType)) return null;
        if ("employee".equalsIgnoreCase(realtyType)){
            return new Employee();
        }else if ("house".equalsIgnoreCase(realtyType)){
            return new HouseOwner();
        }else if("custom".equalsIgnoreCase(realtyType)){
            return new CustomLer();
        }else return null;

    }
}
