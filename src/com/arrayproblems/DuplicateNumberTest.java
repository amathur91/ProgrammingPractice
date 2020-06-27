package com.arrayproblems;

import org.junit.Test;

public class DuplicateNumberTest {
    private DuplicateNumber duplicateNumber = new DuplicateNumber();

    @Test
    public void test1(){
        int nums[] = {1,3,4,2,2};
        int duplicate = duplicateNumber.findDuplicate(nums);
        System.out.println(duplicate);
    }

    @Test
    public void test2(){
        int nums[] = {3,1,3,4,2};
        int duplicate = duplicateNumber.findDuplicate(nums);
        System.out.println(duplicate);
    }
}
