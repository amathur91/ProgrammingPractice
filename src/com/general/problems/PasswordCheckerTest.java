package com.general.problems;

import org.junit.Test;

public class PasswordCheckerTest {
    private PasswordChecker passwordChecker = new PasswordChecker();

    @Test
    public void test1(){
        int result = passwordChecker.strongPasswordChecker("");
        assert result == 6;
    }

    @Test
    public void test2(){
        int result = passwordChecker.strongPasswordChecker("A");
        assert result == 5;
    }

    @Test
    public void test3(){
        int result = passwordChecker.strongPasswordChecker("aA1");
        assert result == 3;
    }

    @Test
    public void test4(){
        int result = passwordChecker.strongPasswordChecker("aa123");
        assert result == 1;
    }

    @Test
    public void test5(){
        int result = passwordChecker.strongPasswordChecker("aaa111");
        assert result == 2;
    }

    @Test
    public void test6(){
        int result = passwordChecker.strongPasswordChecker("aaa123");
        assert result == 1;
    }

    @Test
    public void test7(){
        int result = passwordChecker.strongPasswordChecker("1111111111");
        assert result == 3;
        // 11 11 11 11
        // 11 11 11 11 11
    }

    @Test
    public void test8(){
        int result = passwordChecker.strongPasswordChecker("ABABABABABABABABABAB1");
        assert result == 2;
    }

    @Test
    public void test9(){
        int result = passwordChecker.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa");
        assert result == 7;
    }

}
