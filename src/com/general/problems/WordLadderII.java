package com.general.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Solution for Word Ladder
 * https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadderII {
    private static boolean success = false;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Boolean> wordLookupMap = new HashMap<>();
        for(String word : wordList){
            wordLookupMap.put(word, Boolean.TRUE);
        }
        if(wordLookupMap.containsKey(beginWord)){
            wordList.remove(wordList.indexOf(beginWord));
        }
        if(!wordLookupMap.containsKey(endWord)){
            return new ArrayList<>();
        }
        String currentWord = beginWord;
        List<List<String>> finalResult = new ArrayList<>();
        Set<String> workingSet = new LinkedHashSet<>();
        workingSet.add(beginWord);
        MinData minData = new MinData(Integer.MAX_VALUE);
        exploreTheTransformation(currentWord, wordList, wordLookupMap, workingSet, endWord, finalResult, minData);
        finalResult = filterTheFinalList(finalResult, minData);
        return finalResult;
    }

    private List<List<String>> filterTheFinalList(List<List<String>> finalResult, MinData minData) {
        List<List<String>> finalList = finalResult.stream().filter(list -> list.size() == minData.getMinData()).collect(Collectors.toList());
        return finalList;
    }

    private void exploreTheTransformation(String currentWord, List<String> wordList, HashMap<String, Boolean> wordLookupMap, Set<String> workingSet, String endWord, List<List<String>> finalResult, MinData minData) {
        if(currentWord.equalsIgnoreCase(endWord)){
            pushThisListToFinalList(workingSet, finalResult);
            if(workingSet.size() <= minData.getMinData()){
                minData.setMinData(workingSet.size());
            }
            success = true;
        }else {
            HashSet<String> possibleWords = findStringsWithLowTransformation(currentWord, wordList, wordLookupMap);
            if(possibleWords != null && workingSet != null){
                possibleWords.removeAll(workingSet);
            }
            if(workingSet.size() < minData.getMinData()) {
                if (possibleWords.contains(endWord)) {
                    wordLookupMap.put(endWord, Boolean.FALSE);
                    workingSet.add(endWord);
                    exploreTheTransformation(endWord, wordList, wordLookupMap, workingSet, endWord, finalResult, minData);
                    wordLookupMap.put(endWord, Boolean.TRUE);
                    workingSet.remove(endWord);
                }else {
                    for (String possibleWord : possibleWords) {
                        if(workingSet.size() == minData.getMinData()){
                            break;
                        }
                        if (wordLookupMap.get(possibleWord) && !workingSet.contains(possibleWord)) {
                            wordLookupMap.put(possibleWord, Boolean.FALSE);
                            workingSet.add(possibleWord);
                            exploreTheTransformation(possibleWord, wordList, wordLookupMap, workingSet, endWord, finalResult, minData);
                            if(success) {
                                wordLookupMap.put(possibleWord, Boolean.TRUE);
                                workingSet.remove(possibleWord);
                                success = false;
                            }
                        }
                    }
                }
            }
        }
    }

    private void pushThisListToFinalList(Set<String> workingSet, List<List<String>> finalResult) {
        ArrayList<String> result1 = new ArrayList<>();
        for(String word : workingSet){
            result1.add(word);
        }
        finalResult.add(result1);
    }

    private HashSet<String> findStringsWithLowTransformation(String currentWord, List<String> wordList, HashMap<String, Boolean> wordLookupMap) {
        HashSet<String> possibleWords = new LinkedHashSet<>();
        for(String word : wordList){
            if(wordLookupMap.get(word)) {
                int difference = findWordDifference(currentWord, word);
                if (difference == 1) {
                    possibleWords.add(word);
                }
            }
        }
        return possibleWords;
    }

    private int findWordDifference(String currentWord, String word) {
        int count = 0;
        if(currentWord.length() != word.length()){
            return Integer.MAX_VALUE;
        }else{
            for(int index = 0; index < currentWord.length(); index++){
                String character1 = String.valueOf(currentWord.charAt(index));
                String character2 = String.valueOf(word.charAt(index));
                if(!character1.equalsIgnoreCase(character2)){
                    count++;
                }
            }
        }
        return count;
    }
}

class MinData{
    private int minData;
    public MinData(int minData) {
        this.minData = minData;
    }

    public int getMinData() {
        return minData;
    }

    public void setMinData(int minData) {
        this.minData = minData;
    }
}



