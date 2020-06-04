package com.general.problems;

/**
 * This computes largest alternating sequence.
 */
public class LargestAlternatingSequenceDP {
    private int ASCENDING = 0;
    private int DECENDING = 1;
    public int largestAlternatingSequence(int[] input){
        int rows = input.length;
        int columns = 2;
        int[][] computeTable = new int[input.length][2];
        for(int rowIndex = 0; rowIndex < rows; rowIndex++){
            for(int columnIndex = 0 ; columnIndex < columns; columnIndex++){
                computeTable[rowIndex][columnIndex] = 1;
            }
        }

        int maxValue = Integer.MIN_VALUE;
        for(int num = 0; num < input.length; num++){
            for(int j = 0 ; j < num; j++){
                int num2 = input[num];
                int num1 = input[j];
                if(num1 < num2){
                    //this marks end of decreasing sequence and addition of 1 increasing number
                    computeTable[num][ASCENDING] = Math.max(computeTable[num][ASCENDING],
                                                            1 + computeTable[j][DECENDING]);
                    if( computeTable[num][ASCENDING] > maxValue){
                        maxValue =  computeTable[num][ASCENDING];
                    }
                }else{
                    //this marks end of increasing sequence and addition of 1 decreasing number
                    computeTable[num][DECENDING] = Math.max(computeTable[num][DECENDING],
                                                            1 + computeTable[num][ASCENDING]);
                    if(computeTable[num][DECENDING] > maxValue){
                        maxValue = computeTable[num][DECENDING];
                    }
                }
            }
        }
        return maxValue;
    }
}
