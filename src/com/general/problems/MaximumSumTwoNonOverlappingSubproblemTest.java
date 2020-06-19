package com.general.problems;

import org.junit.Test;

public class MaximumSumTwoNonOverlappingSubproblemTest {
    MaximumSumTwoNonOverlappingSubArray maximumSumTwoNonOverlappingSubArray = new MaximumSumTwoNonOverlappingSubArray();

    @Test
    public void test1(){
        int[] input = {2, 5, 1, 2, 7, 3, 0};
        int result = maximumSumTwoNonOverlappingSubArray.maximumNonOverlappingSum(input, 2);
        assert result == 17;
    }

    @Test
    public void test2(){
        int[] input = {10, 1, 3, 15, 30, 40, 4, 50, 2, 1};
        int result = maximumSumTwoNonOverlappingSubArray.maximumNonOverlappingSum(input, 3);
        assert result == 142;
    }
}
