package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Solution for Clone Graph Problem - Leetcode
 * https://leetcode.com/problems/clone-graph/submissions/
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
       if(node == null){
           return null;
       }
       HashSet<Node> visited = new HashSet<>();
       HashMap<Integer, Node> nodeMap = new HashMap<>();
       Node rootNode = new Node(node.val);
       nodeMap.put(rootNode.val, rootNode);
       doDFSAndBuildClone(rootNode, node, visited, nodeMap);
       return rootNode;
    }

    private void doDFSAndBuildClone(Node rootNode, Node node, HashSet<Node> visited, HashMap<Integer, Node> nodeMap) {
        if(rootNode != null && node.neighbors.size() > 0 && !visited.contains(node)){
            visited.add(node);
            for(Node neighbourNode : node.neighbors){
                Node clonedNeighbour = null;
                if(nodeMap.containsKey(neighbourNode.val)){
                    clonedNeighbour = nodeMap.get(neighbourNode.val);
                }else {
                    clonedNeighbour = new Node(neighbourNode.val);
                    nodeMap.put(neighbourNode.val, clonedNeighbour);
                }
                rootNode.neighbors.add(clonedNeighbour);
                doDFSAndBuildClone(clonedNeighbour, neighbourNode, visited, nodeMap);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}