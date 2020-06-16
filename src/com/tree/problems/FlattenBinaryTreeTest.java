package com.tree.problems;

import org.junit.Test;

public class FlattenBinaryTreeTest {

    @Test
    public void test1(){
        FlattenBinaryTree.BinaryTree rootNode = new FlattenBinaryTree.BinaryTree(1);
        rootNode.left = new FlattenBinaryTree.BinaryTree(2);
        rootNode.left.left = new FlattenBinaryTree.BinaryTree(4);
        rootNode.left.right = new FlattenBinaryTree.BinaryTree(5);
        rootNode.left.right.left = new FlattenBinaryTree.BinaryTree(7);
        rootNode.left.right.right = new FlattenBinaryTree.BinaryTree(8);
        rootNode.right = new FlattenBinaryTree.BinaryTree(3);
        rootNode.right.left = new FlattenBinaryTree.BinaryTree(6);
        FlattenBinaryTree.BinaryTree result = FlattenBinaryTree.flattenBinaryTree(rootNode);
        while(result != null){
            System.out.print(result.value + " ");
            result = result.right;
        }

    }
}
