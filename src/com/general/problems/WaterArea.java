package com.general.problems;

/**
 * Solution of Water Area AlgoExpert
 * Complexity O(n)
 */
public class WaterArea {
    public static void main(String args[]){
        int[] heights = {0, 8, 0, 0, 10, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        int totalArea = waterArea(heights);
        System.out.println(totalArea);
    }
    public static int waterArea(int[] heights) {
        if(heights.length == 0){
            return 0;
        }
        int[] leftMaxHeight = new int[heights.length];
        int[] rightMaxHeight = new int[heights.length];
        int totalArea = 0;

        //populate the leftMaxHeight
        leftMaxHeight[0] = 0;
        int maxHeight = heights[0];
        for(int index = 1; index < leftMaxHeight.length; index++){
            leftMaxHeight[index] = maxHeight;
            if(heights[index] > maxHeight){
                maxHeight = heights[index];
            }
        }

        //populate the rightHeight
        rightMaxHeight[rightMaxHeight.length - 1] = 0;
        maxHeight  = heights[heights.length - 1];
        for(int index = rightMaxHeight.length - 2; index >= 0; index--){
            rightMaxHeight[index] = maxHeight;
            if(heights[index] > maxHeight){
                maxHeight = heights[index];
            }
        }

        for(int index = 0; index < heights.length ; index++){
            int minNeighbourBuildingHeight = Math.min(leftMaxHeight[index], rightMaxHeight[index]);
            if(heights[index] < minNeighbourBuildingHeight){
                totalArea += minNeighbourBuildingHeight - heights[index];
            }
        }

        return totalArea;
    }
}
