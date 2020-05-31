package com.general.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/
 */
class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<CourseNode> courseNodes = new ArrayList<>();
        HashMap<Integer, CourseNode> courseMap = new HashMap<>();
        for(int courseIndex = 0 ; courseIndex < numCourses; courseIndex++){
            CourseNode courseNode = new CourseNode(courseIndex);
            courseNodes.add(courseNode);
            courseMap.put(courseIndex, courseNode);
        }
        for(int courseIndex = 0 ; courseIndex < prerequisites.length; courseIndex++){
            int courseIdentity = prerequisites[courseIndex][0];
            int dependentCourse = prerequisites[courseIndex][1];
            CourseNode dependentCourseNode = courseMap.get(dependentCourse);
            courseMap.get(courseIdentity).getDependentCourses().add(dependentCourseNode);
        }

        boolean result = true;
        for(CourseNode courseNode : courseNodes){
            //do DFS
            boolean[] visited = new boolean[numCourses];
            if(!doDFS(courseNode, courseMap, visited)){
                return false;
            }
        }
        return result;
    }

    private boolean doDFS(CourseNode courseNode, HashMap<Integer, CourseNode> courseMap, boolean[] visited) {
        if(!visited[courseNode.getCourseIndentity()]){
            visited[courseNode.getCourseIndentity()] = true;
            for(CourseNode dependentCourse : courseNode.getDependentCourses()){
                if(visited[dependentCourse.getCourseIndentity()]){
                    return false;
                }
                boolean result = doDFS(dependentCourse, courseMap, visited);
                if(!result){
                    return false;
                }
            }
            visited[courseNode.getCourseIndentity()] = false;
            return true;
        }
        return true;
    }
}

class CourseNode{
    private int courseIndentity;
    private List<CourseNode> dependentCourses;

    public CourseNode(int courseIndentity){
        this.courseIndentity = courseIndentity;
        this.dependentCourses = new ArrayList<>();
    }

    public int getCourseIndentity() {
        return courseIndentity;
    }

    public void setCourseIndentity(int courseIndentity) {
        this.courseIndentity = courseIndentity;
    }

    public List<CourseNode> getDependentCourses() {
        return dependentCourses;
    }

    public void setDependentCourses(List<CourseNode> dependentCourses) {
        this.dependentCourses = dependentCourses;
    }
}