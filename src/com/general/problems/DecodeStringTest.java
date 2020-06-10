package com.general.problems;

import org.junit.Test;

public class DecodeStringTest {
    private  DecodeString decodeString = new DecodeString();

    @Test
    public void test1(){
        String input = "3[a]2[bc]";
        String decodedString = decodeString.decode(input);
        assert decodedString.equalsIgnoreCase("aaabcbc");
    }


    @Test
    public void test2(){
        String input = "3[a2[c]]";
        String decodedString = decodeString.decode(input);
        assert decodedString.equalsIgnoreCase("accaccacc");
    }
}
