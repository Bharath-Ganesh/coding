package com.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedList {

    public static void main(String[] args) {
        ListNode list1 = getLinkedListNode();
        int k = 2;
        ListNode result = removeDuplicates(list1);
        display(result);
    }
    
    


    public static ListNode removeDuplicates(ListNode head) {
        // Your code here

        Set<Integer> set=new HashSet<>();
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            if(set.contains(curr.val)){
                if(prev!=null){
                    prev.next=curr.next;
                }
            }else{
                set.add(curr.val);
                prev=curr;
            }
            curr=curr.next;
        }
        return head;
        
        
//        ListNode ptr1 = head;
//        while (ptr1 != null && ptr1.next != null) {
//            ListNode ptr2 = ptr1;
//            while (ptr2.next != null) {
//                if (ptr1.val == ptr2.next.val) {
//                    ptr2.next = ptr2.next.next;
//                } else {
//                    ptr2 = ptr2.next;
//                }
//            }
//            ptr1 = ptr1.next;
//        }
//        return head;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();

    }

    private static ListNode getLinkedListNode() {
        LinkedNode ListNode1 = new LinkedNode();
        ListNode1.addNode(5);
        ListNode1.addNode(2);
        ListNode1.addNode(2);
        ListNode1.addNode(2);
        ListNode1.addNode(4);
        return ListNode1.head;
    }
}
