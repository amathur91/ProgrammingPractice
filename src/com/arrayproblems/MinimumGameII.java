package com.arrayproblems;

/**
 * https://leetcode.com/problems/jump-game-ii/submissions/
 * Time Complexity : O(n2)
 * Runtime: 312 ms, faster than 20.88% of Java online submissions for Jump Game II.
 * Memory Usage: 41.6 MB, less than 33.50% of Java online submissions for Jump Game II.
 */
public class MinimumGameII {
    public int jump(int[] nums) {
        int[] minStepsArray = new int[nums.length];
        for(int stepIndex = 0; stepIndex < nums.length; stepIndex++){
            int steps = nums[stepIndex];
            int currentStepCost = minStepsArray[stepIndex];
            if(steps > 0) {
                for (int nextStepIndex = 1; nextStepIndex <= steps && stepIndex+nextStepIndex < nums.length; nextStepIndex++) {
                    int currentCost = minStepsArray[stepIndex + nextStepIndex];
                    int possibleCost = currentStepCost + 1;
                    if (currentCost == 0) {
                        minStepsArray[stepIndex + nextStepIndex] = possibleCost;
                    } else if (currentCost > possibleCost) {
                        minStepsArray[stepIndex + nextStepIndex] = possibleCost;
                    }
                }
            }
        }
        return minStepsArray[minStepsArray.length - 1];

    }
}
