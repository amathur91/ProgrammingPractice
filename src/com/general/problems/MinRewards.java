package com.general.problems;

/**
 * Solution for Algoexpert Min Rewards
 * Complexity O(n)
 */
public class MinRewards {
    public static void main(String args[]) {
        int[] scores = {2, 20, 13, 12, 11, 8, 4, 3, 1, 5, 6, 7, 9, 0};
        int result = minRewards(scores);
        System.out.println(result);
    }

    public static int minRewards(int[] scores) {
        if(scores.length == 1){
            return 1;
        }
        int minPeakIndex = -1;
        int[] result = new int[scores.length];
        minPeakIndex = minPeakInScores(scores, result);
        int totalRewards = 0;
        while(minPeakIndex != -1){
            expandFromMinPeak(minPeakIndex, result, scores);
            minPeakIndex = minPeakInScores(scores, result);
        }

        for(int index = 0; index < scores.length; index++){
            totalRewards += result[index];
        }
        return totalRewards;
    }

    private static void expandFromMinPeak(int minPeakIndex, int[] result, int[] scores) {
        //first set this value as 1
        //expand left
        //expand right
        result[minPeakIndex] = 1;
        expandLeft(minPeakIndex, result, scores);
        expandRight(minPeakIndex, result, scores);
    }

    private static void expandLeft(int startIndex, int[] result, int[] scores) {
        int currentIndexValue = scores[startIndex];
        int value = result[startIndex];
        for(int index = startIndex - 1; index >=0; index--){
            if(currentIndexValue > 0  && scores[index] > currentIndexValue && result[index] == 0){
                result[index] = ++value;
                currentIndexValue = scores[index];
            }else{
                break; //Get out of the loop
            }
        }
    }

    private static void expandRight(int startIndex, int[] result, int[] scores) {
        int currentIndexValue = scores[startIndex];
        int value = result[startIndex];
        for(int index = startIndex + 1; index < scores.length; index++){
            if(currentIndexValue > 0 && scores[index] > currentIndexValue  && result[index] == 0){
                result[index] = ++value;
                currentIndexValue = scores[index];
            }else{
                break; //Get out of the loop
            }
        }
    }

    private static int minPeakInScores(int[] scores, int[] results) {
        int minIndex = -1;
        for(int index = 0; index < scores.length; index++) {
            if (results[index] == 0) {
                if (index == 0 || index == scores.length - 1) {
                    if (index == 0) {
                        if (scores[index] < scores[index + 1]) {
                            minIndex = minIndexCheckAndReplace(scores, minIndex, index);
                        }
                    } else {
                        if (scores[index] < scores[index - 1]) {
                            minIndex = minIndexCheckAndReplace(scores, minIndex, index);
                        }
                    }

                } else {
                    if (scores[index] < scores[index - 1] && scores[index] < scores[index + 1]) {
                        minIndex = minIndexCheckAndReplace(scores, minIndex, index);
                    }
                }
            }
        }
        return minIndex; //No peak found.
    }

    private static int minIndexCheckAndReplace(int[] scores, int minIndex, int index) {
        if(minIndex == -1){
            minIndex = index;
        }else{
            if(scores[index] < scores[minIndex]){
                minIndex = index;
            }
        }
        return minIndex;
    }
}