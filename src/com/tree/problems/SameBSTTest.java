package com.tree.problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTTest {

    @Test
    public void test1(){
        List<Integer> list1 = new ArrayList<>(Arrays.asList(10,15,8,12,94,81,5,2,11));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(10,8,5,15,2,12,11,94,81));

        boolean result = SameBST.sameBsts(list1, list2);
        assert result == true;
    }
}
