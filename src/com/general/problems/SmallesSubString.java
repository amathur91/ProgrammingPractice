package com.general.problems;

import java.util.HashMap;
import java.util.Map;

public class SmallesSubString {
    public static void main(String args[]){
//        String bigString = "abcd$ef$axb$c$";
//        String smallString = "$$abf";
        String bigString = "abcdefghijklmnopqrstuvwxyz";
        String smallString = "aajjttwwxxzz";
        String subString = findSmallestSubStringContainingSmallString(bigString, smallString);
        System.out.println(subString);
    }

    private static String findSmallestSubStringContainingSmallString(String bigString, String smallString) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for(int index = 0; index < bigString.length(); index++){
            String character = String.valueOf(bigString.charAt(index));
            if(countMap.containsKey(character)){
                countMap.put(character, countMap.get(character) + 1);
            }else{
                countMap.put(character, 1);
            }
        }
        HashMap<String, Integer> smallStringMap = new HashMap<>();
        for(int index = 0; index < smallString.length(); index++){
            String character = String.valueOf(smallString.charAt(index));
            if(smallStringMap.containsKey(character)){
                smallStringMap.put(character, smallStringMap.get(character) + 1);
            }else{
                smallStringMap.put(character, 1);
            }
        }

        for(String key : smallStringMap.keySet()){
            int inputCount = countMap.getOrDefault(key, -1);
            int minimumCount = smallStringMap.getOrDefault(key, Integer.MIN_VALUE);
            if(minimumCount > inputCount || inputCount == -1){
                return "";
            }
        }
       int leftPointer = 0;
       int rightPointer = bigString.length() - 1;
       boolean leftMovement = false;
           //move the left pointer
       while(!leftMovement){
           String character = String.valueOf(bigString.charAt(leftPointer));
           int currentCount = countMap.get(character);
           int minimumCount = smallStringMap.getOrDefault(character, Integer.MIN_VALUE);
           if(currentCount > minimumCount){
               leftPointer++;
               countMap.put(character, countMap.get(character) - 1);
           }else{
               leftMovement = true;
           }
       }

           //move the right pointer
        boolean rightMovement = false;
       while(!rightMovement){
           String character = String.valueOf(bigString.charAt(rightPointer));
           int currentCount = countMap.get(character);
           int minimumCount = smallStringMap.getOrDefault(character, Integer.MIN_VALUE);
           if(currentCount > minimumCount){
               rightPointer--;
               countMap.put(character, countMap.get(character) - 1);
           }else{
               rightMovement = true;
           }
       }
       return bigString.substring(leftPointer, rightPointer + 1);
    }
}
