package com.string.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumCutsForPalindrome {
    public static void main(String args[]){
        List<String> stringList = Arrays.asList("abdbca", "cddpd", "pqr","pp");
        stringList.stream().forEach((input)->{
            List<String> splittedPalindromes = findMinimumCutsForPalindrome(input);
//            int result = minimumCutsForPalindromeRecursively(input, 0, input.length() - 1);
//            System.out.println("Minimum cuts for string : " + input + " : " + result);
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

        /**
         * In this while block we are building a matrix to know if the substring is a
         * palindrome or not. This will be used to refer when we are dividing the string
         *
         */
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

        /**
         * Here we are identifying from start which chunk is maximum palindrome
         * from start. Here we use the map that is constructed above.
         */
        int start = 0;
        int end = 0;
        ArrayList<String> palindromes = new ArrayList<>();
        while(end < input.length()){
            for(int endSubStringIndex = start; endSubStringIndex < input.length(); endSubStringIndex++){
                if(computeStore[start][endSubStringIndex] == 1){
                    end = endSubStringIndex;
                }
            }
            palindromes.add(input.substring(start, end+1));
            start = end + 1;
            end = start;
        }
        /**
         * In the end the total substring that we form are the final answer.
         * So total cuts = total palindromes formed  - 1
         */
        return palindromes;
    }
}