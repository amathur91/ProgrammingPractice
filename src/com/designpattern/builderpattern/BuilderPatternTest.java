package com.designpattern.builderpattern;

import org.junit.Test;

/**
 * So we are taking example of AWS EC2 in builder pattern.
 * We assume EC2 is resource that requires lot of setup and parameters
 * EC2ConfigurationInterface is extended by EC2Compute, EC2ComputeMemory etc
 * EC2Builder is another interface that contains method to build the specific type of resource
 * AWSService takes an object of type EC2Builder and execute the setup plan on it
 */
public class BuilderPatternTest {

    @Test
    public void test1(){
        //EC2Builder takes all the required parameters to setup the EC2 Machine.
        EC2Builder ec2Builder = new EC2ComputeBuilder();
        AWSService awsService = new AWSService();
        //AWSService takes the instance of type EC2Builder and execute the method to build the infrastructure.
        awsService.buildEC2(ec2Builder);
    }
}
