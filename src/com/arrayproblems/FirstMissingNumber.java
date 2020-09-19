package com.arrayproblems;

public class FirstMissingNumber {
    public static void main(String args[]){
        int[] input = new int[]{1,1};
        FirstMissingNumber firstMissingNumber = new FirstMissingNumber();
        int result = firstMissingNumber.firstMissingPositive(input);
        System.out.println(result);
    }
    public int firstMissingPositive(int[] nums) {
        // place the numbers at the right position
        placeValuesAtTheirIndex(nums);
        for(int index =0; index < nums.length; index++){
            if(nums[index] != index+ 1){
                return index + 1;
            }
        }
        return nums.length + 1;
    }

    private void placeValuesAtTheirIndex(int[] nums) {
        int currentIndex = 0;
        while(currentIndex < nums.length){
            int value = nums[currentIndex];
            if(value > nums.length || value <= 0 | value == currentIndex + 1 || nums[value-1] == value){
                currentIndex++;
                continue;
            }else {
                //swap
                int temp = nums[currentIndex];
                nums[currentIndex]=nums[value - 1];
                nums[value - 1]= temp;
            }
        }
    }
}
