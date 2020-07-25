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


}
