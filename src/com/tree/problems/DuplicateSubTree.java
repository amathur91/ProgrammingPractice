package com.tree.problems;

import java.util.HashSet;
import java.util.concurrent.Phaser;

public class DuplicateSubTree {
    private static boolean duplicate = false;
    public static void main(String args[]){
        /**
         *  Sample Tree
         *          1
         *        /  \
         *       2    5
         *      / \    \
         *     3   4    2
         *             / \
         *            3   4
         */
        TreeNode rootNode = new TreeNode(1);
        rootNode.setLeftChild(new TreeNode(2));
        rootNode.getLeftChild().setLeftChild(new TreeNode(3));
        rootNode.getLeftChild().setRightChild(new TreeNode(4));
        rootNode.setRightChild(new TreeNode(5));
        rootNode.getRightChild().setRightChild(new TreeNode(2));
        rootNode.getRightChild().getRightChild().setLeftChild(new TreeNode(3));
        rootNode.getRightChild().getRightChild().setRightChild(new TreeNode(4));
        boolean duplicateSubTreeExists = findDuplicateSubTree(rootNode);
        System.out.println("Duplicate Subtree exist : " + duplicateSubTreeExists);
    }

    private static boolean findDuplicateSubTree(TreeNode rootNode) {
        HashSet<String> subTreeSet = new HashSet<>();
        lookForDuplicateSubTree(rootNode, subTreeSet);
        return duplicate;
    }

    private static String lookForDuplicateSubTree(TreeNode rootNode, HashSet<String> subTreeSet) {
      if(rootNode != null){
          String leftChild = lookForDuplicateSubTree(rootNode.getLeftChild(), subTreeSet);
          String rightChild = lookForDuplicateSubTree(rootNode.getRightChild(), subTreeSet);
          String set = String.valueOf(rootNode.getData()) + leftChild + rightChild;
          if(subTreeSet.contains(set) && set.length() > 2){
              duplicate = true;
              return set;
          }else{
              subTreeSet.add(set);
              return set;
          }
      }
      return "";
    }

    private static boolean isLeafNode(TreeNode rootNode) {
        return rootNode.getLeftChild() == null && rootNode.getRightChild() == null;
    }
}
