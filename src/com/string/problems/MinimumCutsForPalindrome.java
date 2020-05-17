package com.string.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCutsForPalindrome {
    public static void main(String args[]){
        List<String> stringList = Arrays.asList("abdbca", "cddpd", "pqr","pp");
        stringList.stream().forEach((input)->{
            //List<String> splittedPalindromes = findMinimumCutsForPalindrome(input);
            int result = minimumCutsForPalindromeRecursively(input, 0, input.length() - 1);
            System.out.println("Minimum cuts for string : " + input + " : " + result);
        });

    }

    private static int minimumCutsForPalindromeRecursively(String input, int startIndex, int endIndex){
      if(startIndex <= endIndex && endIndex < input.length() ) {
          if (isPalindrome(input, startIndex, endIndex)) {
              return 0;
          } else {
              int leftSide = minimumCutsForPalindromeRecursively(input, startIndex + 1, endIndex);
              int rightSide = minimumCutsForPalindromeRecursively(input, startIndex, endIndex - 1);
              return 1 + Math.min(leftSide, rightSide);
          }
      }
      return 0;
    }

    private static boolean isPalindrome(String input, int startIndex, int endIndex){
        if(input.length() == 1){
            return true;
        }else{
            int start = startIndex;
            int end = endIndex;
            while(start < end){
                String left = String.valueOf(input.charAt(start));
                String right = String.valueOf(input.charAt(end));
                if(!left.equalsIgnoreCase(right)){
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }


    private static List<String> findMinimumCutsForPalindrome(String input){
        int computeStore[][] = new int[input.length()][input.length()];
        for(int i = 0; i < input.length(); i++){
            computeStore[i][i] = 1;
        }
        int windowSize = 1;
        int startIndex = 0;
        int endIndex = startIndex + windowSize;

        while(windowSize < input.length()){
            while(endIndex < input.length()){
                String leftCharacter = String.valueOf(input.charAt(startIndex));
                String rightCharacter = String.valueOf(input.charAt(endIndex));
                if(leftCharacter.equalsIgnoreCase(rightCharacter)){
                    computeStore[startIndex][endIndex] = computeStore[startIndex+1][endIndex - 1];
                }else{
                    computeStore[startIndex][endIndex] = 0;
                }
                startIndex++;
                endIndex++;
            }
            windowSize++;
            startIndex = 0;
            endIndex = startIndex + windowSize;
        }
        int start = 0;
        int end = 0;
        ArrayList<String> palindromes = new ArrayList<>();
        while(end < input.length()){
            for(int j = start; j < input.length(); j++){
                if(computeStore[start][j] == 1){
                    end = j;
                }
            }
            palindromes.add(input.substring(start, end+1));
            start = end + 1;
            end = start;
        }
        return palindromes;
    }
}
/**  a b d b c a
 * a 1
 * b   1
 * d     1
 * b       1
 * c         1
 * a           1
 */
