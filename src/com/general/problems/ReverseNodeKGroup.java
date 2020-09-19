package com.general.problems;


public class ReverseNodeKGroup {
    public static void main(String args[]){
        ListNode rootNode = new ListNode(1);
        rootNode.next = new ListNode(2);
        rootNode.next.next = new ListNode(3);
        rootNode.next.next.next = new ListNode(4);
        rootNode.next.next.next.next = new ListNode(5);
      //  rootNode.next.next.next.next.next = new ListNode(6);
        ReverseNodeKGroup reverseNodeKGroup = new ReverseNodeKGroup();
        ListNode reversedHead = reverseNodeKGroup.reverseKGroup(rootNode, 3);
        System.out.println("Debug");
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        //Sanity Checks
        if (null == head) {
            return null;
        }
        if(head.next == null) {
            return head;
        }
        if(k == 1){
            return head;
        }

        ListNode startPoint = head;
        ListNode endPoint = head;
        ListNode nextHead = head;
        ListNode newHead = null;
        int difference=0;
        while(true) {
            while (difference < k && endPoint != null) {
                endPoint = endPoint.next;
                difference++;
            }
            if(difference < k){
                ListNode joinNode = newHead;
                while(joinNode.next != null){
                    joinNode = joinNode.next;
                }
                joinNode.next = startPoint;
                break;
            } else{
                nextHead = endPoint;

                ListNode reverseHead = reverse(startPoint, endPoint, k);
                if(newHead == null){
                    newHead = reverseHead;
                }else {
                    ListNode joinNode = newHead;
                    while(joinNode.next != null){
                        joinNode = joinNode.next;
                    }
                    joinNode.next = reverseHead;
                }
            }
            startPoint = endPoint;
            difference = 0;
        }
        return newHead;
    }

    private ListNode reverse(ListNode startPoint, ListNode endPoint, int k) {
        if(k == 2){
            ListNode firstNode = startPoint;
            ListNode secondNode = startPoint.next;
            firstNode.next = null;
            secondNode.next = firstNode;
            return secondNode;
        } else{
            ListNode leftNode = startPoint;
            ListNode middleNode = startPoint.next;
            ListNode rightNode = middleNode.next;
            leftNode.next = null;
            while(rightNode != null && rightNode != endPoint){
                middleNode.next = leftNode;

                leftNode = middleNode;
                middleNode = rightNode;
                rightNode = rightNode.next;
            }
            middleNode.next = leftNode;
            return middleNode;
        }
    }
}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }