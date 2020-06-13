package com.arrayproblems;

import com.tree.problems.BSTNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.algoexpert.io/questions/Right%20Smaller%20Than
 * Solution for the Right Smaller than on Algoexpert.
 * I have used the approach of BST for finding out the count of lower numbers on the right.
 */
public class RightSmallerThan {
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        BSTNode rootNode = null;
        int[] result = new int[array.size()];
        buildBSTFromInput(array, rootNode, result); // takes O(n)
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0 ; i < result.length; i++){
            resultList.add(result[i]);
        }
        return resultList;
    }


    private static BSTNode buildBSTFromInput(List<Integer> array, BSTNode rootNode, int[] result) {
        for(int i = array.size() - 1; i >=0; i--){
            rootNode = buildBST(array.get(i), rootNode, i, 0, result);
        }
        return rootNode;
    }

    private static BSTNode buildBST(Integer num, BSTNode rootNode, int index, int count, int[] result) {
        if(null == rootNode){
            BSTNode newNode =  new BSTNode(num);
            newNode.setOriginalIndex(index);
            newNode.setLeftChildCount(0);
            result[index] = count;
            return newNode;
        }else{
            if(num <= rootNode.getData()){
                rootNode.setLeftChild(buildBST(num, rootNode.getLeftChild(), index, count, result));
                rootNode.setLeftChildCount(rootNode.getLeftChildCount() + 1);
            }else if(num > rootNode.getData()){
                rootNode.setRightChild(buildBST(num, rootNode.getRightChild(), index, count + rootNode.getLeftChildCount() + 1, result));
            }
        }
        return rootNode;
    }
}

