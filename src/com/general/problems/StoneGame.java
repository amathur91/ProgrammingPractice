package com.general.problems;

public class StoneGame {
    public String stoneGameIII(int[] stoneValue) {

        int aliceMaxScore = performPickup(stoneValue, 0);
        if(aliceMaxScore > 0){
            return "Alice";
        }
        if(aliceMaxScore == 0){
            return "Tie";
        }
        return "Bob";
    }
    private int performPickup(int[] stoneValue, int index){
        if(index >= stoneValue.length){
            return 0;
        }
        int playerPick1Stone = stoneValue[index] - performPickup(stoneValue, index + 1);
        int playerPick2Stone = Integer.MIN_VALUE;
        int playerPick3Stone = Integer.MIN_VALUE;
        if(index + 1 < stoneValue.length){
            playerPick2Stone = stoneValue[index] + stoneValue[index + 1] -  performPickup(stoneValue, index + 2);
        }
        if(index + 2 < stoneValue.length){
            playerPick3Stone = stoneValue[index] + stoneValue[index + 1] + stoneValue[index+ 2] - performPickup(stoneValue, index + 3);
        }
        return Math.max(playerPick1Stone, Math.max(playerPick2Stone, playerPick3Stone));
    }




}
