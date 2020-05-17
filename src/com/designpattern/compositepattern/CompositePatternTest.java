package com.designpattern.compositepattern;

import org.junit.Test;

public class CompositePatternTest {

    @Test
    public void testAddition(){
        Expression expression = new Adder(new Constant(5), new Constant(6));
        assert expression.getValue() == 11;
    }

    @Test
    public void testComplexAddition(){
        Expression expression = new Adder(new Adder(new Constant(6), new Constant(54)),
                new Constant(100));
        assert expression.getValue() == 160;
    }

    @Test
    public void testSubtractorAndAddition(){
        /**
         * Think of Composite Pattern like a tree data structure. You may have a root
         * whose child may be a leaf or a tree in itself. So look at below code
         * there are two argument, the argument may be a terminal one or may be a
         * composite one(nested one)
         */
        Expression expression = new Adder(new Subtractor(new Constant(100), new Constant(50)),
                new Constant(50));
        assert expression.getValue() == 100;
    }
}
