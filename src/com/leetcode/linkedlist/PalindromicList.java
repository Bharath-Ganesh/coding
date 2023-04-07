package com.leetcode.linkedlist;

public class PalindromicList {


    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        System.out.println(isPalindrome(list1));
        display(list1);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode mid=middleNode(head);
        ListNode secondHead=reverseList(mid);

        while(head!=null && secondHead!=null){
            if(head.val!=secondHead.val){
                return false;
            }
            head=head.next;
            secondHead=secondHead.next;
        }
        return true;

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

        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
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
        listNode1.addNode(2);
        listNode1.addNode(1);
        return listNode1.head;
    }
}
