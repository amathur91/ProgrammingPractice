package com.graph;

import org.junit.Test;

public class CloneGraphTest {

    @Test
    public void test1(){
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        one.neighbors.add(two);
        one.neighbors.add(four);
        two.neighbors.add(one);
        two.neighbors.add(three);
        three.neighbors.add(two);
        three.neighbors.add(four);
        four.neighbors.add(one);
        four.neighbors.add(three);
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedGraphRoot = cloneGraph.cloneGraph(one);
        System.out.println("DEBUG");
    }

}
