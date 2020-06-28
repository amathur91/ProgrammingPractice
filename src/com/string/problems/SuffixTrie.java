package com.string.problems;

import java.util.HashMap;

public class SuffixTrie{
    private TrieNode rootNode;

    public SuffixTrie(TrieNode rootNode) {
        this.rootNode = rootNode;
    }

    public TrieNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(TrieNode rootNode) {
        this.rootNode = rootNode;
    }

    public boolean addToSuffixTree(String inputString){
        //this will take input string and add to itself.
        traverseAndAddToTree(inputString, 0, inputString.length(), this.rootNode.getNodeMap());
        return true;
    }

    private void traverseAndAddToTree(String wordToAdd, int currentIndex, int length, HashMap<String, TrieNode> nodeMap) {
        if(currentIndex < length){
            String characterToAdd = String.valueOf(wordToAdd.charAt(currentIndex));
            if(nodeMap.containsKey(characterToAdd)){
                traverseAndAddToTree(wordToAdd, currentIndex + 1, length, nodeMap.get(characterToAdd).getNodeMap());
            }else{
                nodeMap.put(characterToAdd, new TrieNode());
                if(currentIndex == length - 1){
                    nodeMap.get(characterToAdd).setTerminal(true);
                }else {
                    traverseAndAddToTree(wordToAdd, currentIndex + 1, length, nodeMap.get(characterToAdd).getNodeMap());
                }
            }
        }
    }

    public boolean isStringPresent(String inputString){
        return checkPresentOfStringInTreeUtil(inputString, rootNode.getNodeMap(), 0, inputString.length());
    }

    private boolean checkPresentOfStringInTreeUtil(String inputString, HashMap<String, TrieNode> nodeMap, int currentIndex, int length) {
        if(currentIndex < length){
            String currentCharacter = String.valueOf(inputString.charAt(currentIndex));
            if(nodeMap.containsKey(currentCharacter) && currentIndex == inputString.length() - 1){
                return true;
            }else if (nodeMap.containsKey(currentCharacter)){
                return checkPresentOfStringInTreeUtil(inputString, nodeMap.get(currentCharacter).getNodeMap(),currentIndex + 1, length);
            }else{
                return false;
            }
        }
        return false;
    }
}
