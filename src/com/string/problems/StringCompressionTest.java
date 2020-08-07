package com.string.problems;

import org.junit.Test;

public class StringCompressionTest {
    private StringCompression stringCompression = new StringCompression();

    @Test
    public void test1(){
        String inputString = "aaabcccd";
        int k = 2;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 4;
    }

    @Test
    public void test2(){
        String inputString = "aabbaa";
        int k = 2;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 2;
    }

    @Test
    public void test3(){
        String inputString = "aaaaaaaaaaa";
        int k = 0;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 3;
    }

    @Test
    public void test4(){
        String inputString = "a";
        int k = 1;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 0;
    }

    @Test
    public void test5(){
        String inputString = "abc";
        int k = 2;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 1;
    }

    @Test
    public void test9(){
        String inputString = "aabaabbcbbbaccc";
        int k = 6;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 4;
    }

    @Test
    public void test6(){
        String inputString = "abcdefghijklmnopqrstuvwxyz";
        int k = 16;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 10;
    }

    @Test
    public void test7(){
        String inputString = "bababbaba";
        int k = 1;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 7;
    }

    @Test
    public void test8(){
        String inputString = "llllllllllttttttttt";
        int k = 1;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 4;
    }

    @Test
    public void test10(){
        String inputString = "kgklijflgagdniohkhjhnoo";
        int k = 21;
        int result = stringCompression.getLengthOfOptimalCompression(inputString, k);
        assert result == 2;
    }
}
