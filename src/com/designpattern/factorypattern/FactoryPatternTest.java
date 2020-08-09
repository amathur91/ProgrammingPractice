package com.designpattern.factorypattern;

import org.junit.Test;

/**
 * We created a Interface which all the logger implmentations will inherit and override
 * Now we can create a factory: LoggingFactory to which all the services register
 * when the JVM/Service Startup and client can simply pass the service they require
 * The LoggingFactory contains a hashmap which is a service registry where we can lookup
 * for the service that are availble.
 * As with more logging service build overtime, they can register and be available
 * as the need arise.
 * The code is decoupled and shows the implementation of Factory Pattern.
 *
 */
public class FactoryPatternTest {

    @Test
    public void test1(){
        LoggerService printLoggerService = LoggingFactory.getLoggerService("PrintLogger");
        printLoggerService.log("Hello Print Logger");
        assert printLoggerService != null;
    }

    @Test
    public void test2(){
        LoggerService networkLoggerService = LoggingFactory.getLoggerService("NetworkLogger");
        networkLoggerService.log("Hello network Logger");
        assert networkLoggerService != null;
    }


}
