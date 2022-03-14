package com.leetcode.linkedlist;

public class ReorderList {


    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
       reorderList(list1);
        display(list1);
    }

    public static void reorderList(ListNode head) {
        ListNode middle=middleNode(head);
        ListNode secondHead=reverseList(middle);
        ListNode headFirst=head;
        while(headFirst!=null && secondHead!=null){
            ListNode temp=headFirst.next;
            headFirst.next=secondHead;
            headFirst=temp;
            temp=secondHead.next;

            if(temp==null){
                break;
            }
            secondHead.next=headFirst;
            secondHead=temp;

        }

//        if(headFirst!=null){
//            headFirst.next=null;
//        }
    }




    public static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode currNode=head;
        ListNode prev=null;

        while(currNode!=null){
            ListNode nextNode=currNode.next;
            currNode.next=prev;
            prev=currNode;
            currNode=nextNode;
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
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(4);

        return listNode1.head;
    }
}
