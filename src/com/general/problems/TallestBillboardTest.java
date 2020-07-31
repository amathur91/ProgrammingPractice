package com.general.problems;

import org.junit.Test;

public class TallestBillboardTest {
    private TallestBillBoardDP tallestBillboard = new TallestBillBoardDP();
    @Test
    public void test1(){
        int[] input = {1,2,3,6};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 6;
    }

    @Test
    public void test2(){
        int[] input = {1,2,3,4,5,6};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 10;
    }

    @Test
    public void test3(){
        int[] input = {1,2};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 0;
    }

    @Test
    public void test4(){
        int[] input = {1,2,4,8,16,32,64,128,256,512};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 0;
    }

    @Test
    public void test5(){
        int[] input = {100,100};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 100;
    }
    @Test
    public void test6(){
        int[] input = {118,131,127,121,126,123,124,111,105,125,103,132,101,121,110,144,114,120,124};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 1140;
    }
    @Test
    public void test7(){
        int[] input = {221,183,216,208,214,226,188,208,194,197,205,184,204,195,208,176,173};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 1612;
    }
    @Test
    public void test8(){
        int[] input = {3,4,3,3,2};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 6;
    }
    @Test
    public void test9(){
        int[] input = {33,30,41,34,37,29,26,31,42,33,38,27,33,31,35,900,900,900,900,900};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 2050;
    }

    @Test
    public void test10(){
        int[] input = {61,45,43,54,40,53,55,47,51,59,42};
        int result = tallestBillboard.tallestBillboard(input);
        assert result == 275;
    }
}
