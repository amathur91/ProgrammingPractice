package com.general.problems;

import org.junit.Test;

public class LargestAlternatingSequenceDPTest {
    private LargestAlternatingSequenceDP largestAlternatingSequenceDP = new LargestAlternatingSequenceDP();

    @Test
    public void testAlternatingSequence(){
        int[] input = {1,2,3,4};
        int result = largestAlternatingSequenceDP.largestAlternatingSequence(input);
        assert result == 2;
    }

    @Test
    public void testAlternatingSequence2(){
        int[] input = {3,2,1,4};
        int result = largestAlternatingSequenceDP.largestAlternatingSequence(input);
        assert result == 3;
    }

    @Test
    public void testAlternatingSequence3(){
        int[] input = {1,3,2,4};
        int result = largestAlternatingSequenceDP.largestAlternatingSequence(input);
        assert result == 4;
    }
}
