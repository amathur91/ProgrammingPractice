package com.tree.problems;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/
 * Solution for BinaryTree Maximum Path Question
 * Time Complexity : O(n)
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        MaximumSum maximumSum = new MaximumSum(Integer.MIN_VALUE);
        findMaximumSum(root, maximumSum);
        return maximumSum.getData();
    }

    private Integer findMaximumSum(TreeNode root, MaximumSum maximumSum) {
        if(root != null){
            Integer leftSubtreeSum = Math.max(0,findMaximumSum(root.left, maximumSum));
            Integer rightSubtreeSum = Math.max(0,findMaximumSum(root.right, maximumSum));
            maximumSum.setData(Math.max(maximumSum.getData(), root.val
            + leftSubtreeSum + rightSubtreeSum));
            return Math.max(leftSubtreeSum, rightSubtreeSum) + root.val;
        }
        return 0;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class MaximumSum{
    private int data;

    public MaximumSum(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}