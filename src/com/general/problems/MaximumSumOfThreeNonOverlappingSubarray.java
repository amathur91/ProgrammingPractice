package com.general.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * Linear Time Solution for this problem.
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/submissions/
 */
public class MaximumSumOfThreeNonOverlappingSubarray {
    public static void main(String args[]){
        int[] input = {4,5,10,6,11,17,4,11,1,3};
        int size = 1;
        MaximumSumOfThreeNonOverlappingSubarray maximumSumOfThreeNonOverlappingSubarray = new MaximumSumOfThreeNonOverlappingSubarray();
        int[] result = maximumSumOfThreeNonOverlappingSubarray.maximumNonOverlappingSum(input, size);
    }
    public int[] maximumNonOverlappingSum(int[] input, int size){
        LinkedHashMap<Integer, ArrayList<PairList>> linkedHashMap = new LinkedHashMap<>();
        int[] sumLookup = new int[input.length];
        buildLookupSum(input, sumLookup);
        int firstBlockIndex = 0;
        int secondBlockIndex = firstBlockIndex + size;
        int thirdBlockIndex = secondBlockIndex + size;
        int firstSum = 0;
        for(int i = 0; i < size; i++){
            firstSum += input[i];
        }
        ValuePair firstPair = new ValuePair(firstSum);
        firstPair.getIndexPairs().add(firstBlockIndex);
        ValuePair secondPair = new ValuePair(firstPair.getValue() + getSumForStartingIndex(sumLookup, secondBlockIndex, size));
        secondPair.getIndexPairs().add(firstBlockIndex);
        secondPair.getIndexPairs().add(secondBlockIndex);
        ValuePair thirdPair = new ValuePair(secondPair.getValue() +getSumForStartingIndex(sumLookup, thirdBlockIndex, size));
        thirdPair.getIndexPairs().add(firstBlockIndex);
        thirdPair.getIndexPairs().add(secondBlockIndex);
        thirdPair.getIndexPairs().add(thirdBlockIndex);

        firstBlockIndex++;
        secondBlockIndex++;
        thirdBlockIndex++;

        while(thirdBlockIndex + size - 1 < input.length){
            int sumOfNewFirstBlock = getSumForStartingIndex(sumLookup, firstBlockIndex,size);

            if(sumOfNewFirstBlock > firstPair.getValue()){
                firstPair.setValue(sumOfNewFirstBlock);
                firstPair.getIndexPairs().clear();
                firstPair.getIndexPairs().add(firstBlockIndex);
            }

            int sumOfSecondBlock = getSumForStartingIndex(sumLookup, secondBlockIndex, size);
            if(firstPair.getValue() + sumOfSecondBlock > secondPair.getValue() ){
                secondPair.setValue(firstPair.getValue() + sumOfSecondBlock);
                secondPair.getIndexPairs().clear();
                secondPair.getIndexPairs().add(firstPair.getIndexPairs().get(0));
                secondPair.getIndexPairs().add(secondBlockIndex);
            }

            int sumOfThirdBlock = getSumForStartingIndex(sumLookup, thirdBlockIndex, size);
            if(secondPair.getValue() + sumOfThirdBlock > thirdPair.getValue()){
                thirdPair.setValue(secondPair.getValue() + sumOfThirdBlock);
                thirdPair.getIndexPairs().clear();
                thirdPair.getIndexPairs().add(secondPair.getIndexPairs().get(0));
                thirdPair.getIndexPairs().add(secondPair.getIndexPairs().get(1));
                thirdPair.getIndexPairs().add(thirdBlockIndex);
            }

            firstBlockIndex++;
            secondBlockIndex++;
            thirdBlockIndex++;
        }
        int[] result = new int[3];
        result[0] = thirdPair.getIndexPairs().get(0);
        result[1] = thirdPair.getIndexPairs().get(1);
        result[2] = thirdPair.getIndexPairs().get(2);
        return result;
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

class ValuePair{
    private int value;
    private ArrayList<Integer> indexPairs;

    public ValuePair(int value){
        this.value = value;
        this.indexPairs = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Integer> getIndexPairs() {
        return indexPairs;
    }

    public void setIndexPairs(ArrayList<Integer> indexPairs) {
        this.indexPairs = indexPairs;
    }
}

class PairList{
    private  ArrayList<Integer> pair;

    public PairList() {
        this.pair = new ArrayList<>();
    }

    public ArrayList<Integer> getPair() {
        return pair;
    }

    public void setPair(ArrayList<Integer> pair) {
        this.pair = pair;
    }
}

