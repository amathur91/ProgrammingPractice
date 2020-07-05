package com.general.problems;

import java.util.*;

/**
 * Solution for Prison Cell Problem Leetcode
 * https://leetcode.com/problems/prison-cells-after-n-days/submissions/
 * Solution is that there will be a cycle as the digits are fixed.
 *
 */
public class PrisonAfterDays {
    public int[] prisonAfterNDays(int[] currentDay, int N) {
        if(currentDay.length == 0){
            return new int[0];
        }
        Set<String> stringSet = new LinkedHashSet<>();
        ArrayList<String> list = new ArrayList<>();
        String cycleBegining = null;
        int counter = 0;
        int[] nextDay = new int[currentDay.length];
        int dayCounter = 0;
        boolean cycleFound = false;
        while(dayCounter < N && !cycleFound){
            for(int index = 0; index < currentDay.length; index++){
                if(index == 0 || index == currentDay.length - 1){
                    nextDay[index] = 0;
                }else{
                    if(currentDay[index - 1] == currentDay[index + 1]){
                        nextDay[index] = 1;
                    }else{
                        nextDay[index] = 0;
                    }
                }
            }
            String dayString = Arrays.toString(nextDay);
            if(!stringSet.contains(dayString)){
                stringSet.add(dayString);
                list.add(dayString);
                counter++;
            }else{
                cycleBegining = dayString;
                cycleFound = true;
                break;
            }
            int[] olderDay = currentDay;
            currentDay = nextDay;
            nextDay = olderDay;
            dayCounter++;
        }
        int result = N % counter;
        int cycleStartIndex = 0;
        /**
         * We want to find out if we hit the cycle or not
         */
        if(list.contains(cycleBegining)){
            cycleStartIndex = list.indexOf(cycleBegining);
        }
        /**
         * final index is the index found after mod with the iteration
         * and then shift the index by cycle start index
         */
        int finalIndex = result - cycleStartIndex  - 1;

        /**
         * As its a cycle we might hit negative index which
         * baseically means that we need to shift from the right end.
         */
        if(finalIndex < 0){
            finalIndex = list.size() + finalIndex;
        }
        String output = list.get(finalIndex);
        String array = output.substring(1, output.length() -1);
        String arr[] = array.split(", ");
        int[] finalResult = new int[currentDay.length];
        for(int index = 0; index < finalResult.length; index++){
            finalResult[index] = Integer.parseInt(arr[index]);
        }
        return finalResult;
    }
}
