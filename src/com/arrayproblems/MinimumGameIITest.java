package com.arrayproblems;

import org.junit.Test;

public class MinimumGameIITest {
    MinimumGameII minimumGameII = new MinimumGameII();

    @Test
    public void test1(){
        int[] input = {2,3,1,1,4};
        int result = minimumGameII.jump(input);
        assert result == 2;
    }

}
