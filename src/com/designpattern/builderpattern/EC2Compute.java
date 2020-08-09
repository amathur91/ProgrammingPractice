package com.designpattern.builderpattern;

public class EC2Compute implements EC2Configuration{
    private String dns;
    private String hostName;
    private int memoryInGB;
    private int ramInGB;
    private String operatingSystem;

    @Override
    public void setupDNS(String dns) {
        this.dns = dns;
    }

    @Override
    public void setupHostName(String hostName) {
        this.hostName = hostName;
    }

    @Override
    public void setHDDSize(int memoryInGB) {
        this.memoryInGB = memoryInGB;
    }

    @Override
    public void setMemory(int ramInGB) {
        this.ramInGB = ramInGB;
    }

    @Override
    public void installOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
}
