package com.proxypattern;

public class BusinessObjectProxy  extends BusinessObject {
    private BusinessObject businessObjectImplementation;

    public BusinessObjectProxy(BusinessObject businessObjectImplementation){
        this.businessObjectImplementation = businessObjectImplementation;
    }

    @Override
    public void sayHi() {
        //Do some preprocessing
        businessObjectImplementation.sayHi();
        //Do some post processing.
    }
}
