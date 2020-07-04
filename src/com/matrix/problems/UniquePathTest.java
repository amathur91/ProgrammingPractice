package com.matrix.problems;

import org.junit.Test;

public class UniquePathTest {
    private  UniquePaths uniquePaths = new UniquePaths();

    @Test
    public void test1(){
        UniquePaths uniquePaths = new UniquePaths();
        int result = uniquePaths.uniquePaths(7, 3);
        assert result == 28;
    }
}
