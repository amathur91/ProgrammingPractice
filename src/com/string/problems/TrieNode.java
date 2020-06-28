package com.string.problems;

import java.util.HashMap;

public class TrieNode{
    private HashMap<String, TrieNode> nodeMap;
    private boolean isTerminal;

    public TrieNode(){
        this.nodeMap = new HashMap<>();
        this.isTerminal = false;
    }

    public HashMap<String, TrieNode> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(HashMap<String, TrieNode> nodeMap) {
        this.nodeMap = nodeMap;
    }

    public boolean isTerminal() {
        return isTerminal;
    }

    public void setTerminal(boolean terminal) {
        isTerminal = terminal;
    }
}