package com.leetcode.stackqueues;

/**
 * How to implement a stack which will support following operations in O(1) time complexity?
 * 1) push() which adds an element to the top of stack.
 * 2) pop() which removes an element from top of stack.
 * 3) findMiddle() which will return middle element of the stack.
 * 4) deleteMiddle() which will delete the middle element.
 * Push and pop are standard stack operations.
 */
public class _011_DesignAStackWithO1Mid {

    public static void main(String[] args) {
        _011_DesignAStackWithO1Mid object = new _011_DesignAStackWithO1Mid();
        object.push(10);
        object.push(20);
        object.push(30);
        object.push(40);
        object.push(50);
        object.push(60);
        object.push(70);
        object.push(80);
        object.push(90);
        object.push(100);
        object.display();
        System.out.println(object.getMid());
        System.out.println("POP : " + object.pop());
        System.out.println("POP : " + object.pop());
        System.out.println("POP : " + object.pop());
        object.display();
        System.out.println(object.getMid());

    }

    Node dummyHead;
    Node head;
    Node mid;
    int count = 0;

    public _011_DesignAStackWithO1Mid() {
        Node newNode = new Node(-1);
        this.dummyHead = newNode;
        this.head = newNode;
        this.mid = newNode;
        this.count = 0;
    }

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.prev = head;
        head.next = newNode;
        newNode.next = null;
        count++;
        head = newNode;
        if (count == 1) {
            mid = newNode;
        } else if (count % 2 == 0) {
            mid = mid.next;
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        int element = head.data;
        head = head.prev;
        if (head != null) {
            head.next = null;
        }
        count--;
        if (count % 2 == 1) {
            mid = mid.prev;
        }
        return element;
    }

    public boolean empty() {
        if (head == dummyHead) {
            return true;
        }
        return false;
    }

    public int getMid() {
        if (empty()) {
            return -1;
        }
        return mid.data;
    }

    public void display() {
        Node dummyHead = this.dummyHead.next;
        while (dummyHead != null) {
            System.out.print(dummyHead.data + " -> ");
            dummyHead = dummyHead.next;
        }
        System.out.println("END");
    }


}
