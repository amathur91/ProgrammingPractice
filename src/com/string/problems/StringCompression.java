package com.string.problems;

import java.util.ArrayList;

public class StringCompression {
    public int getLengthOfOptimalCompression(String s, int k) {
        ArrayList<String> characterList = new ArrayList<>();
        ArrayList<Integer> countList = new ArrayList<>();
        String compressString = compressString(s, characterList, countList);
        String[] characterStrings = characterList.toArray(new String[characterList.size()]);
        Integer[] countArray = countList.toArray(new Integer[countList.size()]);
        if(k == 0){
            return getCompressedString(characterStrings, countArray).length();
        }
        if(k > 0){
            boolean isMultipleOccurance = populateCharacterCountMap(countArray, s);
            if(!isMultipleOccurance){
                return s.length() - k;
            }
            return findTheMinimalString(s, characterStrings, countArray, 0, k);
        }
        return compressString.length();
    }

    /**
     * Ideally the method should use the array to identify which character we can bomb based on the
     * count of the character as there are only handful of cases.
     */

    private int findTheMinimalString(String inputString, String[] characterStrings, Integer[] countArray, int currentIndex, int removalCount) {
        if(currentIndex < characterStrings.length && removalCount > 0){
            /**
             * we have two options
             * 1. Either the current character is bombed but only if it can be and we see benefit of bombing
             *      a. Like if the count is reduced to single digit from double digit or the count becomes zero
             *      otherwise we are better off skipping the character.
             * 2. We skip the character
             */
            int result = Integer.MAX_VALUE;
            if(isValidForReduction(countArray[currentIndex], removalCount)){
                int minimalReductionRequired = findMinimalReduction(countArray[currentIndex], removalCount);
                int temp = countArray[currentIndex];
                countArray[currentIndex] -= minimalReductionRequired;
                result = Math.min(result,getCompressedString(characterStrings, countArray).length());
                result = Math.min(result, findTheMinimalString(inputString, characterStrings, countArray, currentIndex + 1, removalCount - minimalReductionRequired));
                countArray[currentIndex] = temp;
            }
            //now exclude the index
            result = Math.min(result, findTheMinimalString(inputString, characterStrings, countArray, currentIndex + 1, removalCount));
            return result;
        }
        return getCompressedString(characterStrings, countArray).length();
    }

    private int findMinimalReduction(Integer characterCount, int removalCount) {
        if(characterCount == 100 || characterCount == 10){
            return 1;
        }
        if(characterCount - removalCount < 0){
            if(characterCount > removalCount) {
                return removalCount;
            }else{
                return characterCount;
            }
        }
        if(characterCount - removalCount == 0){
            return removalCount;
        }
        if(characterCount > 10 && (characterCount - removalCount) < 10){
           return characterCount - 9;
        }
        System.out.println("Missed an edge case");
        return -1; // this should ideally never occur
    }

    private boolean isValidForReduction(Integer characterCount, int removalCount) {
        if(characterCount == 100 || characterCount == 10 || characterCount - removalCount <= 0 || (characterCount < 10 && ((characterCount - removalCount) < 0))){
            return true;
        }
        return false;
    }

    private String getCompressedString(String[] characterString, Integer[] countArray){
        /**
         * TODO: Ankit
         * Handle the case where the middle character in a string is removed and the character at differnt index are same
         * like a b a => In this case if we remove b then we have same character a so we should club this character.
         * Add code to handle this change
         */
        StringBuffer sb = new StringBuffer();
        int index = 0;
        String firstCharacter = characterString[index];
        int count = countArray[index];
        if(characterString.length == 1){
            if(count > 0){
                sb.append(firstCharacter);
                if(count > 1){
                    sb.append(count);
                }
            }
        }
        index++;
        while(index < characterString.length){
            if(countArray[index] == 0){
                index++;
                continue;
            }
            if(characterString[index].equalsIgnoreCase(firstCharacter)){
                count += countArray[index];
                if(index == characterString.length - 1){
                    if(count > 0){
                        sb.append(firstCharacter);
                        if(count > 1){
                            sb.append(count);
                        }
                    }
                }
            }else{
                if(count > 0){
                    sb.append(firstCharacter);
                    if(count > 1){
                        sb.append(count);
                    }
                }
                firstCharacter = characterString[index];
                count = countArray[index];
                if(index == characterString.length - 1){
                    if(count > 0){
                        sb.append(firstCharacter);
                        if(count > 1){
                            sb.append(count);
                        }
                    }
                }
            }
            index++;
        }
        if(countArray[countArray.length - 1] == 0){
            if(count > 0){
                sb.append(firstCharacter);
                if(count > 1){
                    sb.append(count);
                }
            }
        }
        return sb.toString();
    }

    private boolean populateCharacterCountMap(Integer[] characterCountMap, String s) {
        boolean multipleOccurance = false;
        for(int index = 0; index < characterCountMap.length; index++){
            if(characterCountMap[index] > 1){
                multipleOccurance = true;
            }
        }
        return multipleOccurance;
    }

    public String compressString(String input, ArrayList<String> characterList, ArrayList<Integer> countList){
        if(input.length() > 0) {
            if(input.length() == 1){
                return input;
            }
            StringBuffer sb = new StringBuffer();
            String firstCharacter = String.valueOf(input.charAt(0));
            int characterCount = 1;
            int characterIndex = 1;
            while (characterIndex < input.length()) {
                String nextCharacter = String.valueOf(input.charAt(characterIndex));
                if (nextCharacter.equalsIgnoreCase(firstCharacter)) {
                    characterCount++;
                } else {
                    sb.append(firstCharacter);
                    characterList.add(firstCharacter);
                    if (characterCount > 1) {
                        sb.append(characterCount);
                    }
                    countList.add(characterCount);
                    characterCount = 1;
                    firstCharacter = nextCharacter;
                }
                if (characterIndex == input.length() - 1) {
                    sb.append(firstCharacter);
                    characterList.add(firstCharacter);
                    countList.add(characterCount);
                    if (characterCount > 1) {
                        sb.append(characterCount);
                    }
                    characterIndex++;
                } else {
                    characterIndex++;
                }
            }
            return sb.toString();
        }
        return new String();
    }

}
