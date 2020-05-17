package com.string.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryPattern {
    public static void main(String args[]){
        String input = "1??0?101";
        List<String> possiblePermutations = new ArrayList<String>();
        generatePossiblePermutations(input, possiblePermutations);
        possiblePermutations.stream().forEach((permutation)->{
            System.out.println(permutation);
        });

    }

    private static void generatePossiblePermutations(String input, List<String> possiblePermutations) {
        int totalMissingCount = findMissingCount(input);
        String[] possibleReplacements = {"0", "1"};
        processInput(input, 0, possibleReplacements, possiblePermutations);
    }

    private static void processInput(String input, int currentIndex, String[] possibleReplacements, List<String> possiblePermutations) {
        if(currentIndex >= input.length()){
            possiblePermutations.add(input);
        }else{
            String character = String.valueOf(input.charAt(currentIndex));
            if(character.equalsIgnoreCase("?")){
                char[] inputCharArray = input.toCharArray();
                for(String replacement : possibleReplacements){
                    inputCharArray[currentIndex] = replacement.toCharArray()[0];
                    String replacedString = new String(inputCharArray);
                    processInput(replacedString, currentIndex + 1, possibleReplacements, possiblePermutations);
                }
            }else{
                processInput(input, currentIndex + 1, possibleReplacements, possiblePermutations);
            }
        }
    }

    private static int findMissingCount(String input) {
        int totalCount = 0;
        for(int index = 0 ; index < input.length(); index++){
            String character = String.valueOf(input.charAt(index));
            if(character.equalsIgnoreCase("?")){
                totalCount++;
            }
        }
        return totalCount;
    }
}
