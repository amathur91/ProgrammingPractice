package com.general.problems;

import org.junit.Test;

public class PossibleBiPartitionTest {

    @Test
    public void testBiPartition(){
        int[][] dislikes = {{1,2},{1,3},{2,4}};
        int N = 4;
        PossibleBiPartition possibleBiPartition = new PossibleBiPartition();
        possibleBiPartition.possibleBipartition(N, dislikes);
    }

    @Test
    public void testBiPartition_Case2(){
        int[][] dislikes = {{1,2},{3,4},{5,6},{6,7},{8,9},{7,8}};
        int N = 10;
        PossibleBiPartition possibleBiPartition = new PossibleBiPartition();
        boolean result = possibleBiPartition.possibleBipartition(N, dislikes);
        System.out.println(result);
    }


}
