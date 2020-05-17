package com.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String args[]){
        Graph graph = new Graph(6);
        graph.getAdjacencyList()[2].add(3);
        graph.getAdjacencyList()[3].add(1);
        graph.getAdjacencyList()[4].add(1);
        graph.getAdjacencyList()[4].add(0);
        graph.getAdjacencyList()[5].add(2);
        graph.getAdjacencyList()[5].add(0);
        printTopologicalSort(graph);
    }

    private static void printTopologicalSort(Graph graph) {
        Stack<Integer> visitingOrder = new Stack<>();
        boolean[] visited = new boolean[graph.getVertices()];
        for(int vertexIndex = 0; vertexIndex < graph.getVertices(); vertexIndex++) {
            doDFS(graph, visitingOrder, vertexIndex, visited);
        }
        while(!visitingOrder.isEmpty()){
            System.out.print(visitingOrder.pop() + " ");
        }
    }

    private static void doDFS(Graph graph, Stack<Integer> visitingOrder, int currentIndex, boolean[] visited) {
        if(currentIndex < graph.getVertices() && visited[currentIndex] == false){
            visited[currentIndex] = true;
            //find the neighbours
            LinkedList<Integer> neighbours = graph.getAdjacencyList()[currentIndex];
            //dfs on neighbours
            for(Integer neighbour : neighbours){
                if(!visitingOrder.contains(neighbour)) {
                    doDFS(graph, visitingOrder, neighbour, visited);
                }
            }
            visitingOrder.add(currentIndex);
        }
    }
}

