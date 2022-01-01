package com.leetcode.linkedlist;

/**
 * 83. Remove Duplicates from Sorted List
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedList_5 {

    private static ListNode getLinkedNode() {
        LinkedNode listNode1= new LinkedNode();
        listNode1.addNode(1);
        listNode1.addNode(1);
        listNode1.addNode(2);
        listNode1.addNode(3);
        listNode1.addNode(3);
        listNode1.addNode(3);
        listNode1.addNode(4);
        return listNode1.head;
    }


    public static void main(String[] args) {
        ListNode head = getLinkedNode();
        ListNode sortedLIst=deleteDuplicates(head);
        display(sortedLIst);

    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode temp=head;
        while(temp!=null){
            if(temp.next!=null && temp.next.val==temp.val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return head;

    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }


}
