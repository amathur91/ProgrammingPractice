package com.designpattern.compositepattern;

public class KadaneLargestContinousSumInArray {
    public static void main(String args[]){
        int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
        int maxSum = findMaximumSumInArray(input);
        System.out.println("Maximum Sum : " + maxSum);
    }

    private static int findMaximumSumInArray(int[] input) {
        int maxSumSoFar = 0;
        int lastMax = 0;
        for(int i = 0 ; i < input.length; i++){
           int currentNumber = input[i];
           maxSumSoFar += currentNumber;
           if(maxSumSoFar < 0){
               maxSumSoFar = 0;
           }
           if(maxSumSoFar > lastMax){
               lastMax = maxSumSoFar;
           }
        }
        return lastMax;
    }
}
