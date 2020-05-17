package com.general.problems;

public class MinimumJumpsToReachEnd {
    public static void main(String args[]){
        int[] input = {1,1,3,6,9,3,0,1,3};
        int minimumSteps = findMinimumStepsToReachEndRecursively(input);
        System.out.println("Minimum Steps : " + minimumSteps);
    }

    private static int findMinimumStepsToReachEndRecursively(int[] input) {
        int startIndex = 0;
        int destinationIndex = input.length - 1;
        return moveStepsRecursively(input, startIndex, destinationIndex, 0);
    }

    private static int moveStepsRecursively(int[] input, int currentIndex, int destinationIndex, int steps) {
        if(currentIndex == destinationIndex){
            return steps;
        }else if (currentIndex > destinationIndex){
            return Integer.MAX_VALUE;
        }
        else if(input[currentIndex] == 0){
            return Integer.MAX_VALUE;
        }
        else{
            int move = 1;
            int minSteps = Integer.MAX_VALUE;
            while(move <= input[currentIndex]){
                int result = moveStepsRecursively(input, currentIndex + move, destinationIndex, steps + 1);
                minSteps = Math.min(result, minSteps);
                move++;
            }
            return minSteps;
        }
    }
}
