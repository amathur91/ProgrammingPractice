package com.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class SameBST {
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        boolean result = false;
        if (arrayOne.size() != arrayTwo.size()) {
            return false;
        }
        result = checkSameBSTTree(arrayOne, arrayTwo);
        return result;
    }

    private static boolean checkSameBSTTree(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() > 0 && arrayTwo.size() > 0) {
            int rootOfFirstTree = arrayOne.get(0);
            int rootOfSecondTree = arrayTwo.get(0);
            if (rootOfFirstTree != rootOfSecondTree) {
                return false;
            }

            ArrayList<Integer> arrayOneLHS = new ArrayList<>();
            ArrayList<Integer> arrayTwoLHS = new ArrayList<>();

            ArrayList<Integer> arrayOneRHS = new ArrayList<>();
            ArrayList<Integer> arrayTwoRHS = new ArrayList<>();

            //fill the LHS and RHS
            for (int index = 1; index < arrayOne.size(); index++) {
                if (arrayOne.get(index) < rootOfFirstTree) {
                    arrayOneLHS.add(arrayOne.get(index));
                } else {
                    arrayOneRHS.add(arrayOne.get(index));
                }
            }

            for (int index = 1; index < arrayTwo.size(); index++) {
                if (arrayTwo.get(index) < rootOfSecondTree) {
                    arrayTwoLHS.add(arrayTwo.get(index));
                } else {
                    arrayTwoRHS.add(arrayTwo.get(index));
                }
            }

            return checkSameBSTTree(arrayOneLHS, arrayTwoLHS) && checkSameBSTTree(arrayOneRHS, arrayTwoRHS);
        }
        return true;
    }
}