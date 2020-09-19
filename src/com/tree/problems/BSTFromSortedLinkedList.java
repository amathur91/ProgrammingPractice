package com.tree.problems;

public class BSTFromSortedLinkedList {
    private static ListNode1 root;

    public static void main(String args[]){
        root = new ListNode1(1);
        root.setNext(new ListNode1(2));
        root.getNext().setNext(new ListNode1(3));
        root.getNext().getNext().setNext(new ListNode1(4));
        root.getNext().getNext().getNext().setNext(new ListNode1(5));
        root.getNext().getNext().getNext().getNext().setNext(new ListNode1(6));
        root.getNext().getNext().getNext().getNext().getNext().setNext(new ListNode1(7));
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

    private static int getLengthOfList(ListNode1 root) {
        int length = 0;
        while(root != null){
            length++;
            root = root.getNext();
        }
        return length;
    }
}

 class ListNode1 {
    private int data;
    private ListNode1 next;

    public ListNode1(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode1 getNext() {
        return next;
    }

    public void setNext(ListNode1 next) {
        this.next = next;
    }
}
