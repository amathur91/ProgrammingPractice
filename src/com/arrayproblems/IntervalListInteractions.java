package com.arrayproblems;

import com.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;

/*
https://leetcode.com/problems/interval-list-intersections/
This is missing one handling for boundary values
 */
public class IntervalListInteractions {
    public static void main(String args[]){
        int[][] A = {{4,6}, {7,8},{10,17}};
        int[][] B = {{5,10}};
        Solution solution = new Solution();
        int[][] result = solution.intervalIntersection(A, B);
        for(int index = 0 ; index < result.length; index++){
            System.out.println(result[index][0] + "," + result[index][1]);
        }
    }
}
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<IntervalNode> list = new ArrayList<>();
        IntervalNode rootNode = buildIntervalTree(A, 0,A.length - 1);
        //we need to insert the B into A and check for the conflict
        for(int secondIndex = 0; secondIndex < B.length ; secondIndex++){
            IntervalNode newNode = new IntervalNode(B[secondIndex][0], B[secondIndex][1]);
            insertNewNodeToIntervalTree(newNode, rootNode, list);
        }

        list.sort(new Comparator<IntervalNode>() {
            @Override
            public int compare(IntervalNode o1, IntervalNode o2) {
                return o1.getStart() - o2.getStart();
            }
        });
        int size = list.size();
        int[][] result = new int[size][2];
        for(int rowIndex = 0 ; rowIndex < size ; rowIndex++){
            result[rowIndex][0] = list.get(rowIndex).getStart();
            result[rowIndex][1] = list.get(rowIndex).getEnd();
        }
        return result;
    }

    private void insertNewNodeToIntervalTree(IntervalNode newNode, IntervalNode rootNode, ArrayList<IntervalNode> list) {
           if(rootNode != null){
               //check for conflict
               //check if current Node is leaf
               //if not leaf send it to left or right
               checkAndHandleConflict(newNode, rootNode, list);
               if(newNode.getStart() <= rootNode.getStart()){
                   if(rootNode.getLeftChild() == null) {
                       rootNode.setLeftChild(newNode);
                   }else{
                       insertNewNodeToIntervalTree(newNode, rootNode.getLeftChild(), list);
                   }
               }else{
                   if(rootNode.getRightChild() == null){
                       rootNode.setRightChild(newNode);
                   }else{
                       insertNewNodeToIntervalTree(newNode, rootNode.getRightChild(), list);
                   }
               }
           }
    }

    private void checkAndHandleConflict(IntervalNode newNode, IntervalNode rootNode, ArrayList<IntervalNode> list) {
       IntervalNode leftNode = null, rightNode = null;
       if(rootNode.getStart() <= newNode.getStart()){
           leftNode = rootNode;
           rightNode = newNode;
       }else{
           leftNode = newNode;
           rightNode = rootNode;
       }
        //left border overlapping
        if(leftNode.getStart() == rightNode.getStart()){
            if(leftNode.getEnd() < rightNode.getEnd()){
                list.add(new IntervalNode(leftNode.getStart(), leftNode.getEnd()));
            }else{
                list.add(new IntervalNode(leftNode.getStart(), rightNode.getEnd()));
            }
        }

        //right border overlapping
        else if(leftNode.getEnd() == rightNode.getStart()){
            list.add(new IntervalNode(leftNode.getEnd(), rightNode.getStart()));
        }

        //left cross overlapping
        else if(leftNode.getEnd() <= rightNode.getEnd() && leftNode.getEnd() > rightNode.getStart()){
            list.add(new IntervalNode(rightNode.getStart(), leftNode.getEnd()));
        }

        //right cross overlapping
        else if(leftNode.getEnd() >= rightNode.getEnd() && leftNode.getStart() < rightNode.getStart()){
            list.add(new IntervalNode(rightNode.getStart(), rightNode.getEnd()));
        }
    }

    private IntervalNode buildIntervalTree(int[][] a, int start, int end) {
        if(start == end){
            return new IntervalNode(a[start][0], a[start][1]);
        }
        else if(start < end){
            int mid = (start + end) / 2;
            IntervalNode rootNode = new IntervalNode(a[mid][0],a[mid][1]);
            IntervalNode leftChild = buildIntervalTree(a, start, mid - 1);
            rootNode.setLeftChild(leftChild);
            IntervalNode rightChild = buildIntervalTree(a, mid + 1, end);
            rootNode.setRightChild(rightChild);
            return rootNode;
        }
        return null;
    }
}

class IntervalNode{
    private int start;
    private int end;
    private IntervalNode leftChild;
    private IntervalNode rightChild;
    private int leftMin;
    private int rightMin;

    public IntervalNode(int start, int end){
        this.start = start;
        this.end = end;
    }

    public IntervalNode getLeftChild() {
        return leftChild;
    }

    public int getLeftMin() {
        return leftMin;
    }

    public void setLeftMin(int leftMin) {
        this.leftMin = leftMin;
    }

    public int getRightMin() {
        return rightMin;
    }

    public void setRightMin(int rightMin) {
        this.rightMin = rightMin;
    }

    public void setLeftChild(IntervalNode leftChild) {
        this.leftChild = leftChild;
    }

    public IntervalNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(IntervalNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
