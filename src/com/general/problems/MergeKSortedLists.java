package com.general.problems;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String args[]){
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(5);
        ListNode root2= new ListNode(1);
        root2.next = new ListNode(3);
        root2.next.next = new ListNode(4);
        ListNode[] list = new ListNode[2];
        list[0] = root;
        list[1] = root2;
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        mergeKSortedLists.mergeKLists(list);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(ListNode list : lists){
            while(list != null){
                minHeap.add(list.val);
                list = list.next;
            }
        }

        ListNode head = new ListNode(-1);
        ListNode result = head;
        while(!minHeap.isEmpty()){
            ListNode newNode = new ListNode(minHeap.poll());
            head.next = newNode;
            head = head.next;
        }
        return result.next;
    }
}
