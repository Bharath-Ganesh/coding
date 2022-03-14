package com.leetcode.linkedlist;

import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedList {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        int k = 2;
        ListNode result = removeDuplicates(list1);
        display(result);
    }


    public static ListNode removeDuplicates(ListNode head) {
        // Your code here
        ListNode ptr1 = head;
        while (ptr1 != null && ptr1.next != null) {
            ListNode ptr2 = ptr1;
            while (ptr2.next != null) {
                if (ptr1.val == ptr2.next.val) {
                    ptr2.next = ptr2.next.next;
                } else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
        return head;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    private static ListNode getLinkedNode() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(5);
        listNode1.addNode(2);
        listNode1.addNode(2);
        listNode1.addNode(2);
        listNode1.addNode(4);
        return listNode1.head;
    }
}
