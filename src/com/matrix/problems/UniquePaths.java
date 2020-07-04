package com.matrix.problems;

/**
 * Unique Path Solution Leetcode
 * https://leetcode.com/problems/unique-paths/submissions/
 * Time Complexity : O(m*n)
 * Memory Complexity : O(m*n)
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int rows = m;
        int columns = n;
        int[][] computeMatrix = new int[m][n];

        computeMatrix[rows - 1][columns - 1] = 1;
        for(int rowIndex = rows - 1; rowIndex >= 0; rowIndex--){
            for(int columnIndex = columns - 1; columnIndex >= 0; columnIndex--){
                fillValues(computeMatrix, rowIndex, columnIndex);
            }
        }
        return computeMatrix[0][0];
    }


    private void fillValues(int[][] computeMatrix, int rowIndex, int columnIndex) {
        if(rowIndex == computeMatrix.length - 1 && columnIndex == computeMatrix[0].length - 1){
         computeMatrix[rowIndex][columnIndex] = 1;
        }else {
            int rightNeighbourValue = getValue(rowIndex, columnIndex + 1, computeMatrix);
            int bottomNeighbourValue = getValue(rowIndex + 1, columnIndex, computeMatrix);
            computeMatrix[rowIndex][columnIndex] = rightNeighbourValue + bottomNeighbourValue;
        }
    }

    private int getValue(int rowIndex, int columnIndex, int[][] computeMatrix) {
        if(rowIndex >= 0 && rowIndex < computeMatrix.length && columnIndex >= 0 && columnIndex < computeMatrix[0].length ){
            return computeMatrix[rowIndex][columnIndex];
        }
        return 0;
    }
}
