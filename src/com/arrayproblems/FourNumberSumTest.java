package com.arrayproblems;

import org.junit.Test;

import java.util.List;

public class FourNumberSumTest {

    @Test
    public void test1(){
        int[] input = {7,6,4,-1,1,2};
        int targetSum = 16;
        List<Integer[]> pairs = FourNumberSum.fourNumberSum(input, targetSum);
        assert pairs.size() == 2;

    }
}
