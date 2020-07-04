package com.string.problems;

import java.util.*;

public class LongestStringChain {
    public static List<String> longestStringChain(List<String> strings){
        //first we need to sort the string based on the length
        //then build a hashmap where we can lookup for strings
        //then we need a count store where we can keep the count of the chain
        Collections.sort(strings, (o1, o2) -> {
            return o1.length() - o2.length();
        });
        HashMap<String, Boolean> stringPresenceMap = new HashMap<>();
        for(String string: strings){
            stringPresenceMap.put(string, Boolean.TRUE);
        }
        HashMap<String, List<String>> chainMap = new HashMap<>();
        for(String string : strings){
            chainMap.put(string, new ArrayList<>(Arrays.asList(string)));
        }
        int[] stringCount = new int[strings.size()];
        for(String string : strings){
            checkAndPopulateChainMap(string, stringPresenceMap,chainMap);
        }
        String maxChainString = null;
        int maxSize = 0;
        for(String string : strings){
            if(chainMap.get(string).size() > maxSize){
                maxSize = chainMap.get(string).size();
                maxChainString = string;
            }
        }
        if(maxSize == 1){
            return new ArrayList<>();
        }
        List<String> result = chainMap.get(maxChainString);
        Collections.sort(result, (o1, o2) -> {
            return o2.length() - o1.length();
        });
        return result;
    }

    private static void checkAndPopulateChainMap(String string, HashMap<String, Boolean> stringPresenceMap, HashMap<String, List<String>> chainMap) {
        for(int index = 0; index < string.length(); index++){
            String newString = null;
            if(index == 0){
                newString = string.substring(1, string.length());
            }else if(index == string.length() - 1){
                newString = string.substring(0, string.length() - 1);
            }else{
                newString = string.substring(0,index) + string.substring(index + 1, string.length());
            }
            if(stringPresenceMap.containsKey(newString)){
                if(chainMap.containsKey(newString)){
                    int possibleChainLength = chainMap.get(newString).size();
                    if(chainMap.get(string).size() < 1 + possibleChainLength){
                        ArrayList<String> list = (ArrayList<String>) chainMap.get(newString);
                        chainMap.get(string).addAll(list);
                    }
                }
            }

        }
    }

}
