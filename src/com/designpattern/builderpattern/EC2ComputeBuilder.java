package com.designpattern.builderpattern;

public class EC2ComputeBuilder implements EC2Builder{

    @Override
    public void reserveMachine() {
        //externalCall
    }

    @Override
    public boolean isMachineAvailable() {
        return false;
    }

    @Override
    public boolean isMachineReady() {
        return false;
    }

    @Override
    public void setupMachine() {
        EC2Configuration ec2Configuration = new EC2Compute();
        ec2Configuration.setupDNS("DNS");
        ec2Configuration.setupHostName("Localhost");
        ec2Configuration.setMemory(16);
        ec2Configuration.setHDDSize(50);
        ec2Configuration.installOperatingSystem("Ubuntu");
    }
}
