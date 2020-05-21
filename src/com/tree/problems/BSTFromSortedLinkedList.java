package com.tree.problems;

public class BSTFromSortedLinkedList {
    private static ListNode root;

    public static void main(String args[]){
        root = new ListNode(1);
        root.setNext(new ListNode(2));
        root.getNext().setNext(new ListNode(3));
        root.getNext().getNext().setNext(new ListNode(4));
        root.getNext().getNext().getNext().setNext(new ListNode(5));
        root.getNext().getNext().getNext().getNext().setNext(new ListNode(6));
        root.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode(7));
        BSTNode rootNode = buildBSTFromLinkedList();
        performInOrderTraversal(rootNode);
    }

    private static void performInOrderTraversal(BSTNode rootNode) {
        if(rootNode != null){
            performInOrderTraversal(rootNode.getLeftChild());
            System.out.println(rootNode.getData());
            performInOrderTraversal(rootNode.getRightChild());
        }
    }

    private static BSTNode buildBSTFromLinkedList() {
        int length = getLengthOfList(root);
        BSTNode treeRoot = buildBSTUtil(length);
        return treeRoot;
    }

    private static BSTNode buildBSTUtil(int length) {
        if(length <= 0){
            return null;
        }

        BSTNode leftChild = buildBSTUtil(length / 2);

        BSTNode rootNode = new BSTNode(root.getData());
        root = root.getNext();
        rootNode.setLeftChild(leftChild);

        BSTNode rightNode = buildBSTUtil(length - length/2 -1);
        rootNode.setRightChild(rightNode);

        return rootNode;
    }

    private static int getLengthOfList(ListNode root) {
        int length = 0;
        while(root != null){
            length++;
            root = root.getNext();
        }
        return length;
    }
}
class BSTNode{
    private int data;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public BSTNode(int data){
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }
}

class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
