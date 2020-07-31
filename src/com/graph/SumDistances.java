package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/
 * This is not the most efficient Solution.
 * TBD
 */
public class SumDistances {
    public int[] sumDistancesInTree(int N, int[][] edges){
        HashMap<Integer, List<Integer>> nodeEdgeMapping = new HashMap<Integer, List<Integer>>();
        buildHashMap(edges, nodeEdgeMapping);
        ArrayList<Integer> integers = doDFSAndBuildResult(nodeEdgeMapping, N);
        int[] finalResult = new int[N];
        for(int index = 0; index < N; index++){
            finalResult[index] = integers.get(index);
        }
        return finalResult;
    }

    private ArrayList<Integer> doDFSAndBuildResult(HashMap<Integer, List<Integer>> nodeEdgeMapping, int n) {
        ArrayList<Integer> finalResult = new ArrayList<>();
        for(int vertex = 0; vertex < n; vertex++){
            ArrayList<Integer> distanceFound = new ArrayList<>();
            boolean[] visited = new boolean[n];
            depthTraversal(vertex, nodeEdgeMapping, visited, distanceFound, 0);
            finalResult.add(distanceFound.stream().reduce(0,(a,b)-> a+b));
        }
        return finalResult;
    }

    private void depthTraversal(int vertex, HashMap<Integer, List<Integer>> nodeEdgeMapping, boolean[] visited, ArrayList<Integer> totalDistance, int distanceFromStart) {
        if(!visited[vertex]){
            visited[vertex] = true;
            List<Integer> neighbours = nodeEdgeMapping.getOrDefault(vertex, new ArrayList<>());
            for(Integer neighbour : neighbours){
                if(!visited[neighbour]) {
                    totalDistance.add(distanceFromStart + 1);
                    depthTraversal(neighbour, nodeEdgeMapping, visited, totalDistance, distanceFromStart + 1);
                }
            }
        }
    }

    private void buildHashMap(int[][] edges, HashMap<Integer, List<Integer>> nodeEdgeMapping) {
        for(int[] edge : edges){
            int source = edge[0];
            int destination = edge[1];
            addMapping(nodeEdgeMapping, source, destination);
            addMapping(nodeEdgeMapping, destination, source);
        }
    }

    private void addMapping(HashMap<Integer, List<Integer>> nodeEdgeMapping, int source, int destination) {
        if(source != destination) {
            if (nodeEdgeMapping.containsKey(source)) {
                nodeEdgeMapping.get(source).add(destination);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(destination);
                nodeEdgeMapping.put(source, list);
            }
        }
    }
}
