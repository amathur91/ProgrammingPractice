package com.tree.problems;

import java.util.HashMap;
import java.util.Stack;
import java.util.function.Function;

/**
 * Solution for Iterative InOrder Traversal
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
public class IterativeInOrderTraversal {
    public static void iterativeInOrderTraversal(
            BinaryTree tree, Function<BinaryTree, Void> callback) {
       Stack<BinaryTree> processingStack = new Stack<>();
       HashMap<BinaryTree, Boolean> processedNodeMap = new HashMap<>();
       processingStack.push(tree);
       doInOrderTraversal(processingStack, processedNodeMap, callback);
    }

    private static void doInOrderTraversal(Stack<BinaryTree> processingStack, HashMap<BinaryTree, Boolean> processedNodeMap, Function<BinaryTree, Void> callback) {
        while(!processingStack.isEmpty()){
            BinaryTree node = processingStack.pop();
            if(!processedNodeMap.containsKey(node)) {
                processedNodeMap.put(node, Boolean.FALSE);
            }
            if(node.right != null && !processedNodeMap.containsKey(node.right) ){
                processingStack.push(node.right);
                processedNodeMap.put(node.right, Boolean.FALSE);
            }
            if((node.left == null && node.right == null) || (node.left == null && processedNodeMap.containsKey(node.right)) ||
                    (node.right == null && processedNodeMap.containsKey(node.left))){
                callback.apply(node);
                processedNodeMap.put(node, Boolean.TRUE);
            }else if(node.left != null && node.right != null &&
                    processedNodeMap.containsKey(node.left)
                    && processedNodeMap.containsKey(node.right)){
                callback.apply(node);
                processedNodeMap.put(node, Boolean.TRUE);
            }else{
                processingStack.push(node);
            }
            if(node.left != null && !processedNodeMap.containsKey(node.left)){
                processingStack.push(node.left);
            }
        }
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree parent;

        public BinaryTree(int value) {
            this.value = value;
        }

        public BinaryTree(int value, BinaryTree parent) {
            this.value = value;
            this.parent = parent;
        }
    }
}
