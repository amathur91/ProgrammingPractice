package com.designpattern.factorypattern;

public class NetworkLogger implements LoggerService {

    static {
        LoggingFactory.registerLoggerService("NetworkLogger", new NetworkLogger());
    }

    @Override
    public void log(String message) {
        System.out.println("Network Logger : " + message);
    }
}
