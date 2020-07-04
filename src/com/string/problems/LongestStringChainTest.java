package com.string.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestStringChainTest {

    @Test
    public void test1(){

        List<String> list = new ArrayList(Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"));
        LongestStringChain.longestStringChain(list);
    }

    @Test
    public void test2(){

        List<String> list = new ArrayList(Arrays.asList("abcdefg1",
                "1234c",
                "abdefg2",
                "abdfg",
                "123",
                "122",
                "bgg",
                "g",
                "1a2345",
                "12a345"));
        LongestStringChain.longestStringChain(list);
    }
}
