package com.leetcode.linkedlist;

public class DLL {

    public Node head;

    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Insert an element at the head of the linked list
     */
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        head = node;
        if (head != null) {
            head.prev = node;
        }
    }

    /**
     * Display elements of the linked list
     */
    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    /**
     * Insert at the last position
     */
    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        node.next = null;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }


    public void insert(int after, int val) {
        Node temp=find(after);
        if(temp==null){
            System.out.println("No elements found ");
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next=node;
        node.prev = temp;
        if (node.next != null) {
            node.next.prev = node;
        }
    }


    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }


}
