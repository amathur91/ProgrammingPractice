package com.string.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Solution for Algoexpert Multi String Search using a Trie
 *
 */
public class MultiStringSearch {
    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        SuffixTrie suffixTrie = new SuffixTrie(new TrieNode());
        String[] words = bigString.split(" ");
        for(String word : words) {
            suffixTrie.addToSuffixTree(word);
        }
        List<Boolean> resultList = new ArrayList<>();
        for(String searchString : smallStrings){
            resultList.add(suffixTrie.isStringPresent(searchString));
        }
        return resultList;
    }
}

