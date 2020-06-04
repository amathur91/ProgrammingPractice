package com.general.problems;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class DiagonalMatrix {
    public static void main(String[] args) {
     int[][] mat = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        ArrayList<Integer> integers = printMatrixInDiagonalFor(mat, mat.length, mat[0].length);
    }

    private static ArrayList<Integer> printMatrixInDiagonalFor(int[][] matrix, int rows, int columns) {
        ArrayList<Integer> result = new ArrayList<>();
        int totalSum = rows + columns;
        boolean flag = false;
        for(int sum = 0; sum < totalSum ; sum++){
            ArrayList<Num> numbers = new ArrayList<>();
           for(int i = 0 ; i < rows; i++){
               for(int j = 0; j < columns; j++){
                   if(i + j == sum){
                       Num num = new Num(matrix[i][j]);
                       num.setRowIndex(i);
                       num.setColumnIndex(j);
                       numbers.add(num);
                   }else if(i + j > sum){
                       continue;
                   }
               }
           }
           if(flag){
               numbers.sort(new Comparator<Num>() {
                   @Override
                   public int compare(Num o1, Num o2) {
                       return o2.getColumnIndex() - o1.getColumnIndex();
                   }
               });
           }else{
               numbers.sort(new Comparator<Num>() {
                   @Override
                   public int compare(Num o1, Num o2) {
                       return o1.getColumnIndex() - o2.getColumnIndex();
                   }
               });
           }
           for(Num num : numbers){
               result.add(num.getValue());
           }
            flag = !flag;
        }
        return result;
    }
}

class Num{
    private int rowIndex;
    private int columnIndex;
    private int value;

    public Num(int value) {
        this.value = value;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
