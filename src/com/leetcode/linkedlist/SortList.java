package com.leetcode.linkedlist;

public class SortList {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        sortList(list1);
        display(list1);
    }


    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        ListNode mergeList = mergeTwoLists(left, right);
        display(mergeList);
        return mergeList;
    }

    public static ListNode middleNode(ListNode head) {
//        ListNode midPrev=null;
//        while(head!=null && head.next!=null){
//            midPrev=midPrev==null?head:midPrev.next;
//            head=head.next.next;
//        }
//        ListNode mid=midPrev.next;
//        midPrev.next=null;
//        return mid;

        ListNode midPrev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            midPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (midPrev != null) {
            midPrev.next = null;
        }
        return slow;
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode head = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                head.next = list2;
                list2 = list2.next;
            } else {
                head.next = list1;
                list1 = list1.next;
            }
            head = head.next;
        }

        if (list1 != null) {
            head.next = list1;
        }

        if (list2 != null) {
            head.next = list2;
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
        listNode1.addNode(6);
        listNode1.addNode(1);
        listNode1.addNode(3);
        listNode1.addNode(4);
        listNode1.addNode(8);
        return listNode1.head;
    }


}
