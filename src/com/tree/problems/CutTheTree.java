package com.tree.problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cutTheTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY data
     *  2. 2D_INTEGER_ARRAY edges
     */

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        List<Integer> differenceList = new ArrayList<>();
        Node rootNode = null;
        if(data.size() == 0 || edges.size() == 0){
            return 0;
        }
        HashMap<Integer, Node> treeNodeMap = new HashMap<>();
        for(List<Integer> edge : edges){
            int vertex1 = edge.get(0);
            int vertex2 = edge.get(1);
            if(null == rootNode){
                rootNode = new Node(vertex1);
                treeNodeMap.put(vertex1, rootNode);
                rootNode.setWeight(data.get(vertex1 - 1));
                Node leftChild = new Node(vertex2);
                treeNodeMap.put(vertex2,leftChild);
                leftChild.setWeight(data.get(vertex2 - 1));
                rootNode.setLeftChild(leftChild);
            }else {
                buildTree(data, rootNode, treeNodeMap, edge);
            }
        }
        findMinimumDifference(rootNode, 0, differenceList);
        Collections.sort(differenceList);


        return differenceList.get(0);
    }

    private static void findMinimumDifference(Node rootNode, int topSum, List<Integer> differenceList) {
        if(rootNode != null){
            int leftSubTreeSum = findSubTreeSum(rootNode.getLeftChild());
            int rightSubTreeSum = findSubTreeSum(rootNode.getRightChild());
            int diff1 = Math.abs(leftSubTreeSum + rootNode.getWeight() + topSum - rightSubTreeSum);
            int diff2 = Math.abs(rightSubTreeSum + rootNode.getWeight() + topSum - leftSubTreeSum);
            differenceList.add(diff1);
            differenceList.add(diff2);
            findMinimumDifference(rootNode.getLeftChild(), rootNode.getWeight() + rightSubTreeSum + topSum, differenceList);
            findMinimumDifference(rootNode.getRightChild(), rootNode.getWeight() + leftSubTreeSum + topSum, differenceList);
        }
    }

    private static int findSubTreeSum(Node root) {
        if(root != null){
            return root.getWeight() + findSubTreeSum(root.getLeftChild()) + findSubTreeSum(root.getRightChild());
        }
        return 0;
    }

    private static void buildTree(List<Integer> data, Node rootNode, HashMap<Integer, Node> treeNodeMap, List<Integer> edge) {
        int vertex1 = edge.get(0);
        int vertex2 = edge.get(1);
        if (!treeNodeMap.containsKey(vertex1) && !treeNodeMap.containsKey(vertex2)) {
            Node firstNode = new Node(vertex1);
            firstNode.setWeight(data.get(vertex1 - 1));
            treeNodeMap.put(vertex1, firstNode);
            Node secondNode = new Node(vertex2);
            secondNode.setWeight(data.get(vertex2 - 1));
            treeNodeMap.put(vertex2, secondNode);
            firstNode.setLeftChild(secondNode);
        }
        else if(treeNodeMap.containsKey(vertex1) && !treeNodeMap.containsKey(vertex2)){
            Node node = treeNodeMap.get(vertex1);
            if(node.getLeftChild() == null){
                Node leftChild = new Node(vertex2);
                leftChild.setWeight(data.get(vertex2 - 1));
                node.setLeftChild(leftChild);
                treeNodeMap.put(vertex2, leftChild);
            }else{
                Node rightChild  = new Node(vertex2);
                rightChild.setWeight(data.get(vertex2 - 1));
                node.setRightChild(rightChild);
                treeNodeMap.put(vertex2, rightChild);
            }
        }else if(treeNodeMap.containsKey(vertex1) && treeNodeMap.containsKey(vertex2)) {
            Node n1 = treeNodeMap.get(vertex1);
            Node n2 = treeNodeMap.get(vertex2);
            if(n1.getLeftChild() == null){
                n1.setLeftChild(n2);
            }else if(n2.getLeftChild() == null){
                n2.setLeftChild(n1);
            }else if(n1.getRightChild() == null){
                n1.setRightChild(n2);
            }else if(n2.getRightChild() == null){
                n2.setRightChild(n1);
            }
        }
        else{
            Node secondNode = treeNodeMap.get(vertex2);
            Node firstNode = new Node(vertex1);
            firstNode.setWeight(data.get(vertex1 - 1));
            if(secondNode.getLeftChild() == null){
                secondNode.setLeftChild(firstNode);
            }else{
                secondNode.setRightChild(firstNode);
            }
            treeNodeMap.put(vertex1, firstNode);
        }
    }

}

class Node{
    private int data;
    private int weight;
    private Node leftChild;
    private Node rightChild;

    public Node(int data){
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
}

public class CutTheTree {
    public static void main(String[] args) throws IOException {
        List<Integer> weightList = new ArrayList<>();
        //205 573 985 242 830 514 592 263 142 915
        weightList.add(205);
        weightList.add(573);
        weightList.add(985);
        weightList.add(242);
        weightList.add(830);
        weightList.add(514);
        weightList.add(592);
        weightList.add(263);
        weightList.add(142);
        weightList.add(915);

        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge1 = new ArrayList<>();
        edge1.add(2);
        edge1.add(8);

        List<Integer> edge2 = new ArrayList<>();
        edge2.add(10);
        edge2.add(5);

        List<Integer> edge3 = new ArrayList<>();
        edge3.add(1);
        edge3.add(7);

        List<Integer> edge4 = new ArrayList<>();
        edge4.add(6);
        edge4.add(9);

        List<Integer> edge5 = new ArrayList<>();
        edge5.add(4);
        edge5.add(3);

        List<Integer> edge6 = new ArrayList<>();
        edge6.add(8);
        edge6.add(10);

        List<Integer> edge7 = new ArrayList<>();
        edge7.add(5);
        edge7.add(1);

        List<Integer> edge8 = new ArrayList<>();
        edge8.add(7);
        edge8.add(6);

        List<Integer> edge9 = new ArrayList<>();
        edge9.add(9);
        edge9.add(4);


        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);
        edges.add(edge6);
        edges.add(edge7);
        edges.add(edge8);
        edges.add(edge9);

        Result.cutTheTree(weightList, edges);




    }
}
