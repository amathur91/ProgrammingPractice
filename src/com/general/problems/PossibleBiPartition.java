package com.general.problems;

import java.util.*;

/**
 * Leetcode : https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBiPartition {
    private int[] colors = {1,2};
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<PeopleNode> peopleNodeList = new ArrayList<>();
        HashMap<Integer, PeopleNode> peopleNodeHashMap = new HashMap<>();
        for(int index = 0; index < N + 1; index++){
            PeopleNode peopleNode = new PeopleNode(index + 1);
            peopleNodeList.add(peopleNode);
            peopleNodeHashMap.put(index + 1, peopleNode);
        }

        for(int rows = 0; rows < dislikes.length; rows++){
            int person1 = dislikes[rows][0];
            int person2 = dislikes[rows][1];
            PeopleNode person1Node = peopleNodeHashMap.get(person1);
            PeopleNode person2Node = peopleNodeHashMap.get(person2);
            person1Node.getNeighbourList().add(person2Node);
            person2Node.getNeighbourList().add(person1Node);
        }

        boolean result = true;
        int[] colorMap = new int[N+2];
        for(PeopleNode peopleNode : peopleNodeList){
            boolean nodeResult = doBiPartite(peopleNode,colorMap);
            if(!nodeResult){
                return nodeResult;
            }
        }
        return result;
    }

    private boolean doBiPartite(PeopleNode peopleNode, int[] colorMap) {
        if(colorMap[peopleNode.getIdentity()] == PeopleNode.NOCOLOR){
            HashSet<Integer> neighbourColorSet = new HashSet<>();
            for(PeopleNode neighbourNode : peopleNode.getNeighbourList()){
                neighbourColorSet.add(colorMap[neighbourNode.getIdentity()]);
            }
            if(neighbourColorSet.contains(colors[0]) && neighbourColorSet.contains(colors[1])){
                return false;
            }
            for(Integer color : colors){
              if(canApplyColor(color, neighbourColorSet)){
                  int originalColor = colorMap[peopleNode.getIdentity()];
                  colorMap[peopleNode.getIdentity()] = color;
                  boolean result = true;
                  for(PeopleNode neighbourNode : peopleNode.getNeighbourList()) {
                      result =  doBiPartite(neighbourNode, colorMap);
                  }
                  if(!result) {
                      colorMap[peopleNode.getIdentity()] = originalColor;
                  }
                  return result;
              }
            }
        }
        return true;
    }

    private boolean canApplyColor(Integer color, HashSet<Integer> neighbourColorSet) {
        return !neighbourColorSet.contains(color);
    }

}

class PeopleNode{
    public static int NOCOLOR = 0;
    public static int BLACK = 1;
    public static int RED = 2;
    private int identity;
    private List<PeopleNode> neighbourList;
    private int color;
    public PeopleNode(int identity){
        this.identity = identity;
        this.neighbourList = new ArrayList<>();

    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public List<PeopleNode> getNeighbourList() {
        return neighbourList;
    }

    public void setNeighbourList(List<PeopleNode> neighbourList) {
        this.neighbourList = neighbourList;
    }
}
