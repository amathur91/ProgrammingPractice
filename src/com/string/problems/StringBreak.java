package com.string.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Problem : https://leetcode.com/problems/check-if-a-string-can-break-another-string/
 *
 103 / 103 test cases passed.
 Status: Accepted
 Runtime: 8 ms
 Memory Usage: 40 MB
 * Runtime: 8 ms, faster than 83.15% of Java online submissions for Check If a String Can Break Another String.
 * Memory Usage: 40 MB, less than 92.36% of Java online submissions for Check If a String Can Break Another String.
 */
public class StringBreak {
    public static void main(String args[]){
        String s1 = "leetcodee";
        String s2 = "interview";
        StringBreak sb = new StringBreak();
        System.out.println(sb.checkIfCanBreak(s1, s2));
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        if(s1.length() != s2.length()){
            return  false;
        }
        String filterString1 = getSortedString(s1);
        String filterString2 = getSortedString(s2);
        boolean result2 = true;
        boolean result1 = checkIfStringCanBreak(filterString1, filterString2);
        if (!result1) {
            result2 = checkIfStringCanBreak(filterString2, filterString1);
        }
        return result1 || result2;
    }

    private String getSortedString(String filterString1) {
        char[] string1 = filterString1.toCharArray();
        Arrays.sort(string1);
        filterString1 = new String(string1);
        return filterString1;
    }

    private boolean checkIfStringCanBreak(String filterString1, String filterString2) {
        for (int index = 0; index < filterString1.length(); index++){
            int letter1 = filterString1.charAt(index);
            int letter2 = filterString2.charAt(index);
            if(letter1 < letter2){
                return false;
            }
        }
        return true;
    }
}