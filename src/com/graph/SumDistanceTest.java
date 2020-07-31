package com.graph;

import org.junit.Test;

public class SumDistanceTest {
    private SumDistances sumDistance = new SumDistances();

    @Test
    public void test1() {
        int totalVertices = 6;
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}};
        int[] result = sumDistance.sumDistancesInTree(totalVertices, edges);
        assert result[0] == 8;
        assert result[1] == 12;
        assert result[2] == 6;
        assert result[3] == 10;
        assert result[4] == 10;
        assert result[5] == 10;
    }

}
