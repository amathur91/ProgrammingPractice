package com.general.problems;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/submissions/
 * Runtime: 1 ms, faster than 38.08% of Java online submissions for Valid Parenthesis String.
 * Memory Usage: 37.4 MB, less than 62.22% of Java online submissions for Valid Parenthesis String.
 */
public class ValidParenthesis {
    public boolean checkValidString(String input) {
        Stack<String> stack = new Stack<>();
        int index = 0;
        while(index < input.length()){
            String character = String.valueOf(input.charAt(index));
           if(character.equalsIgnoreCase(")")){
               //we need to find its pair or adjust it with the *
               if(!isMachingPairPresent(stack, index)){
                   return false;
               }
           }else{
               stack.push(character);
           }
            index++;
        }
        int asteriskCount = 0;

        while(!stack.isEmpty()){
            if(stack.pop().equalsIgnoreCase("*")){
               asteriskCount++;
            }else{
               if(asteriskCount > 0){
                   asteriskCount--;
               }else{
                   return false;
               }
            }
        }
        return true;
    }

    private boolean isMachingPairPresent(Stack<String> stack, int index) {
        int countOfAsterisk = 0;
        while(!stack.isEmpty()){
            String topCharacter = stack.pop();
            if(topCharacter.equalsIgnoreCase("*")){
                countOfAsterisk++;
            }else if(topCharacter.equalsIgnoreCase("(")){
                //we found the pair
                //insert back the asterisk characters if we found any.
                for(int counter = 0; counter < countOfAsterisk; counter++){
                    stack.push("*");
                }
                return true;
            }else if(topCharacter.equalsIgnoreCase(")")){
                //this is not expected..return false;
                return false;
            }
        }
        //if stack gets empty and we are not able to find the matching pair for it then
        //check if we have atleast 1 asterisk..and push the remaining and return true
        if(countOfAsterisk > 0){
            for(int counter = 0; counter < countOfAsterisk - 1; counter++){
                stack.push("*");
            }
            return true;
        }
        return false;
    }
}
