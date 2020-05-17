package com.graph;

import java.util.LinkedList;

public class Graph{
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0 ; i < this.vertices; i++){
            adjacencyList[i] = new LinkedList();
        }
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(LinkedList<Integer>[] adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}
