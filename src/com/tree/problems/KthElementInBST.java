package com.tree.problems;

/**
 * We find out the kth number in BST using ranking algorithm which
 * takes ~O(logn) because we decide the subtree before proceeding and
 * has better running time than standard algorithm of n
 */
public class KthElementInBST {
    public static void main(String args[]){
        TreeRankNode rootNode = new TreeRankNode(5);
        rootNode.setLeftChild(new TreeRankNode(3));
        rootNode.getLeftChild().setLeftChild(new TreeRankNode(2));
        rootNode.getLeftChild().setRightChild(new TreeRankNode(4));
        rootNode.setRightChild(new TreeRankNode(7));
        rootNode.getRightChild().setLeftChild(new TreeRankNode(6));
        
        setRankInTree(rootNode);
        int k = 5;
        int requiredNumber = findTheKthNumberInBST(rootNode, k);
        System.out.println( k+ "th Number is : " + requiredNumber);


    }

    private static int findTheKthNumberInBST(TreeRankNode rootNode, int k) {
        if(rootNode != null){
            if(k == 0 || k == rootNode.getRank() + 1){
                return rootNode.getData();
            }
            else if(k < rootNode.getRank() + 1){
                //where k is less..so we need to look at the left subtree
                return findTheKthNumberInBST((TreeRankNode) rootNode.getLeftChild(), k);
            }else if(k > rootNode.getRank() + 1){
                //we need to look at right subtree
                return findTheKthNumberInBST((TreeRankNode) rootNode.getRightChild(), k - rootNode.getRank() - 1);
            }
        }
        return -1;
    }

    private static int setRankInTree(TreeRankNode rootNode) {
        if(rootNode != null){
            int leftSubtreeNodes = setRankInTree((TreeRankNode) rootNode.getLeftChild());
            int rightSubTreeNodes = setRankInTree((TreeRankNode) rootNode.getRightChild());
            rootNode.setRank(leftSubtreeNodes);
            return 1 + leftSubtreeNodes + rightSubTreeNodes;
        }
        return 0;
    }


}

class TreeRankNode extends TreeNode{
    private int rank;

    public TreeRankNode(int data) {
        super(data);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}