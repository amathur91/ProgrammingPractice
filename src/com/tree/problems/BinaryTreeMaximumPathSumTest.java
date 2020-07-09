package com.tree.problems;

import org.junit.Test;

public class BinaryTreeMaximumPathSumTest {
    BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();

    @Test
    public void test1(){
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        int result = binaryTreeMaximumPathSum.maxPathSum(rootNode);
        assert result == 6;
    }

    @Test
    public void test2(){
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int result = binaryTreeMaximumPathSum.maxPathSum(root);
        assert result == 42;

    }

    @Test
    public void test3(){
        TreeNode rootNode = new TreeNode(2);
        rootNode.right = new TreeNode(-1);
        int result = binaryTreeMaximumPathSum.maxPathSum(rootNode);
        assert result == 2;
    }
}
