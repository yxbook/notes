package com.iamlook.design.chain;

/**
 * @program: notes
 * @description: 责任链模式妙用
 * @author: Created by youxun
 **/
public abstract class AbstractLogger {

    /*
    判断是否进入下一个节点参数
     */
    protected int level;

    /*
    下一个责任点
     */
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level <= level){
            /*
            如果当前节点可以处理，直接处理
             */
            excute(message);
        }
        /*
          如果当前节点不能处理，并且有下个节点，交由下个节点处理
         */
        if(null != nextLogger){
            nextLogger.logMessage(level, message);
        }
    }

    /*
    执行业务逻辑代码
     */
    abstract protected void excute(String message);

}
