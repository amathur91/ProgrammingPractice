package com.designpattern.builderpattern;

public interface EC2Builder {

    public void reserveMachine();

    public boolean isMachineAvailable();

    public boolean isMachineReady();

    public void setupMachine();

}
