package com.tree.problems;

public class BSTNode{
    private int data;
    private BSTNode leftChild;
    private BSTNode rightChild;
    private int leftChildCount;
    private int originalIndex;

    public BSTNode(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getOriginalIndex() {
        return originalIndex;
    }

    public void setOriginalIndex(int originalIndex) {
        this.originalIndex = originalIndex;
    }

    public int getLeftChildCount() {
        return leftChildCount;
    }

    public void setLeftChildCount(int leftChildCount) {
        this.leftChildCount = leftChildCount;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }
}
