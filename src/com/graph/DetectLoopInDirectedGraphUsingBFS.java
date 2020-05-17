package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class DetectLoopInDirectedGraphUsingBFS {
    public static void main(String args[]){
        Graph graph = new Graph(6);
        graph.getAdjacencyList()[0].add(1);
        graph.getAdjacencyList()[0].add(4);
        graph.getAdjacencyList()[1].add(2);
        graph.getAdjacencyList()[2].add(3);
      //  graph.getAdjacencyList()[3].add(2);
        graph.getAdjacencyList()[4].add(5);
       // graph.getAdjacencyList()[5].add(1);
        boolean isCyclePresent = checkForCycle(graph);
        System.out.println("Presence of Cycle in Graph : " + isCyclePresent);
    }

    private static boolean checkForCycle(Graph graph) {
        int[] incomingEdgeStore = new int[graph.getVertices()];
        Queue<Integer> processor = new LinkedList<>();

        //populate the incoming edge for all the vertices.
        for(int vertexIndex = 0 ; vertexIndex < graph.getVertices(); vertexIndex++){
            LinkedList listOfNeighbours = graph.getAdjacencyList()[vertexIndex];
            for(int neighbourIndex = 0; neighbourIndex < listOfNeighbours.size(); neighbourIndex++){
                incomingEdgeStore[(int) listOfNeighbours.get(neighbourIndex)] += 1;
            }
        }

        //find the vertex with 0 incoming edge
        int startVertex = findNextZeroIncomingEdgeVertex(graph, incomingEdgeStore);

        processor.add(startVertex);
        int visitedVertices = 0;
        while(!processor.isEmpty()){
            int currentVertex = processor.poll();
            LinkedList<Integer> neighbourList = graph.getAdjacencyList()[currentVertex];
            for( Integer neighbour : neighbourList){
                incomingEdgeStore[neighbour] -= 1;
            }
            visitedVertices++;
            incomingEdgeStore[currentVertex] = -1;
            int nextVertex = findNextZeroIncomingEdgeVertex(graph, incomingEdgeStore);
            if(nextVertex != -1){
                processor.add(nextVertex);
            }
        }
        if(visitedVertices != graph.getVertices()){
            return true;
        }
        return false;
    }

    private static int findNextZeroIncomingEdgeVertex(Graph graph, int[] incomingEdgeStore) {
        int startVertex = -1;
        for(int index = 0; index < graph.getVertices(); index++){
            if(incomingEdgeStore[index] == 0){
                startVertex = index;
                break;
            }
        }
        return startVertex;
    }
}
