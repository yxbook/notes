package com.iamlook.design.factory;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:47
 **/
public class TangShanCity extends RegionAbstractFactory {
    //增加非静态化方法的原因在此，如果还有其它城市的话，都需要使用对象调用创建工厂方法。
    @Override
    public RealtyFactory getRealtyFactory() {
        return new RealtyFactory();
    }


}
