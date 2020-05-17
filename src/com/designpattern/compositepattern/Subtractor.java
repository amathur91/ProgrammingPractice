package com.designpattern.compositepattern;

public class Subtractor extends BinaryExpression {

    public Subtractor(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double getValue() {
        return this.left.getValue() - this.right.getValue();
    }
}
