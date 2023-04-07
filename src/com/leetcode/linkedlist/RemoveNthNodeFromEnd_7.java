package com.leetcode.linkedlist;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEnd_7 {

    private static ListNode getLinkedNode() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(5);
        return listNode1.head;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        ListNode head = getLinkedNode();
        ListNode slowHead = removeNthFromEnd(head,2);
        display(slowHead);

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;

        ListNode fast=dummyHead,slow=dummyHead;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;

        return dummyHead.next;

    }
}
