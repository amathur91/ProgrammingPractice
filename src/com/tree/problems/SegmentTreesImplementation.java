package com.tree.problems;

/**
 * This code implements Segment Tree Build and Search for minimum Range Query.
 */
public class SegmentTreesImplementation {
    public static void main(String args[]){
        /**
         * For a given input, we build segment trees and
         * provide mechanism for querying.
         */

        //int[] input = {-1, 2, 4, 0};
        int[] input = {1, 3, 2, 7, 9, 11, 13, -2};
        int[] segmentTree = buildSegmentTreeForInput(input);
        int minimumNumber = findLowestNumberInTree(segmentTree, 0, 5, input);
        System.out.println("Minimum Number in range : " + minimumNumber);

    }

    private static int findLowestNumberInTree(int[] segmentTree, int startIndex, int endIndex, int[] input) {
        int left = 0;
        int right = input.length - 1;
        return findLowestNumberUtil(segmentTree, left, right, startIndex, endIndex, 0);
    }

    private static int findLowestNumberUtil(int[] segmentTree, int left, int right, int startIndex, int endIndex, int root) {
        if(left >= startIndex && right <= endIndex){
            //complete overlap
            return segmentTree[root];
        }
        else if(startIndex > right || endIndex < left){
            //no overlap
            return Integer.MAX_VALUE;
        }else{
            //partial over lap
            int mid = (left + right)/2;
            int searchIndexMid = (startIndex + endIndex) / 2;
            return Math.min(findLowestNumberUtil(segmentTree,left, mid, startIndex,  searchIndexMid, root * 2 + 1 ),
                    findLowestNumberUtil(segmentTree, mid + 1, right, searchIndexMid, endIndex, root * 2 + 2));
        }
    }

    private static int[] buildSegmentTreeForInput(int[] input) {
        int[] segmentTree = new int[input.length * 2 - 1];
        int root = 0;
        int left = 0;
        int right = input.length - 1;
        segmentTreeUtil(segmentTree, root, left, right, input);
        return segmentTree;
    }

    private static void segmentTreeUtil(int[] segmentTree, int root, int left, int right, int[] input) {
        if(left == right){
           segmentTree[root] = input[left];
           return;
        }
        int mid = (left + right) / 2;
        segmentTreeUtil(segmentTree, root * 2 + 1, left, mid, input);
        segmentTreeUtil(segmentTree, root * 2 + 2, mid + 1, right, input);
        int leftChildIndex = 2 * root + 1;
        int rightChildIndex = 2 * root + 2;
        int leftChildValue = segmentTree[leftChildIndex];
        int rightChildValue = segmentTree[rightChildIndex];
        if(leftChildValue < rightChildValue){
            segmentTree[root] = leftChildValue;
        }else{
            segmentTree[root] = rightChildValue;
        }
    }
}
