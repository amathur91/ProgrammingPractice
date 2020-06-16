package com.general.problems;

import org.junit.Test;

public class StringInterleavingTest {
    private StringInterleaving stringInterleaving = new StringInterleaving();

    @Test
    public void test1(){
        String s1 = "algoexpert";
        String s2 = "your-dream-job";
        String s3 = "your-algodream-expertjob";
        boolean result = stringInterleaving.isInterleave(s1, s2, s3);
        assert result == true;
    }
}
