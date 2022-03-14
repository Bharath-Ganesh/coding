package com.leetcode.linkedlist;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode1();
        ListNode list2 = getLinkedNode2();
        ListNode result = addTwoLists(list1,list2);
        display(result);
    }

    static ListNode addTwoLists(ListNode first, ListNode second){
        // code here
        // return head of sum list
        ListNode revHead1=reverseLinkedList(first);
        ListNode revHead2=reverseLinkedList(second);

        ListNode dummyHead=new ListNode(-1);
        ListNode curr=dummyHead;

        int carry=0;
        while(revHead1!=null || revHead2!=null){
            int data1=revHead1==null?0:revHead1.val;
            int data2=revHead2==null?0:revHead2.val;
            int num=data1+data2+carry;
            carry=num/10;
            num=num%10;
            ListNode newListNode=new ListNode(num);
            curr.next=newListNode;
            curr=curr.next;

            if(revHead1!=null){
                revHead1=revHead1.next;
            }

            if(revHead2!=null){
                revHead2=revHead2.next;
            }
        }

        if(carry!=0){
            ListNode newListNode=new ListNode(carry);
            curr.next=newListNode;
        }
        return reverseLinkedList(dummyHead.next);

    }



    public static ListNode reverseLinkedList(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextListNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextListNode;
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
        listNode1.addNode(9);
        listNode1.addNode(9);
        return listNode1.head;
    }

    private static ListNode getLinkedNode2() {
        LinkedNode listNode1 = new LinkedNode();
        listNode1.addNode(9);
        return listNode1.head;
    }
}
