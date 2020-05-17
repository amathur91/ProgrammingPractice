package com.string.problems;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomStringGeneration {
    private static final int NOLIMIT = 0;
    private static final int B_LIMIT = 1;
    private static final int C_LIMIT = 2;
    
    public static void main(String args[]){
        int lengthOfString = 4;
        HashMap<String, Integer> constraintMap = new HashMap<>();
        constraintMap.put("a", NOLIMIT);
        constraintMap.put("b", 0);
        constraintMap.put("c", 0);
        ArrayList<String> permutationList = new ArrayList<>();
        buildPermutationList(lengthOfString, constraintMap, permutationList);
        permutationList.stream().forEach((permutation) -> {
            System.out.println(permutation);
        });
    }

    private static void buildPermutationList(int lengthOfString, HashMap<String, Integer> constraintMap, ArrayList<String> permutationList) {
        String permutation = "";
        int currentSize = 0;
        buildPermutationUtil(permutation, currentSize, lengthOfString, constraintMap,permutationList);
    }

    private static void buildPermutationUtil(String permutation, int currentSize, int lengthOfString, HashMap<String, Integer> constraintMap, ArrayList<String> permutationList) {
        if(currentSize >= lengthOfString){
            permutationList.add(permutation);
        }else{
            buildPermutationUtil(permutation + "a", currentSize + 1, lengthOfString, constraintMap, permutationList);
            if(constraintMap.get("b") < B_LIMIT){
                constraintMap.put("b", constraintMap.get("b") + 1);
                buildPermutationUtil(permutation + "b", currentSize + 1, lengthOfString, constraintMap, permutationList);
                constraintMap.put("b", constraintMap.get("b") - 1);
            }

            if(constraintMap.get("c") < C_LIMIT){
                constraintMap.put("c", constraintMap.get("c") + 1);
                buildPermutationUtil(permutation + "c", currentSize + 1, lengthOfString, constraintMap, permutationList);
                constraintMap.put("c", constraintMap.get("c") - 1);
            }
        }
    }
}
