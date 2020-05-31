package com.general.problems;

import org.junit.Test;

public class CourseScheduleTest {
    @Test
    public void test1(){
        int numCourses = 3;
        int[][] prerequisites = {{0,1},{0,2},{1,2}};
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }

    @Test
    public void test2(){
        int numCourses = 4;
        int[][] prerequisites = {{2,0},{1,0},{3,1},{3,2},{1,3}};
        CourseSchedule courseSchedule = new CourseSchedule();
        boolean result = courseSchedule.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }
}
