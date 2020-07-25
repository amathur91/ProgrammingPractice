package com.general.problems;

import org.junit.Test;

public class StoneGameTest {
    StoneGame stoneGame = new StoneGame();

    @Test
    public void test1(){
        int[] input = {1,2,3,7};
        String result = stoneGame.stoneGameIII(input);
        assert  result.equalsIgnoreCase("Bob");
    }

    @Test
    public void test2(){
        int[] input = {1,2,3,-9};
        String result = stoneGame.stoneGameIII(input);
        assert  result.equalsIgnoreCase("Alice");
    }

    @Test
    public void test3(){
        int[] input = {1,2,3,6};
        String result = stoneGame.stoneGameIII(input);
        assert  result.equalsIgnoreCase("Tie");
    }

    @Test
    public void test4(){
        int[] input = {1,2,3,-1,-2,-3,7};
        String result = stoneGame.stoneGameIII(input);
        assert  result.equalsIgnoreCase("Alice");
    }

    @Test
    public void test5(){
        int[] input = {-1,-2,-3};
        String result = stoneGame.stoneGameIII(input);
        assert  result.equalsIgnoreCase("Tie");
    }

    @Test
    public void test6(){
        int[] input = {9,-4,0,12,-5,-13,15,6,-16,8,2,16,12,-6,13,0,-16,-11,9,-14,7,-1,14};
        String result = stoneGame.stoneGameIII(input);
        assert  result.equalsIgnoreCase("Tie");
    }
}
