package com.general.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Accepted Solution for Stone Game.
 */
public class StoneGame {
    public String stoneGameIII(int[] stoneValue) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int aliceMaxScore = performPickup(stoneValue, 0, cache);
        int[] dpArray = new int[stoneValue.length];
        for(int index = 0; index < dpArray.length; index++){
            System.out.print(dpArray[index] + " ");
        }
        System.out.println();
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

}
