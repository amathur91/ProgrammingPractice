package com.designpattern.decorator;

public class BorderSquare extends ShapeDecorator{
    public BorderSquare(Shape bodyShape) {
        super(bodyShape);
    }

    @Override
    public void draw() {
        System.out.println("Drawing Border");
        bodyShape.draw();
        System.out.println("Drawing Border");
    }
}
