package com.leetcode.linkedlist;

public class ReorderList {


    public static void main(String[] args) {
        ReorderList obj = new ReorderList();
        ListNode list1 = getLinkedNode();
        obj.reorderList(list1);
        display(list1);
    }

    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode newHead = reverseList(mid);

        ListNode tempNode = head;
        ListNode dummyHead = new ListNode(-1);
        ListNode dHead = dummyHead;

        while(tempNode!=null || newHead!=null){
            if(tempNode!=null){
                dummyHead.next = tempNode;
                dummyHead = dummyHead.next;
            }

            if(dummyHead!=null){
                dummyHead.next = newHead;
                dummyHead = dummyHead.next;
            }


            if(head!=null) tempNode = tempNode.next;
            if(newHead!=null) newHead = newHead.next;
        }

        head = dHead.next;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode mid = null;
        while(fast!=null && fast.next!=null){
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null;
        return slow;
    }

    public ListNode reverseList(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }
        ListNode nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }


//    public static void reorderList(ListNode head) {
//        if (head == null || head.next == null) {
//            return;
//        }
//
//        ListNode mid = findMiddleNode(head);
//        ListNode second = reverseList(mid);
//        ListNode first = head;
//
//        while (first != null && second != null) {
//            ListNode next = first.next;
//            first.next = second;
//            first = next;
//
//            next = second.next;
//            second.next = first;
//            second = next;
//        }
//
//        if (first != null) {
//            first.next = null;
//        }
//    }
//
//    public static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode nextNode = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return nextNode;
//    }
//
//    public static ListNode findMiddleNode(ListNode head) {
//
//        if (head == null) {
//            return head;
//        }
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }

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
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(5);

        return listNode1.head;
    }
}
