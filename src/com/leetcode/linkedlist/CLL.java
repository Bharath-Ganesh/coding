package com.leetcode.linkedlist;

public class CLL {

    private Node head;
    private Node tail;

    public CLL() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println(" HEAD ");
    }

    public void delete(int val) {
        if (head == null) {
            return;
        }
        Node node = head;
        if (node.val == val) {
            head = head.next;
            tail.next = head;
            return;
        }
        do {
            Node nextNode = node.next;
            if (nextNode.val == val) {
                node.next = nextNode.next;
                break;
            }
            node = node.next;
        } while (node != head);

    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
