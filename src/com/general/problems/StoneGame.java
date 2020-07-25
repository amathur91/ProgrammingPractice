package com.general.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Accepted Solution for Stone Game.
 * Runtime: 30 ms, faster than 47.24% of Java online submissions for Stone Game III.
 * Memory Usage: 115.3 MB, less than 6.06% of Java online submissions for Stone Game III.
 */
public class StoneGame {
    public String stoneGameIII(int[] stoneValue) {
        HashMap<Integer, Integer> cache = new HashMap<>();
//        int aliceMaxScore = performPickup(stoneValue, 0, cache); Commenting the Recursive Approach
        int[] dpArray = new int[4];     //Memory Optimization
        for(int index = stoneValue.length - 1; index >= 0; index--){
            performPickupDP(stoneValue,index, dpArray);
        }
        int aliceMaxScore = dpArray[0];
        if(aliceMaxScore > 0){
            return "Alice";
        }
        if(aliceMaxScore == 0){
            return "Tie";
        }
        return "Bob";
    }
    private int performPickup(int[] stoneValue, int index, HashMap<Integer, Integer> cache){
        if(index >= stoneValue.length){
            return 0;
        }
        if(cache.containsKey(index)){
            System.out.println("Look up for Index : " + index);
            return cache.get(index);
        }
        int playerPick1Stone = stoneValue[index] - performPickup(stoneValue, index + 1, cache);
        int playerPick2Stone = Integer.MIN_VALUE;
        int playerPick3Stone = Integer.MIN_VALUE;
        if(index + 1 < stoneValue.length){
            playerPick2Stone = stoneValue[index] + stoneValue[index + 1] -  performPickup(stoneValue, index + 2, cache);
        }
        if(index + 2 < stoneValue.length){
            playerPick3Stone = stoneValue[index] + stoneValue[index + 1] + stoneValue[index+ 2] - performPickup(stoneValue, index + 3, cache);
        }
        int result = Math.max(playerPick1Stone, Math.max(playerPick2Stone, playerPick3Stone));
        cache.put(index, result);
        System.out.println("Saving the answer  for Index " + index + " is : " + result );
        return result;
    }

    private void performPickupDP(int[] stoneValue, int index,int[] dpArray){
            int playerPick1Stone = stoneValue[index] - dpArray[(index + 1) % 4];
            int playerPick2Stone = Integer.MIN_VALUE;
            int playerPick3Stone = Integer.MIN_VALUE;
            if (index + 1 < stoneValue.length) {
                playerPick2Stone = stoneValue[index] + stoneValue[index + 1] - dpArray[(index + 2)%4];
            }
            if (index + 2 < stoneValue.length) {
                playerPick3Stone = stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2] - dpArray[(index + 3)%4];
            }
            int result = Math.max(playerPick1Stone, Math.max(playerPick2Stone, playerPick3Stone));
            dpArray[(index)%4] = result;
    }
}
