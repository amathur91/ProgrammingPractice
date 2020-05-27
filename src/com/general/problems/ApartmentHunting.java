package com.general.problems;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/Apartment%20Hunting
 */
public class ApartmentHunting {
    public static void main(String args[]){
        List<Map<String, Boolean>> blocks = new ArrayList<>();
        HashMap<String,Boolean> firstBlock = new HashMap<>();
        firstBlock.put("gym", false);
        firstBlock.put("school", true);
        firstBlock.put("store", false);
        blocks.add(firstBlock);

        HashMap<String,Boolean> secondBlock = new HashMap<>();
        secondBlock.put("gym", true);
        secondBlock.put("school", false);
        secondBlock.put("store", false);
        blocks.add(secondBlock);

        HashMap<String,Boolean> thirdBlock = new HashMap<>();
        thirdBlock.put("gym", true);
        thirdBlock.put("school", true);
        thirdBlock.put("store", false);
        blocks.add(thirdBlock);

        HashMap<String,Boolean> fourthBlock = new HashMap<>();
        fourthBlock.put("gym", false);
        fourthBlock.put("school", true);
        fourthBlock.put("store", false);
        blocks.add(fourthBlock);

        HashMap<String,Boolean> fifthBlock = new HashMap<>();
        fifthBlock.put("gym", false);
        fifthBlock.put("school", true);
        fifthBlock.put("store", true);
        blocks.add(fifthBlock);
        String[] reqs = {"gym", "school", "store"};
        int result = Program.apartmentHunting(blocks,reqs);
        System.out.println(result);
    }
}
class Program {
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] propertyComputeMap = new int[reqs.length][blocks.size()];
        for(int blockIndex = 0 ; blockIndex < blocks.size(); blockIndex++){
            for(int requirementIndex = 0; requirementIndex < reqs.length; requirementIndex++){
                if(blocks.get(blockIndex).get(reqs[requirementIndex])){
                    propertyComputeMap[requirementIndex][blockIndex] = 0;
                }else{
                    propertyComputeMap[requirementIndex][blockIndex] = -1; //Indicates that not available;
                }
            }
        }

        Stack<Integer>[] listArray = new Stack[reqs.length];
        for(int i = 0 ; i < reqs.length; i++){
            listArray[i] = new Stack<Integer>();
        }
        for(int requirementIndex = 0; requirementIndex < reqs.length; requirementIndex++){
            int lastBlockKnown = 0;
            for(int blockIndex = 0 ; blockIndex < blocks.size(); blockIndex++){
                if(propertyComputeMap[requirementIndex][blockIndex] == 0){
                    lastBlockKnown = blockIndex;
                    Stack<Integer> colList = listArray[requirementIndex];
                    while(!colList.isEmpty()){
                        int location = colList.pop();
                        propertyComputeMap[requirementIndex][location] = Math.abs(blockIndex - location);
                    }
                }else{
                    listArray[requirementIndex].add(blockIndex);
                }
            }
            Stack<Integer> colList = listArray[requirementIndex];
            while(!colList.isEmpty()){
                int location = colList.pop();
                propertyComputeMap[requirementIndex][location] = Math.abs(lastBlockKnown - location);
            }
        }

        int[] maxDistanceForEachBlock = new int[blocks.size()];
       for(int index = 0 ; index < blocks.size(); index++){
           maxDistanceForEachBlock[index] = Integer.MIN_VALUE;
       }

        for(int requirementIndex = 0; requirementIndex < reqs.length; requirementIndex++) {
            for (int blockIndex = 0; blockIndex < blocks.size(); blockIndex++) {
                if(propertyComputeMap[requirementIndex][blockIndex] > maxDistanceForEachBlock[blockIndex]){
                    maxDistanceForEachBlock[blockIndex] = propertyComputeMap[requirementIndex][blockIndex];
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 0 ; i < maxDistanceForEachBlock.length; i++){
            if(maxDistanceForEachBlock[i] < result){
                result = maxDistanceForEachBlock[i];
                index = i;
            }
        }
        return index;
    }
}


