package com.iamlook.design.chain;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-22 11:40
 **/
public class ConsoleLogger extends  AbstractLogger{

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {

        System.out.println("ConsoleLogger Console::Logger: " + message);

    }
}
