package com.leetcode.linkedlist;

public class RemoveLoopInALinkedList {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        removeLoopSecond(list1);
        display(list1);
    }

    public static void removeLoopSecond(ListNode head) {
        // code here
        // remove the loop without losing any nodes
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            int length = 0;
            do {
                fast = fast.next;
                length += 1;
            } while (slow != fast);

            for (int i = 0; i < length - 1; i++) {
                slow = slow.next;
            }
            slow.next = null;
        }
    }


    public static void removeLoop(ListNode head) {
        // code here
        // remove the loop without losing any nodes
        ListNode slow = head;
        ListNode fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        int lengthOfLoop = 0;

        do {
            fast = fast.next;
            lengthOfLoop += 1;
        } while (slow != fast);

        fast = head;
        if (slow == fast) {
            for (int i = 0; i < lengthOfLoop - 1; i++) {
                slow = slow.next;
            }
            slow.next = null;
            return;
        }
        do {
            slow = slow.next;
            fast = fast.next;
        } while (slow != fast);

        for (int i = 0; i < lengthOfLoop - 1; i++) {
            slow = slow.next;
        }
        slow.next = null;


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
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(58);
        ListNode node3 = new ListNode(36);
        ListNode node4 = new ListNode(34);
        ListNode node5 = new ListNode(16);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
//        node4.next = node5;
//        node5.next = node3;
        LinkedNode listNode1 = new LinkedNode(node1);
        return listNode1.head;
    }
}
