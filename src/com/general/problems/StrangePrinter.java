package com.general.problems;

import java.util.Comparator;
import java.util.SortedMap;

/**
 * if lIndex == rIndex
 *     return 1;
 * int result = 1;
 *
 * if lIndex == rIndex
 *     result +=  mem[lIndex + 1][rIndex - 1]
 * else
 *     result =  result + Math.min(mem[lIndex][rIndex-1], mem[lIndex + 1][rIndex]);
 *
 * return result;
 *
 * 1. Remove redundant Strings and then apply above logic
 * aaabbb -> ab -> func(ab) = 2
 * aba -> aba -> func(aba) = 2
 * abc -> abc-> func(abc) = 3
 *
 *
 * https://leetcode.com/problems/strange-printer/
 * Success Rate : 141/201
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        if(null == s || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        String filteredString = dropDuplicates(s);
        int finalResult = findTheMinimumPrintCostDP(filteredString);
        return finalResult;
    }

    private String dropDuplicates(String s) {
        StringBuffer sb = new StringBuffer();
        int leftPointer = 0;
        String leftCharacter = String.valueOf(s.charAt(leftPointer));
        sb.append(leftCharacter);
        for(int index = 1; index < s.length(); index++){
            String nextCharacter = String.valueOf(s.charAt(index));
            if(!nextCharacter.equalsIgnoreCase(leftCharacter)){
                sb.append(nextCharacter);
            }
            leftCharacter = nextCharacter;
        }
        return sb.toString();
    }
    private int findTheMinimumPrintCostDP(String input){
       int[][] computeArray = new int[input.length()][input.length()];
       for(int rowIndex = 0; rowIndex < input.length(); rowIndex++){
          computeArray[rowIndex][rowIndex] = 1; //Why? because the cost to print 1 character is 1
       }
       for(int windowSize = 1; windowSize < input.length(); windowSize++) {
        int leftPointer = 0;
        int rightPointer = leftPointer + windowSize;
        while (rightPointer < input.length()) {
         String leftCharacter = String.valueOf(input.charAt(leftPointer));
         String rightCharacter = String.valueOf(input.charAt(rightPointer));
         if (leftCharacter.equalsIgnoreCase(rightCharacter)) {
          computeArray[leftPointer][rightPointer] =  Math.min(computeArray[leftPointer + 1][rightPointer], computeArray[leftPointer][rightPointer-1]);
         } else {
          computeArray[leftPointer][rightPointer] = 1 + Math.min(computeArray[leftPointer + 1][rightPointer], computeArray[leftPointer][rightPointer - 1]);
         }
         leftPointer++;
         rightPointer++;
        }
       }
       return computeArray[0][input.length() - 1];
    }
}
