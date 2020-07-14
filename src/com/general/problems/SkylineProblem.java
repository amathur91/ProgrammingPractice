package com.general.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 * General Solution.
 * Corner Cases are not handled.
 * 29/36 Test cases pass in leetcode.
 */
public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<BuildingPoint> buildingList = buildListOfBuildings(buildings);
        Collections.sort(buildingList, (o1, o2) -> {
            return o1.getXvalue() - o2.getXvalue();
        });
        Stack<Integer> buildingHeights = new Stack<>();
        buildingHeights.add(0);
        List<List<Integer>> finalResult = new ArrayList<>();

        for(BuildingPoint point : buildingList){
            if(point.isStart()){
                if(point.getHeight() > buildingHeights.peek()){
                    if( finalResult.size() > 0){
                        List<Integer> lastResult = finalResult.get(finalResult.size() - 1);
                        if(lastResult.get(0) == point.getXvalue() && lastResult.get(1) != point.getHeight()){
                            finalResult.remove(lastResult);
                            buildingHeights.push(point.getHeight());
                            continue;
                        }
                    }
                    buildingHeights.push(point.getHeight());
                    ArrayList skylinePoint = new ArrayList();
                    skylinePoint.add(point.getXvalue());
                    skylinePoint.add(buildingHeights.peek());
                    finalResult.add(skylinePoint);
                }else{
                    pushHeightToStack(buildingHeights, point.getHeight());
                }
            }else{
                if(point.getHeight() == buildingHeights.peek()){
                    if(buildingHeights.peek() != 0) {
                        buildingHeights.pop();
                    }
                    ArrayList skylinePoint = new ArrayList();
                    skylinePoint.add(point.getXvalue());
                    skylinePoint.add(buildingHeights.peek());
                    finalResult.add(skylinePoint);
                }else{
                    buildingHeights.remove(buildingHeights.indexOf(point.getHeight()));
                }
            }
        }
        return finalResult;
    }

    private void pushHeightToStack(Stack<Integer> buildingHeights, int height) {
        if(height != 0) {
            Stack<Integer> tempStack = new Stack<>();
            while (buildingHeights.peek() > height && !buildingHeights.isEmpty()) {
                tempStack.push(buildingHeights.pop());
            }
            buildingHeights.push(height);

            while(!tempStack.isEmpty()){
                buildingHeights.push(tempStack.pop());
            }
        }
    }

    private List<BuildingPoint> buildListOfBuildings(int[][] buildings) {
        ArrayList<BuildingPoint> buildingsArrayList = new ArrayList<>();
        for(int buildIndex = 0; buildIndex < buildings.length; buildIndex++){
            BuildingPoint buildingStartPoint = new BuildingPoint(buildings[buildIndex][0], true, buildings[buildIndex][2]);
            BuildingPoint buildingEndPoint = new BuildingPoint(buildings[buildIndex][1], false, buildings[buildIndex][2]);
            buildingsArrayList.add(buildingStartPoint);
            buildingsArrayList.add(buildingEndPoint);
        }
        return buildingsArrayList;
    }
}

class BuildingPoint {
    private int xvalue;
    private boolean start;
    private int height;

    public BuildingPoint(int xvalue, boolean start, int height) {
        this.xvalue = xvalue;
        this.start = start;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getXvalue() {
        return xvalue;
    }

    public void setXvalue(int xvalue) {
        this.xvalue = xvalue;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}

