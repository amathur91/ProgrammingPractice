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
 * So I will drop duplicates from the string and apply the logic
 */
public class StrangePrinter {
    public int strangePrinter(String s) {
        // Work on a recursive solution to solve this problem.
        // the best test case is "tbgtgb" which takes 4 iterations..Refer to the copy in the table.
        if(null == s || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        String filteredString = dropDuplicates(s);
        int leftPointer = 0;
        int rightPointer = filteredString.length() - 1;
        int finalResult = findThePrintCounter(filteredString, leftPointer, rightPointer);
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

    private int findThePrintCounter(String s, int leftPointer, int rightPointer) {
        if(leftPointer >= 0 && leftPointer < s.length() && rightPointer > leftPointer) {
            // add check for the left and right
            String leftCharacter = String.valueOf(s.charAt(leftPointer));
            String rightCharacter = String.valueOf(s.charAt(rightPointer));

            if(leftCharacter.equalsIgnoreCase(rightCharacter)){
                return 1 + findThePrintCounter(s, leftPointer + 1, rightPointer - 1);
            }else{
                int result1 = findThePrintCounter(s, leftPointer + 1, rightPointer);
                int result2 = findThePrintCounter(s, leftPointer, rightPointer - 1);
                return 1 + Math.min(result1, result2);
            }
        }else if( leftPointer == rightPointer){
            return 1;
        }
        return 0;
    }
}
