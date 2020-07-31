package com.general.problems;

import java.util.*;

public class TallestBillboard {
    public int tallestBillboard(int[] rods) {
        Number[] numInput = new Number[rods.length];
        for(int index =0; index < rods.length; index++){
            Number number = new Number(rods[index], index);
            numInput[index] = number;
        }
        int totalSum = findTotalSum(rods);
        int targetSum = totalSum / 2;
        if(targetSum % 2 != 0){
            targetSum++;
        }
        for(int target = targetSum; target > 0;  target--){
            SortedMap<Integer, List<List<Number>>> sumMap = buildSumSets(numInput, target);
            if(sumMap.containsKey(target)){
                if(checkIfTheListHasTwoDisjointSets(sumMap.get(target))){
                    return target;
                }
            }
        }
        return 0;
    }

    private boolean checkIfTheListHasTwoDisjointSets(List<List<Number>> lists) {
        for(int i = 0; i < lists.size() - 1; i++){
            for(int j = i + 1; j < lists.size(); j++){
                List<Number> list1 = lists.get(i);
                List<Number> list2 = lists.get(j);
                if(isDisjoint(list1, list2)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDisjoint(List<Number> list1, List<Number> list2) {
        for(int index = 0; index < list1.size(); index++){
            if(list2.contains(list1.get(index))){
                return false;
            }
        }
        return true;
    }

    private SortedMap<Integer, List<List<Number>>> buildSumSets(Number[] numInput, int target) {
        SortedMap<Integer, List<List<Number>>> sumMap= new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ArrayList<Number> numList = new ArrayList<>();
        targetSumPossible(numInput, 0, 0, sumMap, numList, target);
        return sumMap;
    }

    private void targetSumPossible(Number[] numInput, int currentIndex, int currentSum, SortedMap<Integer, List<List<Number>>> sumMap,
                                   ArrayList<Number> numList, int target) {
        if(currentIndex < numInput.length && currentSum < target){
            numList.add(numInput[currentIndex]);
            targetSumPossible(numInput, currentIndex + 1, currentSum + numInput[currentIndex].getValue(), sumMap, numList, target);
            numList.remove(numList.indexOf(numInput[currentIndex]));
            targetSumPossible(numInput, currentIndex + 1, currentSum, sumMap, numList, target);
        }else if(currentSum == target){
            if (sumMap.containsKey(currentSum)) {
                ArrayList<Number> sumList = new ArrayList<>();
                sumList.addAll(numList);
                sumMap.get(currentSum).add(sumList);
            } else {
                ArrayList<Number> sumList = new ArrayList<>();
                sumList.addAll(numList);
                sumMap.put(currentSum, new ArrayList<>());
                sumMap.get(currentSum).add(sumList);
            }
        }
    }

    private int findTotalSum(int[] rods) {
        int totalSum = 0;
        for(int index = 0; index < rods.length; index++){
            totalSum += rods[index];
        }
        return totalSum;
    }
}

class Number{
    private int value;
    private int index;

    public Number(int value, int index) {
        this.value = value;
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
