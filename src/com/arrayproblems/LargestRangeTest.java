package com.arrayproblems;

import org.junit.Test;

public class LargestRangeTest {

    @Test
    public void test1(){
        int[] input = {2,3,4,5,6};
        int[] ints = LargestRange.largestRange(input);
        assert ints[0] == 2;
        assert ints[1] == 6;
    }

    @Test
    public void test2(){
        int[] input = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] ints = LargestRange.largestRange(input);
        assert ints[0] == 0;
        assert ints[1] == 7;
    }

    @Test
    public void test3(){
        int[] input = {4, 2, 1, 3};
        int[] ints = LargestRange.largestRange(input);
        assert ints[0] == 1;
        assert ints[1] == 4;
    }
}
