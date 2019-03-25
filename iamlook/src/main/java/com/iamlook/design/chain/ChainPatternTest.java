package com.iamlook.design.chain;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-03-22 11:44
 **/
public class ChainPatternTest {


    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(1);
        AbstractLogger fileLogger = new FileLogger(2);
        AbstractLogger consoleLogger = new ConsoleLogger(3);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(1, "This is an information.");

        loggerChain.logMessage(2,
                "This is a debug level information.");

        loggerChain.logMessage(3,
                "This is an error information.");
    }


}
