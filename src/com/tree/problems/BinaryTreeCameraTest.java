package com.tree.problems;

import com.sun.source.tree.Tree;
import org.junit.Test;

public class BinaryTreeCameraTest {
    BinaryTreeCamera binaryTreeCamera = new BinaryTreeCamera();

    @Test
    public void test1(){
        TreeNode rootNode = new TreeNode(0);
        rootNode.left = new TreeNode(0);
        rootNode.left.left = new TreeNode(0);
        rootNode.left.right = new TreeNode(0);
        int result = binaryTreeCamera.minCameraCover(rootNode);
        assert result == 1;
    }


    @Test
    public void test2(){
        TreeNode rootNode = new TreeNode(0);
        rootNode.left = new TreeNode(0);
        rootNode.left.left = new TreeNode(0);
        rootNode.left.left.left = new TreeNode(0);
        rootNode.left.left.left.right = new TreeNode(0);
        int result = binaryTreeCamera.minCameraCover(rootNode);
        assert result == 2;
    }

    @Test
    public void test3(){
        TreeNode rootNode = new TreeNode(0);
        int result = binaryTreeCamera.minCameraCover(rootNode);
        assert result == 1;
    }

    @Test
    public void test5(){
        TreeNode rootNode = new TreeNode(0);
        
        int result = binaryTreeCamera.minCameraCover(rootNode);
        assert result == 1;
    }

    @Test
    public void test4(){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.left = new TreeNode(0);
        root.left.left.left.right = new TreeNode(0);
        int result = binaryTreeCamera.minCameraCover(root);
        assert result == 2;

    }

    @Test
    public void test6(){
        TreeNode rootNode = new TreeNode(0);
        rootNode.right = new TreeNode(0);
        rootNode.right.right = new TreeNode(0);
        rootNode.right.right.right = new TreeNode(0);
        int result = binaryTreeCamera.minCameraCover(rootNode);
        assert result == 2;
    }

    @Test
    public void test7(){
        TreeNode rootNode = new TreeNode(0);
        rootNode.left = new TreeNode(0);
        rootNode.left.right = new TreeNode(0);
        rootNode.left.right.left = new TreeNode(0);
        rootNode.left.right.left.right = new TreeNode(0);
        rootNode.left.right.left.right.left = new TreeNode(0);
        int result = binaryTreeCamera.minCameraCover(rootNode);
        assert result == 2;
    }

    @Test
    public void test8(){
        TreeNode rootNode = new TreeNode(0);
        rootNode.left = new TreeNode(0);
        rootNode.left.left = new TreeNode(0);
        rootNode.left.left.right = new TreeNode(0);
        rootNode.left.left.left = new TreeNode(0);
        rootNode.left.left.left.right = new TreeNode(0);
        rootNode.left.left.left.left = new TreeNode(0);
        rootNode.left.left.left.left.left = new TreeNode(0);
        int result = binaryTreeCamera.minCameraCover(rootNode);
        assert result == 4;
    }

}
