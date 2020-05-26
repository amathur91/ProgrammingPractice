package com.string.problems;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Solution to  underscorify.
 */
public class UnderscorifyStrings {
    public static void main(String args[]){
        String input = "ttttttttttttttbtttttctatawtatttttastvb";
        String pattern = "ttt";
        String outputString = underScorify(input, pattern);
        System.out.println(outputString);
    }

    private static String underScorify(String input, String pattern) {
        int[] suffixArray = buildSuffixArray(pattern);
        ArrayList<Pair> indexList = new ArrayList<>();
        searchPatternInString(input, pattern, suffixArray, indexList);
        StringBuffer sb = new StringBuffer();
        ArrayList<Pair> mergedPairs = mergePairs(indexList);
        HashSet<Integer> positionList = new HashSet<>();
        for(Pair item: mergedPairs){
            positionList.add(item.getStart());
            positionList.add(item.getEnd());
        }
        boolean flag = false;
        for(int index = 0 ; index < input.length(); index++){
            String character = String.valueOf(input.charAt(index));
            if(positionList.contains(index)){
                if(!flag) {
                    sb.append("_");
                    sb.append(character);
                    flag = !flag;
                }else{
                    sb.append(character);
                    sb.append("_");
                    flag = !flag;
                }
            }else{
                sb.append(character);
            }
        }
        return sb.toString();
    }

    private static ArrayList<Pair> mergePairs(ArrayList<Pair> indexList) {
        ArrayList<Pair> mergedPair = new ArrayList<>();
        int i = 0, j= i + 1;
        Pair startingPair = null;
        boolean pairFound = false;
            while (j < indexList.size()) {
                Pair firstPair = indexList.get(i);
                Pair secondPair = indexList.get(j);
                if (firstPair.getEnd() >= secondPair.getStart()) {
                    if(!pairFound) {
                        startingPair = firstPair;
                        pairFound = true;
                    }
                    i++;
                    j++;
                } else {
                    mergedPair.add(new Pair(startingPair.getStart(), indexList.get(j - 1).getEnd()));
                    pairFound = false;
                    i = j;
                    j++;
                }
            }
            if(pairFound){
            mergedPair.add(new Pair(startingPair.getStart(), indexList.get(j - 1).getEnd()));
        }
        return mergedPair;
    }

    private static void searchPatternInString(String input, String pattern, int[] suffixArray, ArrayList<Pair> indexList) {
        int patternIndex = 0;
        int matchCount = 0;
        for(int index = 0; index < input.length(); index++){
            String leftCharacter = String.valueOf(input.charAt(index));
            String patternCharacter = String.valueOf(pattern.charAt(patternIndex));
            if(leftCharacter.equalsIgnoreCase(patternCharacter)){
                patternIndex++;
                matchCount++;
            }else{
                if(matchCount > 0){
                    patternIndex = suffixArray[patternIndex - 1];
                    matchCount = patternIndex;
                    String leftValue = String.valueOf(input.charAt(index));
                    String rightValue = String.valueOf(pattern.charAt(patternIndex));
                    if(leftValue.equalsIgnoreCase(rightValue)){
                        patternIndex++;
                        matchCount++;
                        continue;
                    }
                    matchCount = 0;
                    patternIndex = 0;
                }
            }
            if(matchCount == pattern.length()){
                indexList.add(new Pair(index - pattern.length() + 1, index));
                int value = suffixArray[patternIndex - 1];
                patternIndex = value;
                matchCount = value;
            }
        }
    }

    private static int[] buildSuffixArray(String pattern) {
        int[] suffixArray = new int[pattern.length()];
        int leftPointer=0,rightPointer=1;
        suffixArray[0] = 0;
        while(rightPointer < suffixArray.length ){
            String leftCharacter = String.valueOf(pattern.charAt(leftPointer));
            String rightCharacter = String.valueOf(pattern.charAt(rightPointer));
            if(leftCharacter.equalsIgnoreCase(rightCharacter)){
                suffixArray[rightPointer] = leftPointer + 1;
                leftPointer++;
            }else{
                if(leftPointer == 0){
                    //do nothing
                }else{
                    int indexToMove = suffixArray[leftPointer - 1];
                    while(indexToMove != 0){
                        String leftChar = String.valueOf(pattern.charAt(indexToMove));
                        String rightChar = String.valueOf(pattern.charAt(rightPointer));
                        if(leftChar.equalsIgnoreCase(rightChar)){
                            suffixArray[rightPointer] = indexToMove + 1;
                            leftPointer = indexToMove;
                            break;
                        }else{
                            indexToMove = suffixArray[indexToMove - 1];
                        }
                        leftPointer = indexToMove;
                    }
                }
            }
            rightPointer++;
        }
        return suffixArray;
    }
}

class Pair{
    private int start;
    private int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}