package com.iamlook.event;

import com.alibaba.fastjson.JSON;
import com.iamlook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/***************************************
 * @Project notes
 * @Description 自定义事件处理监听
 * @Author yx
 * @Date 19-6-11
 * @Version 1.0
 ***************************************/
@Component
public class MyListener implements ApplicationListener<MyEvent> {

    @Autowired
    private IUserService userService;

    /**
     *
     * ThreadPoolConfig
     *
     * @param myEvent
     */

    @Async
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        try {
            Thread.sleep(10000);
            System.out.println("自定义事件处理监听:" + myEvent.getName());
            System.out.println("自定义事件处理监听:" + myEvent.getMsg());
            System.out.println("自定义事件处理监听:" + myEvent.getSource());
            System.out.println(JSON.toJSONString(userService.testUpCase()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
