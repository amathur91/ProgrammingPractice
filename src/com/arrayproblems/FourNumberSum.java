package com.arrayproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FourNumberSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        HashMap<Integer, List<Integer[]>> combinationMap = new HashMap<>();
        List<Integer[]> finalResult = new ArrayList<>();
        for(int i= 0; i < array.length - 1; i++){
            checkForMatchingPair(array, targetSum, combinationMap, finalResult, i);
            addPairsToMap(array, combinationMap, i);
        }
        return finalResult;
    }

    private static void addPairsToMap(int[] array, HashMap<Integer, List<Integer[]>> combinationMap, int i) {
        for(int k = 0; k < i; k++){
            int sum = array[i] + array[k];
            if(!combinationMap.containsKey(sum)){
                //add a new value;
                Integer[] pair = new Integer[2];
                pair[0] = array[i];
                pair[1] = array[k];
                ArrayList<Integer[]> pairList = new ArrayList<>();
                pairList.add(pair);
                combinationMap.put(sum, pairList);
            }else{
                //check and append the value
                List<Integer[]> currentPairs = combinationMap.get(sum);
                boolean found = false;
                for(Integer[] pair : currentPairs){
                    if( (pair[0] == array[i] && pair[1] == array[k]) || (pair[0] == array[k] && pair[1] == array[i])){
                        found = true;
                    }
                }
                if(!found){
                    Integer[] newPair = new Integer[2];
                    newPair[0] = array[i];
                    newPair[1] = array[k];
                    combinationMap.get(sum).add(newPair);
                }
            }
        }
    }

    private static void checkForMatchingPair(int[] array, int targetSum, HashMap<Integer, List<Integer[]>> combinationMap, List<Integer[]> finalResult, int i) {
        for(int j = i + 1; j < array.length; j++){
            //first check if the number
            int currentSum = array[i] + array[j];
            int remainingSum = targetSum - currentSum;
            if(combinationMap.containsKey(remainingSum)){
                //we found pairs.
                List<Integer[]> matchingPairs = combinationMap.get(remainingSum);
                for(Integer[] match : matchingPairs){
                    Integer[] resultPair = new Integer[4];
                    resultPair[0] = array[i];
                    resultPair[1] = array[j];
                    resultPair[2] = match[0];
                    resultPair[3] = match[1];
                    finalResult.add(resultPair);
                }
            }
        }
    }
}
