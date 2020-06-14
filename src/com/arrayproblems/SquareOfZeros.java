package com.arrayproblems;

import java.util.List;

/**
 * Algoexpert Square of Zeros Accepted Solution
 */
public class SquareOfZeros {
    public static boolean squareOfZeroes(List<List<Integer>> matrix) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();
        int[][] verticalCount = new int[rows][columns];
        int[][] horizontalCount = new int[rows][columns];

        //build up the vertical count matrix.
        buildVerticalCountMatrix(matrix, rows, columns, verticalCount);

        //build horizontal Count Matrix
        buildHorizontalCountMatrix(matrix, rows, columns, horizontalCount);

        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0 ; columnIndex < columns; columnIndex++){
                if(matrix.get(rowIndex).get(columnIndex) == 0 && horizontalCount[rowIndex][columnIndex] > 1 && verticalCount[rowIndex][columnIndex] > 1){
                    for(int squareMatrixCount = 2; squareMatrixCount <= rows; squareMatrixCount++){
                        int topLeftCornerRow = rowIndex;
                        int topLeftCornerColumn = columnIndex;

                        int topRightCornerRow = topLeftCornerRow;
                        int topRightCornerColumn = topLeftCornerColumn + squareMatrixCount - 1;

                        int leftBottonCornerRow = topLeftCornerRow + squareMatrixCount - 1;
                        int leftBottonCornerColumn = topLeftCornerColumn;

                        if(horizontalCount[rowIndex][columnIndex] >= squareMatrixCount && verticalCount[topRightCornerRow][topRightCornerColumn] >= squareMatrixCount
                         && verticalCount[rowIndex][columnIndex] >=squareMatrixCount && horizontalCount[leftBottonCornerRow][leftBottonCornerColumn] >= squareMatrixCount){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void buildHorizontalCountMatrix(List<List<Integer>> matrix, int rows, int columns, int[][] horizontalCount) {
        for(int rowIndex = rows - 1; rowIndex >=0; rowIndex--){
            for(int columnIndex = columns - 1; columnIndex >=0; columnIndex--){
                if(matrix.get(rowIndex).get(columnIndex) == 1){
                    horizontalCount[rowIndex][columnIndex] = 0;
                }else if(matrix.get(rowIndex).get(columnIndex) == 0){
                    if(columnIndex == columns - 1){
                        horizontalCount[rowIndex][columnIndex] = 1;
                    }else{
                        horizontalCount[rowIndex][columnIndex] = 1 + horizontalCount[rowIndex][columnIndex + 1];
                    }
                }
            }
        }
    }

    private static void buildVerticalCountMatrix(List<List<Integer>> matrix, int rows, int columns, int[][] verticalCount) {
        for(int columnIndex = columns - 1; columnIndex >=0; columnIndex--){
            for(int rowIndex = rows - 1; rowIndex >=0; rowIndex--){
                if(matrix.get(rowIndex).get(columnIndex) == 1){
                    verticalCount[rowIndex][columnIndex] = 0;
                }else if(matrix.get(rowIndex).get(columnIndex) == 0){
                    if(rowIndex == rows - 1){
                        verticalCount[rowIndex][columnIndex] = 1;
                    }else{
                        verticalCount[rowIndex][columnIndex] = 1 + verticalCount[rowIndex + 1][columnIndex];
                    }
                }
            }
        }
    }
}
