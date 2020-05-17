package com.string.problems;

import java.util.Arrays;
import java.util.List;

/**
 * We need to find the minimum count of character that we can drop to
 * make the string palindrome.
 *
 */
public class MinimumDeletionForPalindrome {
    public static void main(String args[]){
        List<String> strings = Arrays.asList("pqr", "abdbca", "cddpd");
        strings.stream().forEach(input->{
//            System.out.println(input + " | Minimum Deletion : " + findMinimumDeletionCount(input));
            System.out.println(input + " | Minimum Deletion : " + findMinimumDeletionNonRecursively(input));
        });    }

    private static int findMinimumDeletionCount(String input) {
        int startIndex = 0;
        int endIndex = input.length() - 1;
        return findMinimumDeletionUtil(startIndex, endIndex, input);
    }

    /**
     * This is recursive solution to achieve the result.
     * @param startIndex
     * @param endIndex
     * @param input
     * @return
     */
    private static int findMinimumDeletionUtil(int startIndex, int endIndex, String input) {
        if(startIndex < endIndex){
            String startCharacter = String.valueOf(input.charAt(startIndex));
            String endCharacter = String.valueOf(input.charAt(endIndex));
            if(startCharacter.equalsIgnoreCase(endCharacter)){
                return findMinimumDeletionUtil(startIndex + 1, endIndex - 1, input);
            }else{
                return 1 + Math.min(findMinimumDeletionUtil(startIndex+1, endIndex, input),
                        findMinimumDeletionUtil(startIndex, endIndex - 1, input));
            }
        }
        return 0;
    }

    private static int findMinimumDeletionNonRecursively(String input){
        int result = 0;
        int[][] computeStore = new int[input.length()][input.length()];

        int windowSize = 1;
        int startIndex = 0;
        int endIndex = startIndex + windowSize;
        while(windowSize <= input.length()){
            while(endIndex <= input.length() - 1){
                String firstCharacter = String.valueOf(input.charAt(startIndex));
                String secondCharacter = String.valueOf(input.charAt(endIndex));
                if(firstCharacter.equalsIgnoreCase(secondCharacter)){
                   computeStore[startIndex][endIndex] = computeStore[startIndex + 1][endIndex - 1];
                }else{
                    computeStore[startIndex][endIndex] = 1 + Math.min(computeStore[startIndex + 1][endIndex],
                            computeStore[startIndex][endIndex - 1]);
                }
                startIndex++;
                endIndex++;
            }
            windowSize++;
            startIndex = 0;
            endIndex = startIndex + windowSize;
        }
        result = computeStore[0][input.length() - 1];
        return result;
    }
}
