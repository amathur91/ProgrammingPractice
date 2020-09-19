package com.tree.problems;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lcaNode = findLCANode(root, p, q);
        if(lcaNode != null) {
            return lcaNode;
        }
        return null;
    }

    private TreeNode findLCANode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if(root.val == p.val){
            return p;
        }
        if (root.val == q.val){
            return q;
        }
        TreeNode leftSubtree = findLCANode(root.left, p, q);
        TreeNode rightSubtree = findLCANode(root.right, p,q);
        if(leftSubtree != null && rightSubtree != null){
            // means that one node is in left subtree and other in right subtree
            return root; //root is the lca
        } else {
            if(leftSubtree == null && rightSubtree != null){
                return rightSubtree;
            }
            if (rightSubtree == null && leftSubtree != null) {
                return leftSubtree;
            }
        }
        return null;
    }
}
