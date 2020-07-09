package com.tree.problems;

public class KthElementRecursively {
    private static int k = 5;
    public static void main(String args[]){
        BinaryTreeNode rootNode = new BinaryTreeNode(5);
        rootNode.setLeftChild(new BinaryTreeNode(3));
        rootNode.setRightChild(new BinaryTreeNode(7));
        rootNode.getLeftChild().setLeftChild(new BinaryTreeNode(2));
        rootNode.getLeftChild().setRightChild(new BinaryTreeNode(4));
        rootNode.getRightChild().setLeftChild(new BinaryTreeNode(6));
        
        int result = findKthElementInBST(rootNode);
        System.out.println( 5 + "th Element : " + result);
    }

    private static int findKthElementInBST(BinaryTreeNode rootNode) {
        if(rootNode != null){
            if(k == 0){
                return rootNode.getData();
            }
            int leftSubtreeResult = findKthElementInBST(rootNode.getLeftChild());
            if(leftSubtreeResult != 0){
                return leftSubtreeResult;
            }
            k = k - 1;
            if(k == 0){
                return rootNode.getData();
            }
            int rightSubTreeResult = findKthElementInBST(rootNode.getRightChild());
            if(rightSubTreeResult != 0){
                return rightSubTreeResult;
            }
        }
        //we could not find the element.
        return 0;
    }
}
