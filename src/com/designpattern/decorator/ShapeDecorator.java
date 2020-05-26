package com.designpattern.decorator;

public abstract class ShapeDecorator implements Shape{

    public Shape bodyShape;

    public ShapeDecorator(Shape bodyShape){
        this.bodyShape = bodyShape;
    }

}
