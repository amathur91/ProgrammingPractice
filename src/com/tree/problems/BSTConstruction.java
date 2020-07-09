package com.tree.problems;

public class BSTConstruction {
    public static void main(String args[]){
        /**
         *      10
         *     /  \
         *    5   40
         *   / \    \
         *  1   7   50
         */
        int[] preorderTraversal = {10, 5, 1, 7, 40, 50};
        BinaryTreeNode rootNode = buildTreeFromPreorderTraversal(preorderTraversal);
        System.out.println("Print Tree Traversal");
        printTreeTraversal(rootNode, Traversal.PREORDER);

        int[] postOrderTraversal = {1, 7, 5, 50, 40, 10};
        BinaryTreeNode postOrderGenerated = buildTreeFromPostOrderTraversal(postOrderTraversal);
        System.out.println("\nPrint Tree Traversal");
        printTreeTraversal(postOrderGenerated, Traversal.POSTORDER);


        /**
         * Reconstruction is not possible from just Inorder Traversal of BST. Hence we are
         * showing that the constructed tree is not the same.
         */
        int[] inorderTraversal = {1, 5, 7, 10, 40, 50};
        BinaryTreeNode inorderGeneratedTree = buildTreeFromInOrderTraversal(inorderTraversal);
        System.out.println("Debug");
    }

    private static BinaryTreeNode buildTreeFromInOrderTraversal(int[] inorderTraversal) {
        if(inorderTraversal.length == 1){
            return new BinaryTreeNode(inorderTraversal[0]);
        }else if(inorderTraversal.length == 0){
            return null;
        }else{
            int start = 0; 
            int end = inorderTraversal.length - 1;
            int mid = (start + end) / 2;
            BinaryTreeNode rootNode = new BinaryTreeNode(inorderTraversal[mid]);
            rootNode.setLeftChild(addInorderNodeToTree(inorderTraversal, start, mid - 1));
            rootNode.setRightChild(addInorderNodeToTree(inorderTraversal, mid + 1, end));
            return rootNode;
        }
    }

    private static BinaryTreeNode addInorderNodeToTree(int[] inorderTraversal, int start, int end) {
       if(start == end){
           return new BinaryTreeNode(inorderTraversal[start]);
       }else if(start < end && end < inorderTraversal.length){
           int mid = (start + end) / 2;
           BinaryTreeNode node = new BinaryTreeNode(inorderTraversal[mid]);
           node.setLeftChild(addInorderNodeToTree(inorderTraversal, start, mid - 1));
           node.setRightChild(addInorderNodeToTree(inorderTraversal, mid + 1, end));
           return node;
       }
       return null;
    }

    private static BinaryTreeNode buildTreeFromPostOrderTraversal(int[] postOrderTraversal) {
        if(postOrderTraversal.length > 0) {
            BinaryTreeNode rootNode = new BinaryTreeNode(postOrderTraversal[postOrderTraversal.length - 1]);
            for (int index = postOrderTraversal.length - 2; index >= 0; index--) {
                addNodeToTree(postOrderTraversal[index], rootNode);
            }
            return rootNode;
        }
        return null;
    }

    private static BinaryTreeNode buildTreeFromPreorderTraversal(int[] preorderTraversal) {
        if(preorderTraversal.length > 0) {
            BinaryTreeNode rootNode = new BinaryTreeNode(preorderTraversal[0]);
            for (int index = 1; index < preorderTraversal.length; index++) {
                addNodeToTree(preorderTraversal[index], rootNode);
            }
            return rootNode;
        }
        return null;
    }

    private static void addNodeToTree(int data, BinaryTreeNode rootNode) {
      if(isLeafNode(rootNode)){
          if(data > rootNode.getData()){
              rootNode.setRightChild(new BinaryTreeNode(data));
          }else{
              rootNode.setLeftChild(new BinaryTreeNode(data));
          }
      }else{
          if(data > rootNode.getData()){
              if(rootNode.getRightChild() == null){
                  rootNode.setRightChild(new BinaryTreeNode(data));
              }else {
                  addNodeToTree(data, rootNode.getRightChild());
              }
          }else{
              if(rootNode.getLeftChild() == null){
                    rootNode.setLeftChild(new BinaryTreeNode(data));
              }else {
                  addNodeToTree(data, rootNode.getLeftChild());
              }
          }
      }
    }

    private static boolean isLeafNode(BinaryTreeNode rootNode) {
        return rootNode.getLeftChild() == null && rootNode.getRightChild() == null;
    }

    private static void printTreeTraversal(BinaryTreeNode root, Traversal traversal){
        if(root != null){
            if(traversal == Traversal.INORDER){
                printTreeTraversal(root.getLeftChild(), traversal);
                System.out.print(root.getData() + " ");
                printTreeTraversal(root.getRightChild(), traversal);
            }else if(traversal == Traversal.POSTORDER){
                printTreeTraversal(root.getLeftChild(), traversal);
                printTreeTraversal(root.getRightChild(), traversal);
                System.out.print(root.getData() + " ");
            }else{
                System.out.print(root.getData() + " ");
                printTreeTraversal(root.getLeftChild(), traversal);
                printTreeTraversal(root.getRightChild(), traversal);
            }
        }
    }
}

enum Traversal{
    POSTORDER, PREORDER, INORDER
}

