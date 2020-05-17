package com.string.problems;

import java.util.Arrays;
import java.util.List;

/**
 * Here in this program we want to find the substring which satisfy palindrome property
 * The minimum could be string of length 1.
 */
public class PalindromicSubstrings {
    public static void main(String args[]){
        List<String> strings = Arrays.asList("pqr", "abdbca", "cddpd");
        strings.stream().forEach(input->{
            System.out.println(input + " | Total Count : " + findPalindromicSubString(input));
        });
    }

    private static int findPalindromicSubString(String input) {
        int[][] computeStore = new int[input.length()][input.length()];
        for(int i = 0 ; i < input.length(); i++){
            computeStore[i][i] = 1; // Single letter is an palindrome
        }

        int windowSize = 1;
        int startIndex = 0;
        int endIndex = startIndex + windowSize;
        while(windowSize <= input.length()){
            while(endIndex <= input.length() - 1){
                String firstCharacter = String.valueOf(input.charAt(startIndex));
                String secondCharacter = String.valueOf(input.charAt(endIndex));
                if(firstCharacter.equalsIgnoreCase(secondCharacter)){
                    if(Math.abs(startIndex - endIndex) > 1 && computeStore[startIndex+1][endIndex-1] == 1){
                        computeStore[startIndex][endIndex] = 1;
                    }else if(Math.abs(startIndex - endIndex) == 1){
                        computeStore[startIndex][endIndex] = 1;
                    }
                }
                startIndex++;
                endIndex++;
            }
            windowSize++;
            startIndex = 0;
            endIndex = startIndex + windowSize;
        }

        //count all the 1 in the computeArray
        int totalCount = 0;
        for(int i = 0 ; i < input.length(); i++){
            for(int j = 0 ; j < input.length(); j++){
                if(computeStore[i][j] == 1){
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
}
