package com.designpattern.compositepattern.example;

/**
 * This implements the Employee Inteface and
 *
 */
public class IndividualContributor implements Employee{
    private String name;

    public IndividualContributor(String name){
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println(this.name);
    }
}
