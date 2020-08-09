package com.designpattern.compositepattern.example;

public class Manager implements Employee{
    private Employee engineer;
    private Employee reporteeEngineer;

    public Manager( Employee engineer, Employee directReportee){
        this.engineer = engineer;
        this.reporteeEngineer = directReportee;
    }

    @Override
    public void getName() {
        this.engineer.getName();
        this.reporteeEngineer.getName();
    }
}
