package com.iamlook.design.factory;


import org.junit.Test;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-25 10:42
 **/
public class PatternTest {


    @Test
    public void TestRealtyTest(){

       /* Realty realty = RealtyFactory.provider("custom");
        realty.excute();*/


        RegionAbstractFactory tangshan = FactoryProvider.getFactory("tangshanCity");
        RealtyFactory realtyFactory = tangshan.getRealtyFactory();
        Realty employee = realtyFactory.getInstance("employee");
        employee.excute();



    }
}
