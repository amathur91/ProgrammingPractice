package com.arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LongestIncreasingSubsequence {
    public static List<Integer> longestIncreasingSubsequence(int[] array) {
        if(array.length == 0){
            return new ArrayList<>();
        }
        int[] count = new int[array.length];
        int[] mapper = new int[array.length];
        for(int index = 0; index < count.length; index++){
            count[index] = 1; //Why? Because every number itself is longest increasing subsequence of size 1.
            mapper[index] = index;
        }

        for(int upperBound = 1; upperBound < array.length; upperBound++){
            for(int currentNumberIndex = 0; currentNumberIndex < upperBound; currentNumberIndex++){
                if(array[currentNumberIndex] < array[upperBound] && (count[currentNumberIndex] + 1 > count[upperBound])){
                    count[upperBound] = count[currentNumberIndex] + 1;
                    mapper[upperBound] = currentNumberIndex;
                }
            }
        }
        int maxSequenceIndex = 0;
        for(int index = 0; index < array.length; index++){
            if(count[index] > count[maxSequenceIndex]){
                maxSequenceIndex = index;
            }
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        Stack<Integer> finalResultList = new Stack<>();
        while(count[maxSequenceIndex] != 1){
            finalResultList.push(array[maxSequenceIndex]);
            maxSequenceIndex = mapper[maxSequenceIndex];
        }
        finalResultList.add(array[maxSequenceIndex]);
        while (!finalResultList.isEmpty()){
            resultList.add(finalResultList.pop());
        }
        return resultList;
    }
}
