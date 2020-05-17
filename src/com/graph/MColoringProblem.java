package com.graph;

public class MColoringProblem {
    public static void main(String args[]){
        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int colors = 3;
        boolean success = checkColoringForGraph(graph, colors);
        System.out.println("Coloring for graph with " + colors + " : " + success);
    }

    /**
     * create a memory store to remember the colors assigned to the vertices.
     * call a function which takes graph, this memory store and the start vertex index.
     * @param graph
     * @param colors
     * @return
     */
    private static boolean checkColoringForGraph(int[][] graph, int colors) {
        int[] vertexColorStore = new int[graph.length];
        //setting color for all vertex to be nothing.
        for(int i = 0; i < graph.length; i++){
            vertexColorStore[i] = -1;
        }

        boolean result = colorGraphUtil(graph, colors, vertexColorStore, 0);
        return result;
    }

    /**
     * This method takes start count of vertices and for each of them moving incrementally
     * assigns them a color if possible and proceeds.
     * In case we cannot assign color then it returns false and backtracks the solution.
     * @param graph
     * @param colors
     * @param vertexColorStore
     * @param currentVertex
     * @return
     */
    private static boolean colorGraphUtil(int[][] graph, int colors, int[] vertexColorStore, int currentVertex) {
        //check if vertex i can be assigned color from 1->n
        //if yes, then store it and call this method for the next neighbour.
        //this would be required for each neighbour
        if(currentVertex == graph.length){
            return true;
        }
        for(int color = 1; color < colors ; color++){
            //if the color is not assigned
            if(vertexColorStore[currentVertex] == -1){
                if(isSafe(graph,currentVertex, color, vertexColorStore)){
                    vertexColorStore[currentVertex] = color;
                    if(colorGraphUtil(graph, colors, vertexColorStore, currentVertex + 1)){
                        return true;
                    }
                    vertexColorStore[currentVertex] = -1;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    /**
     * This method takes a vertex, graph and color to be assigned to vertex and the memory store of vertex colors
     * this check if we can safely assign the input color to the vertex.
     * @param graph
     * @param currentVertex
     * @param color
     * @param vertexColorStore
     * @return
     */
    private static boolean isSafe(int[][] graph, int currentVertex, int color, int[] vertexColorStore) {
        for(int i = 0; i < graph.length ; i++){
            if(graph[currentVertex][i] == 1 && vertexColorStore[i] == color){
                return false;
            }
        }
        return true;
    }
}
