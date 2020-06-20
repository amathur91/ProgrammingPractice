package com.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Sub Optimal Solution for Sliding Window
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] input, int k){
        if(input.length == 0){
            return new int[0];
        }
        int[] maxHeap = new int[k];
        int[] result = new int[input.length - k + 1];
        HashMap<Integer, ArrayList<Integer>> indexMap = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        int maxNumIndex = 0;
        for(int index = 0; index < k; index++){
            if(input[index] > maxNum){
                maxNum = input[index];
            }
            maxHeap[index] = input[index];
        }
        heapify(maxHeap, indexMap);
        result[maxNumIndex] = maxNum;
        maxNumIndex++;

        for(int index = k; index < input.length; index++){
            int nextNumber = input[index];
            int indexToSwap = indexMap.get(input[index - k]).get(0);
            int numberToSwap = maxHeap[indexToSwap];
            maxHeap[indexToSwap] = nextNumber;
            removeNumberFromIndexMap(numberToSwap, indexMap);
            heapify(maxHeap, indexMap);
            result[maxNumIndex] = maxHeap[0];
            maxNumIndex++;
        }
        return result;
    }

    private void removeNumberFromIndexMap(int numberToSwap, HashMap<Integer, ArrayList<Integer>> indexMap) {
        if(indexMap.containsKey(numberToSwap) && indexMap.get(numberToSwap).size() > 1){
            indexMap.get(numberToSwap).remove(0);
        }else{
            indexMap.remove(numberToSwap);
        }
    }

    private void addNumberToIndexMap(int number, int index, HashMap<Integer, ArrayList<Integer>> indexMap) {
        if(indexMap.containsKey(number)){
            indexMap.get(number).add(index);
        }else{
            indexMap.put(number, new ArrayList<>(Arrays.asList(index)));
        }
    }

    private void heapify(int[] maxHeap, HashMap<Integer, ArrayList<Integer>> indexMap) {
        int startIndex = maxHeap.length / 2;
        while(startIndex >= 0){
            heapifyUtil(maxHeap, startIndex, indexMap);
            startIndex--;
        }
        indexMap.clear();
        buildMap(maxHeap, indexMap);
    }

    private void buildMap(int[] maxHeap, HashMap<Integer, ArrayList<Integer>> indexMap) {
        for(int index = 0; index < maxHeap.length; index++){
            addNumberToIndexMap(maxHeap[index], index, indexMap);
        }
    }

    private void heapifyUtil(int[] maxHeap, int rootIndex, HashMap<Integer, ArrayList<Integer>> indexMap) {
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;
        if(isValidIndex(leftChild, maxHeap) &&  maxHeap[leftChild] > maxHeap[rootIndex]){
            //swap
            int temp = maxHeap[leftChild];
            maxHeap[leftChild] = maxHeap[rootIndex];
            maxHeap[rootIndex] = temp;
            heapifyUtil(maxHeap, leftChild, indexMap);
        }
        if(isValidIndex(rightChild, maxHeap) && maxHeap[rightChild] > maxHeap[rootIndex]){
            //swap
            int temp = maxHeap[rightChild];
            maxHeap[rightChild] = maxHeap[rootIndex];
            maxHeap[rootIndex] = temp;
            heapifyUtil(maxHeap, rightChild, indexMap);
        }
    }

    private boolean isValidIndex(int childIndex, int[] maxHeap) {
        return childIndex < maxHeap.length;
    }
}
