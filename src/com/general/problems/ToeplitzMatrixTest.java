package com.general.problems;

import org.junit.Test;

public class ToeplitzMatrixTest {
    private ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();

    @Test
    public void test1(){
        int[][] input = {{1,2,3,4},
                        {5,1,2,3},
                        {9,5,1,2}};
        boolean result = toeplitzMatrix.isToeplitzMatrix(input);
        assert result == true;
    }

    @Test
    public void test2(){
        int[][] input = {{1,2},
                        {1,2}};
        boolean result = toeplitzMatrix.isToeplitzMatrix(input);
        assert result == false;
    }
}
