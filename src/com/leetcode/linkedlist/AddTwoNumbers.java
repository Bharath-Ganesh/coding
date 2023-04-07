package com.leetcode.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode1();
        ListNode list2 = getLinkedNode2();
        ListNode result = addTwoNumbers(list1, list2);
        display(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x= 1<<1;
        System.out.println(x);
        ListNode d1 = reverseLinkedList(l1);
        ListNode d2 = reverseLinkedList(l2);

//        ListNode d1 = l1;
//        ListNode d2 = l2;
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode dummyHead = head;
        while (d1 != null || d2 != null || carry != 0) {
            int val1 = d1 == null ? 0 : d1.val;
            int val2 = d2 == null ? 0 : d2.val;
            int num = val1 + val2 + carry;
            carry = num / 10;
            ListNode newNode = new ListNode(num % 10);
            head.next = newNode;
            head = head.next;

            if (d1 != null) {
                d1 = d1.next;
            }

            if (d2 != null) {
                d2 = d2.next;
            }
        }
        return dummyHead.next;
    }

//    static ListNode addTwoLists(ListNode first, ListNode second){
//        // code here
//        // return head of sum list
//        ListNode revHead1=reverseLinkedList(first);
//        ListNode revHead2=reverseLinkedList(second);
//
//        ListNode dummyHead=new ListNode(-1);
//        ListNode curr=dummyHead;
//
//        int carry=0;
//        while(revHead1!=null || revHead2!=null){
//            int data1=revHead1==null?0:revHead1.val;
//            int data2=revHead2==null?0:revHead2.val;
//            int num=data1+data2+carry;
//            carry=num/10;
//            num=num%10;
//            ListNode newListNode=new ListNode(num);
//            curr.next=newListNode;
//            curr=curr.next;
//
//            if(revHead1!=null){
//                revHead1=revHead1.next;
//            }
//
//            if(revHead2!=null){
//                revHead2=revHead2.next;
//            }
//        }
//
//        if(carry!=0){
//            ListNode newListNode=new ListNode(carry);
//            curr.next=newListNode;
//        }
//        return reverseLinkedList(dummyHead.next);
//
//    }


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

    private static ListNode getLinkedNode1() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(2);
        listNode1.addNode(4);
        listNode1.addNode(3);
        return listNode1.head;
    }

    private static ListNode getLinkedNode2() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(5);
        listNode1.addNode(6);
        listNode1.addNode(4);
        return listNode1.head;
    }
}
