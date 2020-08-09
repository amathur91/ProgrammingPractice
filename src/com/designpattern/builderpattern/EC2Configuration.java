package com.designpattern.builderpattern;

public interface EC2Configuration {
    public void setupDNS(String dns);
    public void setupHostName(String hostName);
    public void setHDDSize(int memoryInGB);
    public void setMemory(int ramInGB);
    public void installOperatingSystem(String operatingSystem);
}
