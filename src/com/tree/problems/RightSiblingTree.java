package com.tree.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Solution for algoexpert right sibling tree
 */
public class RightSiblingTree {
    public static BinaryTree rightSiblingTree(BinaryTree root) {
        Queue<BinaryTree> currentLevelQueue = new LinkedList<>();
        Queue<BinaryTree> nextLevelQueue = new LinkedList<>();
        currentLevelQueue.add(root);
        processNodes(currentLevelQueue, nextLevelQueue);
        return root;
    }

    private static void processNodes(Queue<BinaryTree> currentLevelQueue, Queue<BinaryTree> nextLevelQueue) {
         while(!currentLevelQueue.isEmpty() || !nextLevelQueue.isEmpty()){
             BinaryTree node1 = null;
             BinaryTree node2 = null;
             while(!currentLevelQueue.isEmpty()) {
                 node2 = currentLevelQueue.poll();
                 if (node2.value != -1) {
                     addChildrenToQueue(node2, nextLevelQueue);
                     if (node1 != null && node2.value != -1 && node1.value != -1) {
                        node1.right = node2;
                        node2.right = null;
                     }else{
                         node2.right = null;
                     }
                 }
                 node1 = node2;
             }
            currentLevelQueue = nextLevelQueue;
            nextLevelQueue = new LinkedList<>();
         }
    }

    private static void addChildrenToQueue(BinaryTree node2, Queue<BinaryTree> nextLevelQueue) {
        if(node2.left != null){
            nextLevelQueue.add(node2.left);
        }else{
            nextLevelQueue.add(new BinaryTree(-1));
        }
        if(node2.right != null){
            nextLevelQueue.add(node2.right);
        }else{
            nextLevelQueue.add(new BinaryTree(-1));
        }
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
