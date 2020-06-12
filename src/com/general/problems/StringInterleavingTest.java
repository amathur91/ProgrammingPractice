package com.general.problems;

import org.junit.Test;

public class StringInterleavingTest {
    private StringInterleaving stringInterleaving = new StringInterleaving();

    @Test
    public void test1(){
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean result = stringInterleaving.isInterleave(s1, s2, s3);
        assert result == true;
    }
}
