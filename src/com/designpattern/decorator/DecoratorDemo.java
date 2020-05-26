package com.designpattern.decorator;

/**
 * This is a demo of decorator pattern.
 * We first draw a square but then want a border around it.
 * How do we achieve it?
 * We do this by creating a decorator abstract class and specific class
 * and then simply adding the second line in main does the job.
 */
public class DecoratorDemo {
    public static void main(String args[]){
        Shape shape = new Square();
        //If you comment below one line then square will be drawn without border
        shape = new BorderSquare(shape);
        shape.draw();
    }
}
