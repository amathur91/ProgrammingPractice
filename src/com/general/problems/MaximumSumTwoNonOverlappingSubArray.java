package com.general.problems;

/**
 * Linear Time O(n) solution for Maximum Sum of Two Overlapping Sub Arrays
 * https://www.geeksforgeeks.org/maximum-sum-two-non-overlapping-subarrays-of-given-size/
 */
public class MaximumSumTwoNonOverlappingSubArray {
    public int maximumNonOverlappingSum(int[] input, int size){
        int[] sumLookup = new int[input.length];
        buildLookupSum(input, sumLookup);
        int firstBlockIndex = 0;
        int secondBlockIndex = firstBlockIndex + size;
        int firstSum = 0;
        for(int i = 0; i < size; i++){
            firstSum += input[i];
        }
        Pair first = new Pair(0, firstSum);
        Pair secondPair = new Pair(0 + size, first.getValue() +
                getSumForStartingIndex(sumLookup, secondBlockIndex, size));

        firstBlockIndex++;
        secondBlockIndex++;

        while(secondBlockIndex + size - 1 < input.length){
            int sumOfNewFirstBlock = getSumForStartingIndex(sumLookup, firstBlockIndex,size);
            if(sumOfNewFirstBlock > first.getValue()){
                first.setValue(sumOfNewFirstBlock);
                first.setIndex(firstBlockIndex);
            }

            int sumOfSecondBlock = getSumForStartingIndex(sumLookup, secondBlockIndex, size);
            if(first.getValue() + sumOfSecondBlock > secondPair.getValue()){
                secondPair.setValue(first.getValue() + sumOfSecondBlock);
                secondPair.setIndex(secondBlockIndex);
            }
            firstBlockIndex++;
            secondBlockIndex++;
        }

        return secondPair.getValue();
    }

    private void buildLookupSum(int[] input, int[] sumLookup) {
        sumLookup[0] = input[0];
        for(int index = 1; index < input.length; index++){
            sumLookup[index] = sumLookup[index - 1] + input[index];
        }
    }

    private int getSumForStartingIndex(int[] sumLookup, int startIndex, int size){
        return sumLookup[startIndex + size - 1] - sumLookup[startIndex - 1];
    }
}

class Pair{
    private int index;
    private int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
