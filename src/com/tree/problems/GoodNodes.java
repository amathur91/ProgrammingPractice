package com.tree.problems;

import com.sun.source.tree.Tree;

import java.util.HashSet;

public class GoodNodes {
    public static void main(String args[]){
        TreeNode root =new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        GoodNodes goodNodes = new GoodNodes();
        int total = goodNodes.goodNodes(root);
        System.out.println(total);
    }

    public int goodNodes(TreeNode root) {
        HashSet<TreeNode> goodNodeSet = new HashSet<>();
        traverseAndFindGoodNodes(root, goodNodeSet, root.val);
        return goodNodeSet.size();
    }

    private void traverseAndFindGoodNodes(TreeNode root, HashSet<TreeNode> goodNodeSet, int val) {
        if(root != null){
            if(root.val >= val){
                goodNodeSet.add(root);
            }
            traverseAndFindGoodNodes(root.left, goodNodeSet, Math.max(root.val, val));
            traverseAndFindGoodNodes(root.right, goodNodeSet, Math.max(root.val, val));
        }
    }
}
