package com.arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Solution for Largest Range - AlgoExpert
 * Time Complexity : O(n)
 * Memory Complexity : O(n)
 */
public class LargestRange {
    public static int[] largestRange(int[] array) {
        if(array == null || array.length == 0){
            return new int[0];
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        HashMap<Integer, Boolean> numMap = new HashMap<>();
        for(Integer num : array){
            numMap.put(num, Boolean.TRUE);
        }
        for(Integer num : array){
            if(numMap.containsKey(num) && numMap.get(num)){
                ArrayList<Integer> allIncreasingSequence = findAllIncreasingSequence(numMap, num);
                if(list1.size() < allIncreasingSequence.size()){
                    list1 = allIncreasingSequence;
                }
            }
        }
        int[] result = new int[2];
        result[0] = list1.get(0);
        result[1] = list1.get(list1.size() - 1);
        return result;
    }

    private static ArrayList<Integer> findAllIncreasingSequence(HashMap<Integer, Boolean> numMap, Integer num) {
        int count = 0;
        ArrayList<Integer> tempList = new ArrayList<>();
        int previousNum = num - 1;
        while(numMap.containsKey(previousNum) && numMap.get(previousNum)){
            tempList.add(0,previousNum);
            numMap.put(previousNum, Boolean.FALSE);
            previousNum--;
        }

        while(numMap.containsKey(num) && numMap.get(num)){
            tempList.add(num);
            numMap.put(num, Boolean.FALSE);
            num++;
        }
        return tempList;
    }
}
