package com.leetcode.linkedlist;

public class InsertionSortList {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        System.out.println(insertionSortList(list1));
        display(list1);
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (prev.val > curr.val) {
                ListNode temp = dummyHead;
                while (curr.val >  temp.next.val) {
                   temp=temp.next;
                }
                prev.next=curr.next;
                curr.next=temp.next;
                temp.next=curr;
                curr=prev.next;
            }else{
                prev=prev.next;
                curr=curr.next;
            }
        }
        return dummyHead.next;
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
        listNode1.addNode(4);
        listNode1.addNode(2);
        listNode1.addNode(1);
        listNode1.addNode(3);
        return listNode1.head;
    }
}
