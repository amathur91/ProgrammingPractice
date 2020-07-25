package com.general.problems;

import org.junit.Test;

public class StrangePrinterTest {

    private StrangePrinter strangePrinter = new StrangePrinter();

    @Test
    public void test1(){
        String input = "aaabbb";
        int result = strangePrinter.strangePrinter(input);
        assert result == 2;
    }

    @Test
    public void test2(){
        String input = "aba";
        int result = strangePrinter.strangePrinter(input);
        assert result == 2;
    }

    @Test
    public void test3(){
        String input = "abc";
        int result = strangePrinter.strangePrinter(input);
        assert result == 3;
    }

    @Test
    public void test4(){
        String input = "ccaa";
        int result = strangePrinter.strangePrinter(input);
        assert result == 2;
    }

    @Test
    public void test5(){
        String input = "tbgtgb";
        int result = strangePrinter.strangePrinter(input);
        assert result == 4;
    }

    @Test
    public void test6(){
        String input = "ababc";
        int result = strangePrinter.strangePrinter(input);
        assert result == 4;
    }

    @Test
    public void test7(){
        String input = "baacdddaaddaaaaccbddbcabdaabdbbcdcbbbacbddcabcaaa";
        int result = strangePrinter.strangePrinter(input);
        assert result == 19;
    }
    @Test
    public void test8(){
        String input = "dddccbdbababaddcbcaabdbdddcccddbbaabddb";
        int result = strangePrinter.strangePrinter(input);
        assert result == 15;
    }
}
