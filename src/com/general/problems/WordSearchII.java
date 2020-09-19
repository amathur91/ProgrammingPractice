package com.general.problems;

import java.util.*;

public class WordSearchII {
    public static void main(String args[]){
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = new char[][]{{'a','b'}, {'a','a'}
        };
        String[] words = new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    public List<String> findWords(char[][] board, String[] words) {
        /**
         * 1. Build a trie with the words provided.
         * 2. For each letter int the board check if starting from it we can build any word present in the trie.
         *  -> if letter matches then continue with that word in the trie and in the board look neighbours for the
         *   next move.
         * 3. If yes, then add that word to the final list
         */
        HashSet<String> selectedWords = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        TrieNode rootTrieNode = new TrieNode('/');
        for(String word : words){
            addWordToTrie(rootTrieNode, word);
        }

        for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
            for(int columnIndex = 0; columnIndex < board[0].length; columnIndex++){
                if(rootTrieNode.getChildNodes()[board[rowIndex][columnIndex] - 'a'] != null){
                    HashSet<Position> positionHashSet = new HashSet<>();
                    traverseAndFindWord(rowIndex, columnIndex,rootTrieNode.getChildNodes()[board[rowIndex][columnIndex] - 'a'], selectedWords, positionHashSet, board);
                }
            }
        }

        return new ArrayList<>(selectedWords);
    }

    private void traverseAndFindWord(int rowIndex, int columnIndex, TrieNode currentNode, HashSet<String> selectedWords, HashSet<Position> positionHashSet, char[][] board) {
        if(currentNode.isWord()){
            selectedWords.add(currentNode.getWordValue());
        }
        // this isnt a terminal node
        //selecting the current position.
        Position position = new Position(rowIndex, columnIndex);
        positionHashSet.add(position);

        // left neighbour
        if(columnIndex - 1 >= 0 && !positionHashSet.contains(new Position(rowIndex, columnIndex - 1))) {
            Character leftNeighbour = board[rowIndex][columnIndex - 1];
            if (currentNode.getChildNodes()[leftNeighbour - 'a'] != null) {
                traverseAndFindWord(rowIndex, columnIndex - 1, currentNode.getChildNodes()[leftNeighbour - 'a'], selectedWords, positionHashSet, board);
            }
        }

        // right neighbour
        if(columnIndex + 1 < board[0].length && !positionHashSet.contains(new Position(rowIndex, columnIndex + 1))) {
            Character rightNeighbour = board[rowIndex][columnIndex + 1];
            if (currentNode.getChildNodes()[rightNeighbour - 'a'] != null) {
                traverseAndFindWord(rowIndex, columnIndex + 1, currentNode.getChildNodes()[rightNeighbour - 'a'], selectedWords, positionHashSet, board);
            }
        }

        // top neighbour
        if(rowIndex - 1 >= 0 && !positionHashSet.contains(new Position(rowIndex - 1, columnIndex))){
            Character topNeighbour = board[rowIndex - 1][columnIndex];
            if (currentNode.getChildNodes()[topNeighbour - 'a'] != null) {
                traverseAndFindWord(rowIndex - 1, columnIndex, currentNode.getChildNodes()[topNeighbour - 'a'], selectedWords, positionHashSet, board);
            }
        }

        // bottom neighbour
        if(rowIndex + 1 < board.length && !positionHashSet.contains(new Position(rowIndex + 1, columnIndex))){
            Character bottomNeighbour = board[rowIndex + 1][columnIndex];
            if (currentNode.getChildNodes()[bottomNeighbour - 'a'] != null) {
                traverseAndFindWord(rowIndex + 1, columnIndex, currentNode.getChildNodes()[bottomNeighbour - 'a'], selectedWords, positionHashSet, board);
            }
        }
        positionHashSet.remove(position);
    }

    private void addWordToTrie(TrieNode rootTrieNode, String word) {
        for(int index = 0; index < word.length(); index++){
            Character letter = word.charAt(index);
            if(rootTrieNode.getChildNodes()[letter - 'a'] == null){
                rootTrieNode.getChildNodes()[letter - 'a'] = new TrieNode(letter);
                rootTrieNode = rootTrieNode.getChildNodes()[letter - 'a'];
            } else {
                rootTrieNode = rootTrieNode.getChildNodes()[letter - 'a'];
            }
        }
        rootTrieNode.setWord(true);
        rootTrieNode.setWordValue(word);
    }

}

class TrieNode{
    private Character value;
    private TrieNode[] childNodes;
    private boolean isWord;
    private String wordValue;

    public TrieNode(Character value) {
        this.value = value;
        this.childNodes = new TrieNode[26];
    }

    public String getWordValue() {
        return wordValue;
    }

    public void setWordValue(String wordValue) {
        this.wordValue = wordValue;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
    }

    public TrieNode[] getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(TrieNode[] childNodes) {
        this.childNodes = childNodes;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}

class Position{
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}