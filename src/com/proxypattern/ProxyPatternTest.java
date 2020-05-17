package com.proxypattern;

import org.junit.Test;

public class ProxyPatternTest {

    @Test
    public void testProxyPattern(){
        /**
         * Here in the Proxy pattern we basically hide the implementation under a
         * proxy wrapper to do some sort of preprocessing or post processing which could be
         * some security related stuff or logging or remote service initialization.
         *
         * This patter is also used in conjunction with Factory Pattern.
         */
        BusinessObject businessInterface = BusinessObject.createBusinessObject();
        businessInterface.sayHi();
    }
}
