package com.matrix.problems;

import java.util.*;

public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        HashMap<String, List<CharacterPosition>> characterPositionHashMap = new HashMap<>();
        buildCharacterHashMap(board, characterPositionHashMap);
        ArrayList<String> availableWordsList = new ArrayList<>();
        for(String word : words){
            findWordAndAddToList(characterPositionHashMap, word, availableWordsList, board);
        }
        return availableWordsList;
    }

    private void findWordAndAddToList(HashMap<String, List<CharacterPosition>> characterPositionHashMap, String word, ArrayList<String> availableWordsList, char[][] board) {
        if(isWordPresent(word, board, characterPositionHashMap)){
            availableWordsList.add(word);
        }
    }

    private boolean isWordPresent(String word, char[][] board, HashMap<String, List<CharacterPosition>> characterPositionHashMap) {
        String firstCharacter = String.valueOf(word.charAt(0));
        if(!characterPositionHashMap.containsKey(firstCharacter)){
            return false;
        }else{
            List<CharacterPosition> characterPositions = characterPositionHashMap.get(firstCharacter);
            for(CharacterPosition position : characterPositions) {
                boolean[][] useMap = new boolean[board.length][board[0].length];
                useMap[position.getRowIndex()][position.getColumnIndex()] = true;
                boolean result = findRemaingWordLength(word, 1, position, board, useMap);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findRemaingWordLength(String word, int nextIndex, CharacterPosition position, char[][] board, boolean[][] useMap) {
        if(nextIndex >= word.length()){
            return true;
        }else{
            boolean leftResult = false, rightResult = false, topResult= false, bottomResult = false;
            String nextCharacter = String.valueOf(word.charAt(nextIndex));
            //check all the neighbours and if this is one of the neighbour then only proceed.
            String leftNeighbour = getValueFromBoard(position.getRowIndex(), position.getColumnIndex() - 1, board);
            String rightNeighbour = getValueFromBoard(position.getRowIndex(), position.getColumnIndex() + 1, board);
            String bottomNeighbour = getValueFromBoard(position.getRowIndex() + 1, position.getColumnIndex(), board);
            String topNeighbour = getValueFromBoard(position.getRowIndex() - 1, position.getColumnIndex(), board);
            if(leftNeighbour.equalsIgnoreCase(nextCharacter) && !useMap[position.getRowIndex()][position.getColumnIndex() - 1]) {
                 useMap[position.getRowIndex()][position.getColumnIndex() - 1] = true;
                 leftResult = findRemaingWordLength(word, nextIndex + 1, new CharacterPosition(position.getRowIndex(), position.getColumnIndex() - 1), board, useMap);
                 if(leftResult == false){
                     useMap[position.getRowIndex()][position.getColumnIndex() - 1] = false;
                 }
            }
            if(rightNeighbour.equalsIgnoreCase(nextCharacter) && !useMap[position.getRowIndex()][position.getColumnIndex() + 1]) {
                useMap[position.getRowIndex()][position.getColumnIndex() + 1] = true;
                rightResult = findRemaingWordLength(word, nextIndex + 1, new CharacterPosition(position.getRowIndex(), position.getColumnIndex() + 1), board, useMap);
                if(rightResult == false){
                    useMap[position.getRowIndex()][position.getColumnIndex() + 1] = false;
                }
            }
            if(topNeighbour.equalsIgnoreCase(nextCharacter) && !useMap[position.getRowIndex() - 1][position.getColumnIndex()]) {
                useMap[position.getRowIndex() - 1][position.getColumnIndex()] = true;
                topResult = findRemaingWordLength(word, nextIndex + 1, new CharacterPosition(position.getRowIndex() - 1, position.getColumnIndex()), board, useMap);
                if(topResult == false){
                    useMap[position.getRowIndex() - 1][position.getColumnIndex()] = false;
                }
            }
            if(bottomNeighbour.equalsIgnoreCase(nextCharacter) && !useMap[position.getRowIndex() + 1][position.getColumnIndex()]) {
                useMap[position.getRowIndex() + 1][position.getColumnIndex()] = true;
                bottomResult = findRemaingWordLength(word, nextIndex + 1, new CharacterPosition(position.getRowIndex() + 1, position.getColumnIndex()), board, useMap);
                if(bottomResult == false){
                    useMap[position.getRowIndex() + 1][position.getColumnIndex()] = false;
                }
            }
            return leftResult || rightResult || topResult || bottomResult;
        }
    }

    private String getValueFromBoard(int rowIndex, int columnIndex, char[][] board) {
        if(rowIndex >=0 && rowIndex < board.length &&  columnIndex >=0 && columnIndex < board[0].length){
            return String.valueOf(board[rowIndex][columnIndex]);
        }
        return "";
    }

    private void buildCharacterHashMap(char[][] board, HashMap<String, List<CharacterPosition>> characterPositionHashMap) {
        int rows = board.length;
        int columns = board[0].length;
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0; columnIndex < columns; columnIndex++){
                String character = getValueFromBoard(rowIndex, columnIndex, board);
                if(characterPositionHashMap.containsKey(character)){
                    characterPositionHashMap.get(character).add(new CharacterPosition(rowIndex, columnIndex));
                }else{
                    characterPositionHashMap.put(character, new ArrayList<>(Arrays.asList(new CharacterPosition(rowIndex, columnIndex))));
                }
            }
        }
    }
}

class CharacterPosition{
    private int rowIndex;
    private int columnIndex;

    public CharacterPosition(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }
}