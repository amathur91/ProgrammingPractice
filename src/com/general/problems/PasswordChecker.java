package com.general.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PasswordChecker {
    public int strongPasswordChecker(String password) {
        boolean isPasswordStrong = checkPassword(password);
        if(!isPasswordStrong){
            return findMinimumChange(password);
        }
        return 0;
    }

    private int findMinimumChange(String password) {
        int totalChangeCount = 0;
        int totalNewAddition = 0;
        int totalDropCount = 0;
        int result = 0;
        if(password.length() == 0){
            return 6;
        }
        if(password.length() > 20){
            totalDropCount = password.length() - 20;
        }

        int repeatCount = countOfRepeatingCharacters(password);
        if(repeatCount > 0){
            totalChangeCount += repeatCount;
        }
        if(countOfCapitalCharacters(password) == 0){
            if(totalChangeCount > 0){
                //it is adjusted
                result++;
                totalChangeCount--;
            }else{
                totalNewAddition++;
            }
        }
        int countOfDigits = countOfDigits(password);
        if(countOfDigits == 0){
            if(totalChangeCount > 0){
                //it is adjusted
                result++;
                totalChangeCount--;
            }else{
                totalNewAddition++;
            }
        }
        if(countOfSmallCharacters(password) == 0){
            if(totalChangeCount > 0){
                //it is adjusted
                result++;
                totalChangeCount--;
            }else{
                totalNewAddition++;
            }
        }
        //finally there could be three possiblities
        /**
         * 1. Input exceeds the length
         * 2. Input is less than minimal
         * 3. Input fits the range but needs some optimization
         */
        if(password.length() > 20) {
            if(totalNewAddition == 0) {
                return result +  totalChangeCount;
            }else{
                return totalDropCount + totalChangeCount + totalNewAddition;
            }
        }else if(password.length() < 6){
            totalNewAddition += 6 - (totalNewAddition + password.length());
            return totalNewAddition + totalChangeCount;
        }else {
            result += Math.abs(totalDropCount - totalNewAddition) + totalChangeCount;
            return result;
        }
    }

    private int countOfSmallCharacters(String password){
        int totalCount = 0;
        for(int index = 0; index < password.length(); index++){
            int character = password.charAt(index);
            if(character >=97 && character <= 123){
                totalCount++;
            }
        }
        return totalCount;
    }

    private int countOfRepeatingCharacters(String password){
        int count = 0;
        if(password.length() < 3){
            return 0;
        }else{
            int start = 0;
            while(start + 3 <= password.length()) {
                int firstCharacterIndex = start;
                int secondCharacterIndex = firstCharacterIndex + 1;
                int thirdCharacterIndex = secondCharacterIndex + 1;
                String firstCharacter = String.valueOf(password.charAt(firstCharacterIndex));
                String secondCharacter = String.valueOf(password.charAt(secondCharacterIndex));
                String thirdCharacter = String.valueOf(password.charAt(thirdCharacterIndex));
                if(firstCharacter.equalsIgnoreCase(secondCharacter) && secondCharacter.equalsIgnoreCase(thirdCharacter)){
                    count++;
                    start += 3;
                    continue;
                }
                start++;
            }
        }
        return count;
    }

    private int countOfDigits(String password){
        int totalCount  = 0;
        for(int index = 0; index < password.length(); index++){
            try{
                Integer.parseInt(String.valueOf(password.charAt(index)));
                totalCount++;
            }catch (Exception ex){
            }
        }
        return totalCount;
    }

    private int countOfCapitalCharacters(String password){
        int totalCount = 0;
        for(int index = 0; index < password.length(); index++){
            int character = password.charAt(index);
            if(character >=65 && character < 97){
                totalCount++;
            }
        }
        return totalCount;
    }

    private boolean checkPassword(String password) {
        if(password.length() == 0){
            return false;
        }
        boolean lengthCheck = password.length() >=6 && password.length() <=20;
        boolean upperLowerAndDigitCheck = checkUpperLowerAndDigit(password);
        boolean repeatedCharacterCheck = checkForRepeatedCharacters(password);
        return lengthCheck && upperLowerAndDigitCheck && repeatedCharacterCheck;
    }

    private boolean checkForRepeatedCharacters(String password) {
        String previousCharacter = String.valueOf(password.charAt(0));
        int count = 0;
        for(int index = 1; index < password.length(); index++){
            String currentCharacter = String.valueOf(password.charAt(index));
            if(currentCharacter.equalsIgnoreCase(previousCharacter)){
                count++;
                if(count == 3){
                    return true;
                }
            }else{
                count = 0;
            }
        }
        if(count == 3){
            return true;
        }
        return false;
    }

    private boolean checkUpperLowerAndDigit(String password) {
        boolean upperCharacter = false;
        boolean lowerCharacter = false;
        boolean isDigit = false;
        for(int index = 0; index < password.length(); index++){
            int character = password.charAt(index);
            if(character >= 97 && character <= 123){
                lowerCharacter = true;
            }
            if(character >= 65 && character <=96){
                upperCharacter = true;
            }
            try{
                Integer.parseInt(String.valueOf(password.charAt(index)));
                isDigit = true;
            }catch (Exception ex){
            }
        }
        return upperCharacter && lowerCharacter && isDigit;
    }
}
