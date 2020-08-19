package com.general.problems;

import org.junit.Test;

public class ValidParenthesisTest {
    private ValidParenthesis validParenthesis = new ValidParenthesis();

    @Test
    public void test1(){
        String input = "()";
        boolean result = validParenthesis.checkValidString(input);
        assert result == true;
    }

    @Test
    public void test2(){
        String input = "(*)";
        boolean result = validParenthesis.checkValidString(input);
        assert result == true;
    }

    @Test
    public void test3(){
        String input = "(*))";
        boolean result = validParenthesis.checkValidString(input);
        assert result == true;
    }

    @Test
    public void test4(){
        String input = "(*))";
        boolean result = validParenthesis.checkValidString(input);
        assert result == true;
    }

    @Test
    public void test5(){
        String input = "()(";
        boolean result = validParenthesis.checkValidString(input);
        assert result == false;
    }


    @Test
    public void test6(){
        String input = "(*";
        boolean result = validParenthesis.checkValidString(input);
        assert result == true;
    }

    @Test
    public void test7(){
        String input = "(*()";
        boolean result = validParenthesis.checkValidString(input);
        assert result == true;
    }
    @Test
    public void test8(){
        String input = "(((******))";
        boolean result = validParenthesis.checkValidString(input);
        assert result == true;
    }

    @Test
    public void test9(){
        String input = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        boolean result = validParenthesis.checkValidString(input);
        assert result == false;
    }
}
