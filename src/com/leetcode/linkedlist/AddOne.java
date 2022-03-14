package com.leetcode.linkedlist;

public class AddOne {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        ListNode result = addOne(list1);
        display(result);
    }


    public static ListNode addOne(ListNode head) {
        //code here.
        ListNode revHead = reverseLinkedList(head);

        ListNode curr = revHead;
        int carry = 1;
        ListNode prev=null;
        while (curr != null) {
            int num = curr.val + carry;
            carry = num / 10;
            num = num % 10;
            curr.val = num;
            prev=curr;
            curr = curr.next;
        }

        if (carry != 0) {
            ListNode newListNode = new ListNode(1);
            prev.next = newListNode;
        }
        return reverseLinkedList(revHead);

    }


    public static ListNode reverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextListNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextListNode;
        }
        return prev;
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
        listNode1.addNode(9);
        listNode1.addNode(9);
        listNode1.addNode(9);
        return listNode1.head;
    }
}
