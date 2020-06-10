package com.general.problems;

/**
 * https://leetcode.com/problems/toeplitz-matrix/
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix){
        int rows = matrix.length;
        int columns = matrix[0].length;

        //from n0 to 00
        int temp = rows;
        while(temp > 0){
            boolean result = checkDiagonally(matrix, temp,0);
            if(!result){
                return false;
            }
            temp--;
        }
        
        //for 00
        boolean midResult = checkDiagonally(matrix, 0, 0);
        if(!midResult){
            return false;
        }

        //00 to 0m
        temp = 0;
        while(temp < columns){
            boolean result = checkDiagonally(matrix, 0,temp);
            if(!result){
                return false;
            }
            temp++;
        }
        return true;
    }

    private boolean checkDiagonally(int[][] matrix, int rowIndex, int columnIndex) {
        int value = -1;
        while(isValidCoordinates(matrix, rowIndex,columnIndex)){
            if(value == -1){
                value = matrix[rowIndex][columnIndex];
            }else{
                if(value != matrix[rowIndex][columnIndex]){
                    return false;
                }
            }
            rowIndex += 1;
            columnIndex += 1;
        }
        return true;
    }

    private boolean isValidCoordinates(int[][] matrix, int rowIndex, int columnIndex) {
        return rowIndex >=0 && rowIndex < matrix.length && columnIndex >=0 && columnIndex < matrix[0].length;
    }
}
