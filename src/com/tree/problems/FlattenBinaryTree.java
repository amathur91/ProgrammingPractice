package com.tree.problems;

public class FlattenBinaryTree {
    public static BinaryTree flattenBinaryTree(BinaryTree root) {
        BinaryTree processedNode = flattenTreeUtil(root);
        while(processedNode.left != null){
            processedNode = processedNode.left;
        }
        return processedNode;
    }

    private static BinaryTree flattenTreeUtil(BinaryTree root) {
        if(null != root) {
            if (isLeafNode(root)) {
                return root;
            } else {
                BinaryTree lhsNodes = flattenTreeUtil(root.left);
                BinaryTree rhsNodes = flattenTreeUtil(root.right);
                BinaryTree tempLhsNode = lhsNodes;
                BinaryTree tempRhsNode = rhsNodes;
                while (null != tempLhsNode && tempLhsNode.right != null) {
                    tempLhsNode = tempLhsNode.right;
                }
                while (null != tempRhsNode && tempRhsNode.left != null) {
                    tempRhsNode = tempRhsNode.left;
                }
                if (null != tempLhsNode) {
                    tempLhsNode.right = root;
                }
                root.left = tempLhsNode;
                root.right = tempRhsNode;
                if (null != tempRhsNode) {
                    tempRhsNode.left = root;
                }
                return root;
            }
        }
        return null;
    }

    private static boolean isLeafNode(BinaryTree root) {
        return null != root && root.left == null && root.right == null;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
