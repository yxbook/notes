package com.iamlook.jdk8;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-04-08 09:45
 **/
public class LocalDateTimeTest {


    @Test
    public void testLocalTime(){


        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println("当前时间：" + currentTime);



        System.out.println(currentTime.getDayOfMonth());
        System.out.println(currentTime.getDayOfWeek());
        System.out.println(currentTime.getDayOfYear());
        System.out.println(currentTime.toLocalDate());
        System.out.println(currentTime.toLocalTime());


        System.out.println(currentTime.getMonth());
        System.out.println(currentTime.getSecond());

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);

    }
}
