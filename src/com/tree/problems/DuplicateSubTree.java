package com.tree.problems;

import java.util.HashSet;

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
        BinaryTreeNode rootNode = new BinaryTreeNode(1);
        rootNode.setLeftChild(new BinaryTreeNode(2));
        rootNode.getLeftChild().setLeftChild(new BinaryTreeNode(3));
        rootNode.getLeftChild().setRightChild(new BinaryTreeNode(4));
        rootNode.setRightChild(new BinaryTreeNode(5));
        rootNode.getRightChild().setRightChild(new BinaryTreeNode(2));
        rootNode.getRightChild().getRightChild().setLeftChild(new BinaryTreeNode(3));
        rootNode.getRightChild().getRightChild().setRightChild(new BinaryTreeNode(4));
        boolean duplicateSubTreeExists = findDuplicateSubTree(rootNode);
        System.out.println("Duplicate Subtree exist : " + duplicateSubTreeExists);
    }

    private static boolean findDuplicateSubTree(BinaryTreeNode rootNode) {
        HashSet<String> subTreeSet = new HashSet<>();
        lookForDuplicateSubTree(rootNode, subTreeSet);
        return duplicate;
    }

    private static String lookForDuplicateSubTree(BinaryTreeNode rootNode, HashSet<String> subTreeSet) {
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

    private static boolean isLeafNode(BinaryTreeNode rootNode) {
        return rootNode.getLeftChild() == null && rootNode.getRightChild() == null;
    }
}
