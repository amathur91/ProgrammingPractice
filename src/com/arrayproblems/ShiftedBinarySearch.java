package com.arrayproblems;

/**
 * Solution for Shifted Binary Search
 */
public class ShiftedBinarySearch {
    public static void main(String args[]){
        int[] input = {71, 72, 73, 0, 1, 21, 33, 45, 45, 61};
        int target = 73;
        int result = shiftedBinarySearch(input, target);
        System.out.println(result);
    }
    public static int shiftedBinarySearch(int[] array, int target) {
        return  binarySearchUtil(array, 0, array.length - 1, target);
    }

    private static int binarySearchUtil(int[] array, int startIndex, int endIndex, int target) {
        if(startIndex >= 0 && endIndex < array.length && startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;

            if(array[mid] == target){
                return mid;
            }
            if(array[startIndex] == target){
                return startIndex;
            }
            if(array[endIndex] == target){
                return endIndex;
            }

            //if left portion is sorted.
            if(array[startIndex] < array[mid]) {
                if (target >= array[startIndex] && target <= array[mid]) {
                    return binarySearchUtil(array, startIndex, mid - 1, target);
                } else {
                    return binarySearchUtil(array, mid + 1, endIndex, target);
                }
            }else{
                if(target > array[mid] &&  target <= array[endIndex]){
                    return binarySearchUtil(array, mid + 1, endIndex, target);
                }else{
                    return binarySearchUtil(array, startIndex, mid - 1, target);
                }
            }
            //if right portion is sorted.
        }
        return -1;
    }
}
