package com.arrayproblems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximum-gap/submissions/
 * Level Hard
 * Time Complexity : O(n)
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        int result = 0;
        if(nums.length < 2){
            return 0;
        }
        BSTNode rootNode = buildBST(nums);
        Result result1 = new Result(0);
        Stack<Integer> compute = new Stack<>();
        traverseAndFindMaximumDifference(rootNode, compute, result1);
        return result1.getData();
    }

    private void traverseAndFindMaximumDifference(BSTNode rootNode, Stack<Integer> stack, Result result) {
       if(rootNode != null){
            traverseAndFindMaximumDifference(rootNode.getLeftChild(),stack, result);
            if(stack.isEmpty()){
                stack.push(rootNode.getData());
            }else{
                int previousValue = stack.pop();
                int currentValue = rootNode.getData();
                if(currentValue - previousValue > result.getData()){
                    result.setData(currentValue - previousValue);
                }
                stack.push(currentValue);
            }
            traverseAndFindMaximumDifference(rootNode.getRightChild(),stack, result);
       }
    }

    private BSTNode buildBST(int[] nums) {
        BSTNode rootNode = null;
        for(int index = 0; index < nums.length; index++){
            rootNode = addToBST(rootNode, nums[index]);
        }
        return rootNode;
    }

    private BSTNode addToBST(BSTNode rootNode, int num) {
        if(rootNode == null){
            return new BSTNode(num, null, null);
        }else if(rootNode.getData() > num){
            rootNode.setLeftChild(addToBST(rootNode.getLeftChild(), num));
        }else if(rootNode.getData() < num){
            rootNode.setRightChild(addToBST(rootNode.getRightChild(), num));
        }
        return rootNode;
    }
}

class BSTNode{
    private int data;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public BSTNode(int data, BSTNode leftChild, BSTNode rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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

class Result{
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Result(int data) {
        this.data = data;
    }
}