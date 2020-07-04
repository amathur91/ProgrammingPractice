package com.tree.problems;

import org.junit.Test;

public class IterativeTraversalTest {
    @Test
    public void test1(){
        IterativeInOrderTraversal.BinaryTree binaryTree = new IterativeInOrderTraversal.BinaryTree(1);
        binaryTree.left = new IterativeInOrderTraversal.BinaryTree(2);
        binaryTree.left.left = new IterativeInOrderTraversal.BinaryTree(4);
        binaryTree.left.left.right = new IterativeInOrderTraversal.BinaryTree(9);
        binaryTree.right = new IterativeInOrderTraversal.BinaryTree(3);
        binaryTree.right.left = new IterativeInOrderTraversal.BinaryTree(6);
        binaryTree.right.right = new IterativeInOrderTraversal.BinaryTree(7);
        IterativeInOrderTraversal.iterativeInOrderTraversal(binaryTree, null);
    }
}
