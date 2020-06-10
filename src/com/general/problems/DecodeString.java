package com.general.problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
    public String decode(String input){
        StringBuffer output = new StringBuffer();
        Stack<String> stack = new Stack<>();
        for(int index = 0; index < input.length(); index++){
            String character = String.valueOf(input.charAt(index));
            if(character.equalsIgnoreCase("]")){
                //now we unpack the stack till the last [ character and build the string.
                StringBuffer tempString = new StringBuffer();
                while(!stack.peek().equalsIgnoreCase("[")){
                    tempString.insert(0, stack.pop());
                }
                stack.pop();
                Integer count = 0;
                int multiplier = 1;
                while(true){
                    if(!stack.isEmpty() && checkIfNumber(stack.peek())) {
                         int num  = Integer.parseInt(stack.pop());
                         count = count +  num * multiplier;
                         multiplier *= 10;
                    }else{
                        break;
                    }
                }

                String currentOutput = tempString.toString();
                for(int counter = 0; counter <= count - 1; counter++){
                    output.append(currentOutput);
                }
                stack.push(output.toString());
                output.delete(0, output.length());
            }else{
                //push to the stack.
                stack.push(character);
            }
        }
        StringBuffer finalString = new StringBuffer();
        while(!stack.isEmpty()){
            finalString.insert(0,stack.pop());
        }
        return finalString.toString();
    }

    private boolean checkIfNumber(String peek) {
        boolean result = false;
        try{
            Integer.parseInt(peek);
            return true;
        }catch(Exception exception){

        }
        return result;
    }
}
