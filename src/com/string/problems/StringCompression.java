package com.string.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StringCompression {
    public int getLengthOfOptimalCompression(String s, int k) {
        String compressString = compressString(s);
        if(k >= 0){
            HashMap<String, Integer> characterCountMap = new HashMap<>();
            boolean isMultipleOccurance = populateCharacterCountMap(characterCountMap, s);
            if(!isMultipleOccurance){
                return s.length() - k;
            }
            return findTheMinimalString(s, characterCountMap, k);
        }
        return compressString.length();
    }


    private int findTheMinimalString(String inputString, HashMap<String, Integer> characterCountMap, int maximumRemovalPermitted) {
        Set<String> stringSet = characterCountMap.keySet();
        ArrayList<String> totalCharacters = new ArrayList<>();
        totalCharacters.addAll(stringSet);
        HashMap<Key, Integer> cache = new HashMap<>();
        return findMinimalString(0, inputString, maximumRemovalPermitted, cache);
    }

    private int findMinimalString(int index, String inputString, int characterToDrop, HashMap<Key, Integer> cache){

        Key thisKey = new Key(index, inputString, characterToDrop);
        if(cache.containsKey(thisKey)){
            int result =  cache.get(thisKey);
            return result;
        }
        int minLength = Integer.MAX_VALUE;
        if(index < inputString.length() && characterToDrop > 0){
            int exclusionResult = findMinimalString(index + 1, inputString, characterToDrop, cache);
            //cache.put(new Key(index + 1, inputString, characterToDrop),exclusionResult);
            minLength = Math.min(compressString(inputString).length(),exclusionResult);

            //remove character and recursively call the function
            String newString = inputString.substring(0, index) + inputString.substring(index + 1, inputString.length());
            int resultWithLessCharacter = findMinimalString(index, newString, characterToDrop - 1, cache);
            //cache.put(new Key(index, newString, characterToDrop - 1 ),resultWithLessCharacter);
            minLength = Math.min(compressString(newString).length(), Math.min(resultWithLessCharacter, minLength));
            return minLength;
        }
            minLength = Math.min(minLength,compressString(inputString).length());
            cache.put(new Key(index, inputString, characterToDrop),minLength);
            return minLength;
    }

    private boolean populateCharacterCountMap(HashMap<String, Integer> characterCountMap, String s) {
        boolean multipleOccurance = false;
        for(int index = 0; index < s.length(); index++){
            String character = String.valueOf(s.charAt(index));
            if(characterCountMap.containsKey(character)){
                characterCountMap.put(character, characterCountMap.get(character) + 1);
                multipleOccurance = true;
            }else{
                characterCountMap.put(character, 1);
            }
        }
        return multipleOccurance;
    }

    public String compressString(String input){
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
                    if (characterCount > 1) {
                        sb.append(characterCount);
                    }
                    characterCount = 1;
                    firstCharacter = nextCharacter;
                }
                if (characterIndex == input.length() - 1) {
                    sb.append(firstCharacter);
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

class Key{
    private int index;
    private String input;
    private int characterToDrop;

    public Key(int index, String input, int characterToDrop) {
        this.index = index;
        this.input = input;
        this.characterToDrop = characterToDrop;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getCharacterToDrop() {
        return characterToDrop;
    }

    public void setCharacterToDrop(int characterToDrop) {
        this.characterToDrop = characterToDrop;
    }
    //Depends only on account number
    @Override
    public int hashCode() {
        final int prime = 57;
        int result = input.length();
        result = prime * result + index;
        return result;
    }

    //Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Key other = (Key) obj;
        if (index != other.index && !input.equalsIgnoreCase(other.input) && characterToDrop != other.characterToDrop)
            return false;
        return true;
    }
}
