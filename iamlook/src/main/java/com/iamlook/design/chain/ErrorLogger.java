package com.iamlook.design.chain;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-22 11:40
 **/
public class ErrorLogger extends  AbstractLogger{

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void excute(String message) {

        System.out.println("ErrorLogger Console::Logger: " + message);

    }
}
