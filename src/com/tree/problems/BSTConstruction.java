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
        TreeNode rootNode = buildTreeFromPreorderTraversal(preorderTraversal);
        System.out.println("Print Tree Traversal");
        printTreeTraversal(rootNode, Traversal.PREORDER);

        int[] postOrderTraversal = {1, 7, 5, 50, 40, 10};
        TreeNode postOrderGenerated = buildTreeFromPostOrderTraversal(postOrderTraversal);
        System.out.println("\nPrint Tree Traversal");
        printTreeTraversal(postOrderGenerated, Traversal.POSTORDER);


        /**
         * Reconstruction is not possible from just Inorder Traversal of BST. Hence we are
         * showing that the constructed tree is not the same.
         */
        int[] inorderTraversal = {1, 5, 7, 10, 40, 50};
        TreeNode inorderGeneratedTree = buildTreeFromInOrderTraversal(inorderTraversal);
        System.out.println("Debug");
    }

    private static TreeNode buildTreeFromInOrderTraversal(int[] inorderTraversal) {
        if(inorderTraversal.length == 1){
            return new TreeNode(inorderTraversal[0]);
        }else if(inorderTraversal.length == 0){
            return null;
        }else{
            int start = 0; 
            int end = inorderTraversal.length - 1;
            int mid = (start + end) / 2;
            TreeNode rootNode = new TreeNode(inorderTraversal[mid]);
            rootNode.setLeftChild(addInorderNodeToTree(inorderTraversal, start, mid - 1));
            rootNode.setRightChild(addInorderNodeToTree(inorderTraversal, mid + 1, end));
            return rootNode;
        }
    }

    private static TreeNode addInorderNodeToTree(int[] inorderTraversal, int start, int end) {
       if(start == end){
           return new TreeNode(inorderTraversal[start]);
       }else if(start < end && end < inorderTraversal.length){
           int mid = (start + end) / 2;
           TreeNode node = new TreeNode(inorderTraversal[mid]);
           node.setLeftChild(addInorderNodeToTree(inorderTraversal, start, mid - 1));
           node.setRightChild(addInorderNodeToTree(inorderTraversal, mid + 1, end));
           return node;
       }
       return null;
    }

    private static TreeNode buildTreeFromPostOrderTraversal(int[] postOrderTraversal) {
        if(postOrderTraversal.length > 0) {
            TreeNode rootNode = new TreeNode(postOrderTraversal[postOrderTraversal.length - 1]);
            for (int index = postOrderTraversal.length - 2; index >= 0; index--) {
                addNodeToTree(postOrderTraversal[index], rootNode);
            }
            return rootNode;
        }
        return null;
    }

    private static TreeNode buildTreeFromPreorderTraversal(int[] preorderTraversal) {
        if(preorderTraversal.length > 0) {
            TreeNode rootNode = new TreeNode(preorderTraversal[0]);
            for (int index = 1; index < preorderTraversal.length; index++) {
                addNodeToTree(preorderTraversal[index], rootNode);
            }
            return rootNode;
        }
        return null;
    }

    private static void addNodeToTree(int data, TreeNode rootNode) {
      if(isLeafNode(rootNode)){
          if(data > rootNode.getData()){
              rootNode.setRightChild(new TreeNode(data));
          }else{
              rootNode.setLeftChild(new TreeNode(data));
          }
      }else{
          if(data > rootNode.getData()){
              if(rootNode.getRightChild() == null){
                  rootNode.setRightChild(new TreeNode(data));
              }else {
                  addNodeToTree(data, rootNode.getRightChild());
              }
          }else{
              if(rootNode.getLeftChild() == null){
                    rootNode.setLeftChild(new TreeNode(data));
              }else {
                  addNodeToTree(data, rootNode.getLeftChild());
              }
          }
      }
    }

    private static boolean isLeafNode(TreeNode rootNode) {
        return rootNode.getLeftChild() == null && rootNode.getRightChild() == null;
    }

    private static void printTreeTraversal(TreeNode root, Traversal traversal){
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

