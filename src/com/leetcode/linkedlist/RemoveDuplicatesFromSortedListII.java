package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        ListNode head = getLinkedNode();
        ListNode newHead=deleteDuplicates(head);
        display(newHead);

    }

    public static ListNode deleteDuplicates(ListNode head) {

        Set<Integer> set = new HashSet();
        ListNode curr = head;
        ListNode prev = null;

        // remove all duplicates
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                set.add(curr.val);
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        curr = head;

        while (curr != null) {
            if (set.contains(curr.val)) {
                if (prev == null) {
                    curr = curr.next;
                    head=curr;
                    continue;
                }
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
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
        listNode1.addNode(1);
        listNode1.addNode(1);
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(4);
        listNode1.addNode(5);
        listNode1.addNode(5);
        return listNode1.head;
    }
}
