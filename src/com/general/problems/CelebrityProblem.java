package com.general.problems;

public class CelebrityProblem {
    public static void main(String args[]){
        int[][] party = { {0, 0, 1, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0},
                        {0, 0, 1, 0}};
//        int[][] party = { {0, 0, 1, 0},
//                            {0, 0, 1, 0},
//                            {0, 1, 0, 0},
//                            {0, 0, 1, 0} };

        int celebrity = findCelebrity(party);
        if(celebrity == -1){
            System.out.println("No Celebrity Found.");
        }else{
            System.out.println("Celebrity : " + (celebrity + 1));
        }
    }

    private static int findCelebrity(int[][] party) {
        int[] maximumVotes = new int[party.length];
        for(int i = 0 ; i < party.length; i++){
            for(int j = 0 ; j < party.length; j++){
                if(party[i][j] == 1){
                    maximumVotes[j] += 1;
                }
            }
        }

        //now we should go over the vote store
        for(int i = 0; i < maximumVotes.length ; i++){
            if(maximumVotes[i] > 0){
                //i could be a celebrity
                boolean popularity = doesEveryBodyKnowsThisGuy(i, party);
                boolean selfAwareness = doesThisGuyKnowAboutAnybody(i, party);
                if(popularity && !selfAwareness){
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean doesThisGuyKnowAboutAnybody(int possibleCelebrity, int[][] party) {
        for(int people = 0; people < party.length; people++){
            if(party[possibleCelebrity][people] == 1){
                return true;
            }
        }
        return false;
    }

    private static boolean doesEveryBodyKnowsThisGuy(int possibleCelebrity, int[][] party) {
        for(int row = 0 ; row < party.length && row != possibleCelebrity; row++ ){
            if(party[row][possibleCelebrity] != 1){
                return false;
            }
        }
        return true;
    }
}
