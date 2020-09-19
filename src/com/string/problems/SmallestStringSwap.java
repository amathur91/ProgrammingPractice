package com.string.problems;

import java.util.*;

public class SmallestStringSwap {

    public static void main(String args[]) {
//        String s = "dcab";
//        List<List<Integer>> pairs = new ArrayList<>();
//        pairs.add(Arrays.asList(0, 3));
//        pairs.add(Arrays.asList(1, 2));
//        pairs.add(Arrays.asList(0, 2));
//        String s = "dcab";
//        List<List<Integer>> pairs = new ArrayList<>();
//        pairs.add(Arrays.asList(0, 3));
//        pairs.add(Arrays.asList(1, 2));
        String s = "cba";
        List<List<Integer>> pairs = new ArrayList<>();
        pairs.add(Arrays.asList(0, 1));
        pairs.add(Arrays.asList(1, 2));
        SmallestStringSwap smallestStringSwap = new SmallestStringSwap();
        System.out.println(smallestStringSwap.smallestStringWithSwaps(s, pairs));
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        HashMap<Integer, HashSet<Integer>> adjacencyList = new HashMap<>();
        for(List<Integer> pair : pairs) {
            int source = pair.get(0);
            int destination = pair.get(1);
            setEdge(adjacencyList, source, destination);
            setEdge(adjacencyList, destination, source);
        }
        for(int sourceIndex = 0; sourceIndex < s.length(); sourceIndex++) {
            boolean[] visited = new boolean[s.length()];
            doDFS(sourceIndex, visited, adjacencyList);
            for(int index = 0; index < visited.length; index++){
                if(visited[index]){
                    if(adjacencyList.containsKey(sourceIndex)) {
                        HashSet<Integer> integers = adjacencyList.get(sourceIndex);
                        integers.add(index);
                    }else {
                        HashSet<Integer> integer = new HashSet<>();
                        integer.add(index);
                        adjacencyList.put(sourceIndex, integer);
                    }
                }
            }

            //add all visited to the adjacency list of the sourceIndex
        }

        char[] finalString = new char[s.length()];
        for(int index = 0; index < s.length(); index++){
            HashSet<Integer> neighbours = adjacencyList.get(index);
            StringBuffer sb = new StringBuffer();
            for (Integer neighbour : neighbours){
                sb.append(s.charAt(neighbour));
            }
            String sortedString = getSortedString(sb.toString());
            int position = 0;
            for(Integer neighbour : neighbours){
                finalString[neighbour] = sortedString.charAt(position);
                position++;
            }
        }
        return new String(finalString);
        // Create a Adjacency List by doing DFS on the pairs
        // Once we have this adjacency list
        /**
         *  Then for each of the index, we create a string -> sort this temporary string -> fit it in the character array
         *  also place a check that if 0th character is connected to all the remaining ones, then we can simply sort the
         *  complete string and return it.
         */
    }

    private void setEdge(HashMap<Integer, HashSet<Integer>> adjacencyList, int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            adjacencyList.put(source, new HashSet<>(Arrays.asList(destination)));
        } else {
            adjacencyList.get(source).add(destination);
        }
    }

    private String getSortedString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private void doDFS(int sourceIndex, boolean[] visited, HashMap<Integer, HashSet<Integer>> adjacencyList) {
        if(!visited[sourceIndex]){
            visited[sourceIndex] = true;
            HashSet<Integer> neighbours = adjacencyList.get(sourceIndex);
            if(neighbours != null) {
                for (Integer neighbour : neighbours) {
                    doDFS(neighbour, visited, adjacencyList);
                }
            }
        }
    }
}