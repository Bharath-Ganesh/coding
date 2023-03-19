package com.leetcode.linkedlist;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList_4 {

    private static ListNode getLinkedNode() {
        LinkedNode listNode1= new LinkedNode();
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(5);
        return listNode1.head;
    }


    public static void main(String[] args) {
        ListNode head = getLinkedNode();
        ListNode reverseList=reverseList(head);
        display(reverseList);

    }

    public static ListNode reverseList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }
}
