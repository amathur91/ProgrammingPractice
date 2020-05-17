package com.graph;

import java.util.LinkedList;

public class BipartiteGraph {
    public static void main(String args[]){
        int graph[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        /**
         * As in the below code we are passing a starting index.
         * This will work just fine but for connected graphs.
         * If the input graph is not connected, it will fail.
         * So to fix this we can iterate over the vertex list to handle this
         * test case.
         */
      //  boolean result = isBiPartite(graph, 0);
        boolean finalResult  = true;
        for(int i = 0 ; i < graph.length; i++){
            boolean result = isBiPartite(graph, i);
            if(result == false){
                finalResult = false;
                break;
            }
        }
        System.out.println("Graph is BiPartite : " + finalResult);
    }

    /**
     * We take a graph in matrix format and find out using BFS that
     * whether or not the graph is bipartite i.e can be colored
     * @param graph
     * @param startIndex
     * @return
     */
    private static boolean isBiPartite(int[][] graph, int startIndex) {
        int[] colorStore = new int[graph.length];
        int BLUE = 0;
        int RED = 1;
        for(int i = 0 ; i < colorStore.length ; i++){
            colorStore[i] = -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        list.add(startIndex);
        colorStore[startIndex] = RED;
        while(list.size() > 0){
            int currentVertex = list.pop();
            //Self loop is important check. We need to
            //check and break from here.
            //Graph with Self Loop cannot be bi partite.
            if(graph[currentVertex][currentVertex] == 1){
                return false;
            }
            for(int neighboursIndex = 0; neighboursIndex < graph.length; neighboursIndex++){
                //find a neiighbour
                if(graph[currentVertex][neighboursIndex] == 1){
                    //check his color.. if we find one with same color then
                    //return false.
                    if(colorStore[currentVertex] == colorStore[neighboursIndex]){
                        return false;
                    }else if(colorStore[neighboursIndex] == -1){
                        //if the neighbour is not assigned color
                        //then assign him a color
                        colorStore[neighboursIndex] = 1 - colorStore[currentVertex];
                        list.add(neighboursIndex);
                    }
                }
            }
        }
        //if we reach here it means we successfully colored all
        //the vertices;
        return true;
    }
}
