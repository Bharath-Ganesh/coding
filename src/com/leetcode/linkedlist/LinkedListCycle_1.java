package com.leetcode.linkedlist;



/**
 * 141. Linked List Cycle
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 */
public class LinkedListCycle_1 {

    public static void main(String[] args) {
        LinkedNode listNode = getLinkedNode();
        ListNode temp=listNode.head;
        while (temp!=null){
            temp=temp.next;
        }
        listNode.display();
    }

    private static LinkedNode getLinkedNode() {
        LinkedNode listNode= new LinkedNode();
        listNode.addNode(3);
        listNode.addNode(2);
        listNode.addNode(0);
        listNode.addNode(-4);
        return listNode;
    }


}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}

    ListNode(int x) {
        val = x;
        next = null;
    }

}

class LinkedNode {

    ListNode head;
    ListNode tail;

    public LinkedNode(){

    }

    public LinkedNode(ListNode node){
        this.head=node;
    }

    void addNode(int element){
        if (head==null){
            ListNode tempNode=new ListNode(element);
            tempNode.val=element;
            tempNode.next=null;
            head=tail=tempNode;
        }else{
            ListNode temp=new ListNode();
            temp.val=element;
            temp.next=null;
            tail.next=temp;
            tail=temp;
        }
    }

    void display(){
        if (head==null){
            System.out.println("No elements to be displayed");
        }else{
            ListNode temp=head;
            while (temp!=null){
                System.out.print(temp.val+ " ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
}