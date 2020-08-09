package com.designpattern.compositepattern.example;

import org.junit.Test;

/**
 * Usage Examples of the Composite Design Pattern.
 * Here we are taking examples of the Company Structure where
 * A director can have a manager or a IC(leaf node) as direct reportee.
 * So this is an example of Composite Design Pattern.
 */
public class CompositePatternExampleTest {
    @Test
    public void test1(){
        Employee employee = new IndividualContributor("Ankit");
        Employee manager = new Manager(new IndividualContributor("Vivek"), employee);
        manager.getName();
    }

    @Test
    public void test2(){
        Employee director = new Manager(new IndividualContributor("Vijay"),
                new Manager(new IndividualContributor("Vivek"), new IndividualContributor("Ankit")));
        director.getName();
    }
}
