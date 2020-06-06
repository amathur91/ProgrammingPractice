package com.tree.problems;

public class KthElementRecursively {
    private static int k = 5;
    public static void main(String args[]){
        TreeNode rootNode = new TreeNode(5);
        rootNode.setLeftChild(new TreeNode(3));
        rootNode.setRightChild(new TreeNode(7));
        rootNode.getLeftChild().setLeftChild(new TreeNode(2));
        rootNode.getLeftChild().setRightChild(new TreeNode(4));
        rootNode.getRightChild().setLeftChild(new TreeNode(6));
        
        int result = findKthElementInBST(rootNode);
        System.out.println( 5 + "th Element : " + result);
    }

    private static int findKthElementInBST(TreeNode rootNode) {
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
