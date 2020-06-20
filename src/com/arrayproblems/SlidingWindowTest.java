package com.arrayproblems;

import org.junit.Test;

public class SlidingWindowTest {
    public SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

    @Test
    public void test1(){
        int[] input = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = slidingWindowMaximum.maxSlidingWindow(input, k);
        System.out.println(result);
    }

    @Test
    public void test2(){
        int[] input = {-95,92,-85,59,-59,-14,88,-39,2,92,94,79,78,-58,37,48,63,-91,91,74,-28,39,90,-9,-72,-88,-72,93,38,14,-83,-2,21,4,-75,-65,3,63,100,59,-48,43,35,-49,48,-36,-64,-13,-7,-29,87,34,56,-39,-5,-27,-28,10,-57,100,-43,-98,19,-59,78,-28,-91,67,41,-64,76,5,-58,-89,83,26,-7,-82,-32,-76,86,52,-6,84,20,51,-86,26,46,35,-23,30,-51,54,19,30,27,80,45,22};
        int k = 10;
        int[] result = slidingWindowMaximum.maxSlidingWindow(input, k);
        System.out.println(result);
    }
}
