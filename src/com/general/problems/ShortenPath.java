package com.general.problems;

import java.util.Stack;

/**
 * Solution for Algoexpert Shorten Path
 */
public class ShortenPath {
    public static void main(String args[]){
        String input = "/../../foo/bar/baz";
        System.out.println(shortenPath(input));
    }
    public static String shortenPath(String path) {
        String finalOutput = "";
        StringBuffer sb = new StringBuffer();
        Stack<String> pathStack = new Stack<String>();
        PATHTYPE pathtype = PATHTYPE.RELATIVE;
        if(String.valueOf(path.charAt(0)).equalsIgnoreCase("/")){
            pathtype = PATHTYPE.ABSOLUTE;
        }
        String[] pathDelimited = path.split("/");
        for(int index = 0; index < pathDelimited.length; index++){
            if(pathDelimited[index].equalsIgnoreCase("..")){
                if(!pathStack.isEmpty() && !pathStack.peek().equalsIgnoreCase("..")){
                    pathStack.pop();
                }else if(pathtype == PATHTYPE.RELATIVE){
                    pathStack.add(pathDelimited[index]);
                }
            }else if(pathDelimited[index].equalsIgnoreCase(".") ||
            pathDelimited[index].equalsIgnoreCase("")){
                //ignore
            }else{
                pathStack.add(pathDelimited[index]);
            }
        }

        while(!pathStack.isEmpty()){
            String value = pathStack.pop();
            sb.insert(0, value);
            if(!pathStack.isEmpty()) {
                sb.insert(0, "/");
            }
        }
        if(pathtype == PATHTYPE.ABSOLUTE){
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}

enum PATHTYPE{
    RELATIVE, ABSOLUTE
}