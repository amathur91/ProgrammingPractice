package com.arrayproblems;

import org.junit.Test;

public class MaximumGapTest {
    @Test
    public void test1(){
        int[] data = {3,6,9,1};
        MaximumGap  maximumGap = new MaximumGap();
        int result = maximumGap.maximumGap(data);
        assert result == 3;
    }
    @Test
    public void test2(){
        int[] data = {15252,16764,27963,7817,26155,20757,3478,22602,20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740};
        MaximumGap  maximumGap = new MaximumGap();
        int result = maximumGap.maximumGap(data);
        assert result == 2901;
    }
}
