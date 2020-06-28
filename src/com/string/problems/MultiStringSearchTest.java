package com.string.problems;

import org.junit.Test;

import java.util.List;

public class MultiStringSearchTest {
    @Test
    public void test1(){
        String bigString = "Mary goes to the shopping center every week.";
        String[] smallStrings = {"to",
                "Mary",
                "centers",
                "shop",
                "shopping",
                "string",
                "kappa"};
        List<Boolean> booleanList = MultiStringSearch.multiStringSearch(bigString, smallStrings);
        for(Boolean value : booleanList){
            System.out.print(value + " ");
        }
    }
}
