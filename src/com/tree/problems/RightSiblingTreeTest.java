package com.tree.problems;

import org.junit.Test;

public class RightSiblingTreeTest {
    @Test
    public void test1(){
        RightSiblingTree.BinaryTree root = new RightSiblingTree.BinaryTree(1);
        root.left = new RightSiblingTree.BinaryTree(2);
        root.right = new RightSiblingTree.BinaryTree(3);
        root.left.left = new RightSiblingTree.BinaryTree(4);
        root.left.right = new RightSiblingTree.BinaryTree(5);
        root.left.left.left = new RightSiblingTree.BinaryTree(8);
        root.left.left.right = new RightSiblingTree.BinaryTree(9);
        root.left.right.right = new RightSiblingTree.BinaryTree(10);
        root.right.left = new RightSiblingTree.BinaryTree(6);
        root.right.left.left = new RightSiblingTree.BinaryTree(11);
        root.right.left.left.left = new RightSiblingTree.BinaryTree(14);
        root.right.right = new RightSiblingTree.BinaryTree(7);
        root.right.right.left = new RightSiblingTree.BinaryTree(12);
        root.right.right.right = new RightSiblingTree.BinaryTree(13);

        RightSiblingTree.BinaryTree modifiedTree = RightSiblingTree.rightSiblingTree(root);
        System.out.println("Debug");
    }
}
