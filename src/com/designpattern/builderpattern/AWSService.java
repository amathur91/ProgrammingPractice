package com.designpattern.builderpattern;

public class AWSService {

    public void buildEC2(EC2Builder ec2Builder){
        if(ec2Builder.isMachineAvailable()) {
            ec2Builder.reserveMachine();
            ec2Builder.setupMachine();
        }
        //code to wait for some time
    }
}
