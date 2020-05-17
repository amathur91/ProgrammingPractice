package com.proxypattern;

public abstract class BusinessObject {
    public abstract void sayHi();

    public static BusinessObject createBusinessObject(){
        return new BusinessObjectImplementation();
    }
}
