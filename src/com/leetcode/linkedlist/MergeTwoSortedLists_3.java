package com.leetcode.linkedlist;

/**
 * 21. Merge Two Sorted Lists
 *
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists_3 {

    private static ListNode getLinkedNode() {
        LinkedNode listNode1= new LinkedNode();
        listNode1.addNode(-9);
        listNode1.addNode(3);

        return listNode1.head;
    }


    private static ListNode getLinkedNode2() {
        LinkedNode listNode2= new LinkedNode();
        listNode2.addNode(5);
        listNode2.addNode(7);
        return listNode2.head;
    }

    public static void main(String[] args) {
        ListNode list1 = getLinkedNode();
        ListNode list2 = getLinkedNode2();
        ListNode mergeList=mergeTwoLists(list1,list2);
        display(mergeList);

    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode resultList=new ListNode(0);
        ListNode temp=resultList;

        while(list1!=null && list2!=null){

            if(list1.val > list2.val){
                temp.next=list2;
                list2=list2.next;
            }else{
                temp.next=list1;
                list1=list1.next;
            }
            temp=temp.next;
        }

        while(list1!=null){
            temp.next=list1;
            list1=list1.next;
            temp=temp.next;
        }

        while(list2!=null){
            temp.next=list2;
            list2=list2.next;
            temp=temp.next;
        }

        return resultList.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {

        ListNode resultList=new ListNode(0);
        ListNode fakeHead=resultList;
        while(l1!=null && l2!=null){
            if(l1.val > l2.val){
                fakeHead.next=l2;
                l2=l2.next;
            }else{
                fakeHead.next=l1;
                l1=l1.next;
            }
            fakeHead=fakeHead.next;
        }

        if(l1!=null){
            fakeHead.next=l1;
            l1=l1.next;
        }

        if(l2!=null){
            fakeHead.next=l2;
            l2=l2.next;
        }

        return resultList.next;
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
