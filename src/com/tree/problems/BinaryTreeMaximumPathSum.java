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
            Integer leftSubtreeSum = findMaximumSum(root.left, maximumSum);
            if(leftSubtreeSum != null && leftSubtreeSum > maximumSum.getData()){
                maximumSum.setData(leftSubtreeSum);
            }
            Integer rightSubtreeSum = findMaximumSum(root.right, maximumSum);
            if(rightSubtreeSum != null && rightSubtreeSum > maximumSum.getData()){
                maximumSum.setData(rightSubtreeSum);
            }

            if(root.val > maximumSum.getData()){
                maximumSum.setData(root.val);
            }
            if(leftSubtreeSum != null && (root.val + leftSubtreeSum) > maximumSum.getData()){
                maximumSum.setData(root.val + leftSubtreeSum);
            }
            if(rightSubtreeSum != null && (root.val + rightSubtreeSum) > maximumSum.getData()){
                maximumSum.setData(root.val + rightSubtreeSum);
            }
            int leftPrioritySum = 0;
            int rightPrioritySum = 0;
            if(leftSubtreeSum != null){
                leftPrioritySum += leftSubtreeSum;
            }
            if(rightSubtreeSum != null){
                rightPrioritySum += rightSubtreeSum;
            }
            if(leftPrioritySum + rightPrioritySum + root.val > maximumSum.getData()){
                maximumSum.setData(leftPrioritySum + rightPrioritySum + root.val);
            }
            return Math.max((root.val+ leftPrioritySum), (root.val+rightPrioritySum));
        }
        return null;
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