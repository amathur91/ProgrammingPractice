package com.general.problems;

import org.junit.Test;

public class QueueReconstructionTest {
    private QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();

    @Test
    public void testQueueContruction1(){
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] reconstructQueue = queueReconstructionByHeight.reconstructQueue(input);
        for(int index = 0; index < reconstructQueue.length; index++){
            System.out.println(reconstructQueue[index][0] + "," + reconstructQueue[index][1]);
        }
    }
}
