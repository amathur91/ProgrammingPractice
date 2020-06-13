package com.arrayproblems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThanTest {

    @Test
    public void test1(){
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(11);
        list.add(-1);
        list.add(3);
        list.add(4);
        list.add(2);
        List<Integer> integers = RightSmallerThan.rightSmallerThan(list);
        assert integers.get(0) == 5;
        assert integers.get(1) == 4;
        assert integers.get(2) == 4;
        assert integers.get(3) == 0;
        assert integers.get(4) == 1;
        assert integers.get(5) == 1;
        assert integers.get(6) == 0;
    }

    @Test
    public void test2(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(13);
        List<Integer> integers = RightSmallerThan.rightSmallerThan(list);
        assert integers.get(0) == 0;
        assert integers.get(1) == 0;
        assert integers.get(2) == 0;
        assert integers.get(3) == 0;
        assert integers.get(4) == 0;
        assert integers.get(5) == 0;
        assert integers.get(6) == 0;
        assert integers.get(7) == 0;
    }
}
