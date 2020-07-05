package com.general.problems;

import org.junit.Test;

public class PrisonAfterDaysTest {
    PrisonAfterDays prisonAfterDays = new PrisonAfterDays();

    @Test
    public void test1(){
        int[] currentDay = {1,0,0,1,0,0,1,0};
        prisonAfterDays.prisonAfterNDays(currentDay, 1000000000);
        System.out.println("DEBUG");
    }

    @Test
    public void test2(){
        int[] currentDay = {0,1,0,1,1,0,0,1};
        prisonAfterDays.prisonAfterNDays(currentDay, 7);
        System.out.println("DEBUG");
    }
}
