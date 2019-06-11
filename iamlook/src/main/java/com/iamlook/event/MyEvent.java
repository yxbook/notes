package com.iamlook.event;

import org.springframework.context.ApplicationEvent;

/***************************************
 * @Project notes
 * @Description 自定义ApplicationEvent
 * @Author yx
 * @Date 19-6-11
 * @Version 1.0
 ***************************************/
public class MyEvent extends ApplicationEvent {

    private String name;

    private String msg;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, String name, String msg){
        super(source);
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }
}
