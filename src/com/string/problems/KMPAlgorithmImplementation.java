package com.string.problems;

public class KMPAlgorithmImplementation {
    public static void main(String args[]){
        String input = "abxabcabcaby";
        String pattern = "abcaby";
        boolean isPatternPresent = checkPresenceOfPattern(input, pattern);
        System.out.println("Pattern Found : " + isPatternPresent);
    }

    private static boolean checkPresenceOfPattern(String input, String pattern) {
        int[] suffixArray = buildSuffixArray(pattern);
        return findThePatternInString(input, pattern, suffixArray);

    }

    private static boolean findThePatternInString(String input, String pattern, int[] suffixArray) {
        boolean result = false;
        int patternIndex = 0;
        int matchCount = 0;
        for(int index = 0 ; index < input.length(); index++){
            String inputCharacter = String.valueOf(input.charAt(index));
            String patternCharacter = String.valueOf(pattern.charAt(patternIndex));
            if(inputCharacter.equalsIgnoreCase(patternCharacter)){
                matchCount++;
                patternIndex++;
            }else{
                /**
                 * 1. If we had some matches then we have to reset the pattern index
                 * based on the suffixArray and reset the match count.
                 *
                 * 2. else we simply move to the next input character.
                 */
                if(matchCount > 0){
                    patternIndex = suffixArray[patternIndex - 1];
                    String left = String.valueOf(input.charAt(index));
                    String right = String.valueOf(pattern.charAt(patternIndex));
                    if(left.equalsIgnoreCase(right)){
                        patternIndex++;
                        matchCount = patternIndex;
                        continue;
                    }
                    matchCount = 0;
                    continue;
                }else{
                    //do nothing
                }
            }
            //If the total pattern match break and print the index.
            if(matchCount == pattern.length()){
                int matchIndex = index - pattern.length() + 1;
                System.out.println("Match Found at index : " + matchIndex);
                return true;
            }
        }
        return result;
    }

    private static int[] buildSuffixArray(String pattern) {
        int startIndex = 0;
        int endIndex = startIndex + 1;
        int[] suffixArray = new int[pattern.length()];
        suffixArray[0] = 0;
        while(endIndex < pattern.length()){
            String leftCharacter = String.valueOf(pattern.charAt(startIndex));
            String rightCharacter = String.valueOf(pattern.charAt(endIndex));
            if(leftCharacter.equalsIgnoreCase(rightCharacter)){
                suffixArray[endIndex] = startIndex+ 1;
                startIndex++;
            }else{
                //if start is 0, then we cant go a step bacl
                if(startIndex == 0){
                    //do nothing literally.
                }else{
                    int indexToMove = suffixArray[startIndex - 1];
                    while(indexToMove != 0){
                        String left = String.valueOf(pattern.charAt(indexToMove));
                        String right = String.valueOf(pattern.charAt(endIndex));
                        if(left.equalsIgnoreCase(right)){
                            suffixArray[endIndex] = suffixArray[indexToMove] + 1;
                            startIndex = indexToMove;
                            break;
                        }else{
                            indexToMove = suffixArray[indexToMove - 1];
                        }
                    }
                    startIndex = indexToMove;
                }
            }
            endIndex++;
        }
        return suffixArray;
    }

}
