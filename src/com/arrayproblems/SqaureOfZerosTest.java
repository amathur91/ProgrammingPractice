package com.arrayproblems;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SqaureOfZerosTest {

    @Test
    public void test1(){
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1,1,1,0,1,0)));
        matrix.add(new ArrayList<>(Arrays.asList(0,0,0,0,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(0,1,0,1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(0,0,0,1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(0,1,1,1,0,1)));
        matrix.add(new ArrayList<>(Arrays.asList(0,0,0,0,0,1)));
        boolean result = SquareOfZeros.squareOfZeroes(matrix);
        assert result == true;
    }
}
