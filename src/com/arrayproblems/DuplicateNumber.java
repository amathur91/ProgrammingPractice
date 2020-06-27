package com.arrayproblems;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slowPointerIndex = 0;
        int fastPointerIndex = 0;
        slowPointerIndex = nums[slowPointerIndex];
        fastPointerIndex = nums[fastPointerIndex];
        fastPointerIndex = nums[fastPointerIndex];
        while(slowPointerIndex != fastPointerIndex){
            slowPointerIndex = nums[slowPointerIndex];
            fastPointerIndex = nums[fastPointerIndex];
            fastPointerIndex = nums[fastPointerIndex];
        }
        slowPointerIndex = 0;

        while(slowPointerIndex != fastPointerIndex){
            slowPointerIndex = nums[slowPointerIndex];
            fastPointerIndex = nums[fastPointerIndex];
        }
        return slowPointerIndex;
    }
}
