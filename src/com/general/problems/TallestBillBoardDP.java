package com.general.problems;

import java.util.*;

/**
 * Leetcode : https://leetcode.com/problems/tallest-billboard
 * Solution is optimized O(3**n)
 * Explaination : Think of the problem as the this. Suppose we have to multiply the numbers with 1, -1 and 0
 * such that the sum of all the numbers is 0. This will take the too much time to compute
 * So we apply a clever trick to reduce the time in Another approach.
 * We keep Map {x,y} such that x is the sum of all numbers and y is the sum of the positive numbers.
 * We only keep that entry in map which has maximum y value. This way we reduce the number of computation to
 * find the answer. But still the Complexity is high
 *
 * Leetcode results
 * Runtime: 243 ms, faster than 13.53% of Java online submissions for Tallest Billboard.
 * Memory Usage: 47.4 MB, less than 25.00% of Java online submissions for Tallest Billboard.
 */
public class TallestBillBoardDP {
    private static int maxNum = 0;
    public int tallestBillboard(int[] rods) {
        int totalSum = Arrays.stream(rods).sum();
        ArrayList<Integer> positiveNumSum = new ArrayList<>();
//        doRecursiveIteration(rods, 0, 0, totalSum, positiveNumSum);
//        int result = maxNum;
//        maxNum = 0;
//        return result;
        return computeTheTallestBillBoardInOptimizedNonRecursiveWay(rods);
    }

    public int computeTheTallestBillBoardInOptimizedNonRecursiveWay(int[] rods){
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(rods[0],1);
        sumMap.put(rods[0] * -1,0);
        sumMap.put(0,0);
        for(int index = 1; index < rods.length; index++){
            HashMap<Integer, Integer> copyMap = (HashMap<Integer, Integer>) sumMap.clone();
            for(Map.Entry<Integer, Integer> entry : sumMap.entrySet()){
                int positiveNumber = rods[index] * 1;
                int negativeNumber = rods[index] * -1;
                int zeroNumber  = 0;
                int sumOfAllNumbers = entry.getKey();
                int sumOfPositiveNumbers = entry.getValue();
                updateMap(copyMap, positiveNumber, sumOfAllNumbers, sumOfPositiveNumbers);
                updateMap(copyMap, negativeNumber, sumOfAllNumbers, sumOfPositiveNumbers);
                updateMap(copyMap, zeroNumber, sumOfAllNumbers, sumOfPositiveNumbers);
            }
            sumMap = copyMap;
        }
        return sumMap.get(0);
    }

    private void updateMap(HashMap<Integer, Integer> copyMap, int currentNumber, int sumOfAllNumbers, int sumOfPositiveNumbers) {
        if(copyMap.containsKey(sumOfAllNumbers + currentNumber)){
            if(copyMap.get(sumOfAllNumbers + currentNumber) < sumOfPositiveNumbers + Math.max(currentNumber,0)){
                copyMap.put(sumOfAllNumbers + currentNumber, sumOfPositiveNumbers + Math.max(currentNumber,0));
            }
        }else{
            copyMap.put(sumOfAllNumbers + currentNumber, sumOfPositiveNumbers + Math.max(currentNumber,0));
        }
    }


    private void doRecursiveIteration(int[] rods, int currentIndex, int currentSum, int totalSum, ArrayList<Integer> positiveNumSum) {
        int totalPositiveSum = positiveNumSum.stream().reduce(0, (a, b) -> a + b);
        if(currentSum >= (-1 * totalSum/2) && currentSum <= totalSum / 2  && totalPositiveSum <= totalSum / 2 ) {
            if (currentIndex < rods.length) {
                doRecursiveIteration(rods, currentIndex + 1, currentSum + (rods[currentIndex] * (-1)), totalSum, positiveNumSum);
                doRecursiveIteration(rods, currentIndex + 1, currentSum + (rods[currentIndex] * 0), totalSum, positiveNumSum);
                int currentNum = rods[currentIndex];
                positiveNumSum.add(currentNum);
                doRecursiveIteration(rods, currentIndex + 1, currentSum + (rods[currentIndex] * 1), totalSum, positiveNumSum);
                positiveNumSum.remove(positiveNumSum.indexOf(currentNum));
            }
            if (currentSum == 0) {
                int totalPositiveIntSum = positiveNumSum.stream().reduce(0, (a, b) -> a + b);
                if (totalPositiveIntSum > maxNum) {
                    maxNum = totalPositiveIntSum;
                }
            }
        }
    }
}