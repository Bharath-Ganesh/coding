package com.leetcode.linkedlist;

/**
 * 707. Design Linked List
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 * <p>
 * Implement the MyLinkedList class:
 * <p>
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 **/


class MyLinkedList {

    /**
     * Initialize your data structure here.
     */


    private Node head;
    private Node tail;
    private int size;


    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private class Node {
        Node next = null;
        int val = 0;

        public Node(int val) {
            this.val = val;
        }
    }


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= this.size) return -1;

        Node curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr.val;
    }

    public Node getNodeAt(int index) {
        Node curr = head;
        while (index-- > 0) {
            curr = curr.next;
        }

        return curr;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        if (this.size == 0) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.next = null;
            this.tail = node;
        }
        this.size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) return;

        if (index == 0) {
            addAtHead(val);
        } else if (index == this.size) {
            addAtTail(val);
        } else {
            Node prev = getNodeAt(index - 1);
            Node forw = prev.next;
            Node curr = new Node(val);
            prev.next = curr;
            curr.next = forw;
            this.size++;
        }
    }

    public void deleteFirst() {
        if (this.size == 0) return;
        else if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node curr = this.head;
            Node forw = curr.next;
            curr.next = null;
            this.head = forw;
        }
        this.size--;
    }

    public void deleteLast() {
        if (this.size == 0) return;
        else if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node secondLast = getNodeAt(this.size - 2);
            secondLast.next = null;
            this.tail = secondLast;
        }
        this.size--;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) return;

        if (index == 0) {
            deleteFirst();
        } else if (index == this.size - 1) {
            deleteLast();
        } else {
            Node prev = getNodeAt(index - 1);
            Node curr = prev.next;
            Node forw = prev.next.next;
            prev.next = forw;
            curr.next = null;
            this.size--;
        }
    }
}


public class DesignLinkedList_2 {


    //Your MyLinkedList object will be instantiated and called as such:
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(1);
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        obj.deleteAtIndex(1);
        int param_2 = obj.get(1);
    }


}
