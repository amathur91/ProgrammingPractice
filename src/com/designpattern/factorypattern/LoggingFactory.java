package com.designpattern.factorypattern;

import java.util.HashMap;
import java.util.List;

public class LoggingFactory {
    private static HashMap<String, LoggerService> loggerServiceRegistry = new HashMap<>();

    /**
     * Replace the below code with more sophisticated mechanism of scanning the package where the
     * classes will be present.
     */
    static {
        try {
            Class.forName("com.designpattern.factorypattern.NetworkLogger");
            Class.forName("com.designpattern.factorypattern.PrintLogger");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static LoggerService getLoggerService(String loggerService){
        if(loggerServiceRegistry.containsKey(loggerService)){
            return loggerServiceRegistry.get(loggerService);
        }
        return null;
    }

    public static void registerLoggerService(String loggerService, LoggerService serviceInstance){
        if (loggerService != null &&  serviceInstance != null){
            loggerServiceRegistry.put(loggerService, serviceInstance);
        }
    }

}
