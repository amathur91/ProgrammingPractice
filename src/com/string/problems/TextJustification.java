package com.string.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/text-justification/
 * Level : Hard
 * Time Complexity : O(nlogn)
 * Results :
 * Runtime: 2 ms, faster than 25.64% of Java online submissions for Text Justification.
 * Memory Usage: 38.1 MB, less than 48.91% of Java online submissions for Text Justification.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
            ArrayList<String> paragraph = buildParagraph(words, maxWidth);
            ArrayList<String> result = justifyTheParagraph(paragraph, maxWidth);
            return result;
    }

    private ArrayList<String> justifyTheParagraph(ArrayList<String> paragraph, int maxWidth) {
        ArrayList<String> justifiedParagraph = new ArrayList<>();
        for(int index = 0; index < paragraph.size() - 1; index++){
            String centerJustified = centerJustifyString(paragraph.get(index), maxWidth);
            justifiedParagraph.add(centerJustified);
        }

        String leftJustified = leftJustifyString(paragraph.get(paragraph.size() - 1), maxWidth);
        justifiedParagraph.add(leftJustified);
        return justifiedParagraph;
    }

    private String centerJustifyString(String inputString, int maxWidth) {
        StringBuffer justifiedString = new StringBuffer();
        inputString = inputString.trim();
        String[] words = inputString.split(" ");
        if(words.length == 1){
            return leftJustifyString(inputString, maxWidth);
        }
        int totalCharacters = 0;
        for(String word : words){
            totalCharacters += word.length();
        }
        int divisionFactor = 1;
        if((words.length - 1) != 0){
            divisionFactor = (words.length - 1);
        }
        int availableSpace = (maxWidth - totalCharacters);

        //here we can check and handle the spaces count if its uneven
        if(availableSpace % divisionFactor == 0){
            int spacesAfterEachWord = availableSpace / divisionFactor;
            StringBuffer spaces = new StringBuffer();
            for(int index = 0; index < spacesAfterEachWord; index++){
                spaces.append(" ");
            }
            for(String word : words){
                justifiedString.append(word);
                justifiedString.append(spaces);
            }
        }else{
            //now what we can do is that we can add spaces in rotation. Starting from left to right.
            int spacesAdded = 0;
            while(spacesAdded != availableSpace) {
                for (int index = 0; index < words.length - 1 && spacesAdded != availableSpace; index++) {
                    words[index] = words[index] + " ";
                    spacesAdded++;
                }
            }
            for(String word : words){
                justifiedString.append(word);
            }
        }
        return justifiedString.toString().trim();
    }

    private String leftJustifyString(String inputString, int maxWidth) {
        StringBuffer justifiedString = new StringBuffer();
        inputString = inputString.trim();
        String[] words = inputString.split(" ");
        int totalCharacters = 0;
        for(String word : words){
            totalCharacters += word.length() + 1;
        }
        int spacesAfterEachWord = (maxWidth - totalCharacters);
        StringBuffer spaces = new StringBuffer();
        for(int index = 0; index < spacesAfterEachWord; index++){
            spaces.append(" ");
        }
        for(String word : words){
            justifiedString.append(word);
            if(justifiedString.length()< maxWidth){
                justifiedString.append(" ");
            }
        }
        justifiedString.append(spaces);
        return justifiedString.toString();
    }

    private ArrayList<String> buildParagraph(String[] words, int maxWidth) {
        ArrayList<String> paragraph = new ArrayList<>();
        int currentUsage = 0;
        StringBuffer line = new StringBuffer();
        for(String word: words){
            if(currentUsage < maxWidth && (currentUsage + word.length()) <= maxWidth){
                line.append(word);
                line.append(" ");
                currentUsage += word.length() + 1;
            }else{
                paragraph.add(line.toString());
                line = new StringBuffer();
                currentUsage = 0;
                //copy code from if condition here
                line.append(word);
                line.append(" ");
                currentUsage += word.length() + 1;
            }
        }
        paragraph.add(line.toString());
        return paragraph;
    }
}
