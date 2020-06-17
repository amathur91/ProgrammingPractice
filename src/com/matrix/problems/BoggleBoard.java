package com.matrix.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Solution for Boggle Board
 */
public class BoggleBoard {
    public static List<String> boggleBoard(char[][] board, String[] words) {
        HashMap<String, List<Position>> positionMap = new HashMap<>();
        buildPositionMap(positionMap, board);
        List<String> finalResult = new ArrayList<>();
        for(String word : words){
            boolean result = isWordPresent(word, positionMap);
            if(result){
                finalResult.add(word);
            }
        }
        return finalResult;
    }

    private static boolean isWordPresent(String word, HashMap<String, List<Position>> positionMap) {
        HashMap<String, List<Position>> positionsMapped = new HashMap<>();
        boolean result = checkWordUsingDFS(word, 0, positionMap, positionsMapped, null);
        return result;
    }

    private static boolean checkWordUsingDFS(String word, int position, HashMap<String, List<Position>> positionMap, HashMap<String, List<Position>> positionsMapped, Position previousPosition) {
        if(position < word.length()){
            String character = String.valueOf(word.charAt(position));
            if(positionMap.containsKey(character)){
                List<Position> positionList = positionMap.get(character);
                boolean result = false;
                for(Position pos : positionList){
                    if(previousPosition == null){
                        positionsMapped.clear();
                    }
                    if(previousPosition == null || (isNeighbour(pos, previousPosition) &&
                            (positionsMapped.get(character) == null || !positionsMapped.get(character).contains(pos)))) {
                        addValueToMap(positionsMapped, character, pos);
                        result = checkWordUsingDFS(word, position + 1, positionMap, positionsMapped, pos);
                        if (result) {
                            return result;
                        }else{
                            positionsMapped.get(character).remove(pos);
                        }
                    }
                }
                return result;
            }else{
                return false;
            }
        }
        return true;
    }

    private static void addValueToMap(HashMap<String, List<Position>> positionsMapped, String character, Position pos) {
        if(positionsMapped.containsKey(character)){
            positionsMapped.get(character).add(pos);
        }else{
            ArrayList<Position> positionArrayList = new ArrayList<>();
            positionArrayList.add(pos);
            positionsMapped.put(character, positionArrayList);
        }
    }

    private static boolean isNeighbour(Position pos, Position previousPosition) {
        if(previousPosition.getRowIndex() + 1 == pos.getRowIndex() && previousPosition.getColumnIndex() == pos.getColumnIndex()){ // bottom
            return true;
        }
        if(previousPosition.getColumnIndex() + 1 == pos.getColumnIndex() && previousPosition.getRowIndex() == pos.getRowIndex()){ // right
            return true;
        }
        if(previousPosition.getRowIndex() + 1 == pos.getRowIndex() && previousPosition.getColumnIndex() + 1 == pos.getColumnIndex()){  //bottom right
            return true;
        }
        if(previousPosition.getRowIndex() - 1 == pos.getRowIndex() && previousPosition.getColumnIndex() == pos.getColumnIndex()){ // top
            return true;
        }
        if(previousPosition.getRowIndex() - 1 == pos.getRowIndex() && previousPosition.getColumnIndex() - 1 == pos.getColumnIndex()){ // top left
            return true;
        }
        if(previousPosition.getColumnIndex() - 1 == pos.getColumnIndex() && previousPosition.getRowIndex() + 1 == pos.getRowIndex()){ //bottom left.
            return true;
        }
        if(previousPosition.getColumnIndex() + 1 == pos.getColumnIndex() && previousPosition.getRowIndex() - 1 == pos.getRowIndex()){ //top right
            return true;
        }
        if(previousPosition.getColumnIndex() - 1 == pos.getColumnIndex() && previousPosition.getRowIndex() == pos.getRowIndex()){ //left
            return true;
        }
        return false;
    }

    private static void buildPositionMap(HashMap<String, List<Position>> positionMap, char[][] board) {
        for(int rowIndex = 0; rowIndex < board.length; rowIndex++){
            for(int columnIndex = 0; columnIndex < board[0].length; columnIndex++){
                String character = String.valueOf(board[rowIndex][columnIndex]);
                if(positionMap.containsKey(character)){
                    //append this new position
                    Position position = new Position(rowIndex, columnIndex);
                    positionMap.get(character).add(position);
                }else{
                    //add to this map
                    ArrayList<Position> positionsList = new ArrayList<>();
                    positionsList.add(new Position(rowIndex, columnIndex));
                    positionMap.put(character, positionsList);
                }
            }
        }
    }
}

class Position{
    private int rowIndex;
    private int columnIndex;

    public Position(int rowIndex, int columnIndex) {
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
