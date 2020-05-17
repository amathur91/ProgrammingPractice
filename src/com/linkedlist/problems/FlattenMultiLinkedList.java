package com.linkedlist.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FlattenMultiLinkedList {
    public static void main(String args[]){
        Node rootNode = new Node(10);
        rootNode.setNext(new Node(5));
        rootNode.getNext().setNext(new Node(12));
        rootNode.getNext().getNext().setNext(new Node(7));
        rootNode.getNext().getNext().getNext().setNext(new Node(11));
        // Now time to set the children of the nodes

        rootNode.setChild(new Node(4));
        rootNode.getChild().setNext(new Node(20));
        rootNode.getChild().getNext().setNext(new Node(13));
        rootNode.getChild().getNext().setChild(new Node(2));
        rootNode.getChild().getNext().getNext().setChild(new Node(16));
        rootNode.getChild().getNext().getNext().getChild().setChild(new Node(3));

        rootNode.getNext().getNext().getNext().setChild(new Node(17));
        rootNode.getNext().getNext().getNext().getChild().setNext(new Node(6));
        rootNode.getNext().getNext().getNext().getChild().setChild(new Node(9));
        rootNode.getNext().getNext().getNext().getChild().getChild().setNext(new Node(8));
        rootNode.getNext().getNext().getNext().getChild().getChild().setChild(new Node(19));
        rootNode.getNext().getNext().getNext().getChild().getChild().getChild().setNext(new Node(15));

        ArrayList<FlatNode> flattenList = flattenList(rootNode);
        flattenList.stream().forEach((flatNode)->{
            System.out.print(flatNode.getData()+" ");
        });
    }

    private static ArrayList<FlatNode> flattenList(Node rootNode) {
        ArrayList<FlatNode> flatList = new ArrayList<>();
        Queue<Node> processQueue = new ArrayDeque<>();
        processQueue.add(rootNode);

        while(!processQueue.isEmpty()){
            Node temp = processQueue.poll();
            while(temp != null){
              //  System.out.print(temp.getData() + " ");
                flatList.add(new FlatNode(temp.getData()));
                if(temp.getChild() != null){
                    processQueue.add(temp.getChild());
                }
                temp = temp.getNext();
            }
        }
        return flatList;
    }
}



class Node{
    private int data;
    private Node next;
    private Node child;

    public Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getChild() {
        return child;
    }

    public void setChild(Node child) {
        this.child = child;
    }
}

class FlatNode{
    private int data;
    private FlatNode nextFlatNode;

    public FlatNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public FlatNode getNextFlatNode() {
        return nextFlatNode;
    }

    public void setNextFlatNode(FlatNode nextFlatNode) {
        this.nextFlatNode = nextFlatNode;
    }
}
