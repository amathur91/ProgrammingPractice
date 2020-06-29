package com.arrayproblems;

import org.junit.Test;

import java.util.List;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void test1(){
        int[] input = {5, 7, -24, 12, 10, 2, 3, 12, 5, 6, 35};
        List<Integer> integers = LongestIncreasingSubsequence.longestIncreasingSubsequence(input);
        for(Integer num : integers){
            System.out.print(num + " ");
        }
    }
}
