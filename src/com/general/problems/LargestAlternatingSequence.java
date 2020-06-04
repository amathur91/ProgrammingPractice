package com.general.problems;

public class LargestAlternatingSequence {
   private static int FLAG = 0;
   private static int INCREASING = 1;
   private static int DECREASING  = 2;
   private static int START = 0;

   public int findLargestAlternatingSequence(int[] input){
      int largestAlternatingSequence = Integer.MIN_VALUE;
      FLAG = START;
      for(int index = 0; index < input.length; index++){
         int result = lASUtil(index + 1, input[index], 1, input,FLAG);
         if(result > largestAlternatingSequence){
            largestAlternatingSequence = result;
         }
      }
      return largestAlternatingSequence;
   }

   private int lASUtil(int index, int currentValue, int count, int[] input, int FLAG) {
      if(index < input.length){
         int result = 0;
         if(input[index] > currentValue && (FLAG == INCREASING || FLAG == START)){
            //look for DECREASING
            FLAG = DECREASING;
            result =  lASUtil(index + 1, input[index], count + 1, input, FLAG);
         }else if(input[index] < currentValue && (FLAG == DECREASING || FLAG == START)){
            //look for increasing
            FLAG = INCREASING;
            result = lASUtil(index + 1, input[index], count + 1, input, FLAG);
         }
            //skip
         return Math.max(lASUtil(index + 1, currentValue, count,input, FLAG),result);

      }
      return count;
   }
}


