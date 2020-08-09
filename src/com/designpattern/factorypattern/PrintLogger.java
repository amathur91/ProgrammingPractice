package com.designpattern.factorypattern;

public class PrintLogger implements LoggerService {

    static {
        LoggingFactory.registerLoggerService("PrintLogger", new PrintLogger());
    }

    @Override
    public void log(String message) {
        System.out.println("Print Logging : " + message);
    }
}
