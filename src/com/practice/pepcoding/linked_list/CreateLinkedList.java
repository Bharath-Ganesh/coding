package com.practice.pepcoding.linked_list;

class Node {
	int data;
	Node next;
}

class LinkedListNode {
	Node head;
	Node tail;
	int size;

	public int size() {
		return size;
	}

	void addAtIndex(int index, int data) {
		if (size == 0) {
			addFirstNode(data);
		} else if (index == size) {
			addNode(data);
		} else if (index < 0 || index >= size) {
			System.out.println("Invalid arguments");
		} else {
			Node newNode = new Node();
			newNode.data = data;

			Node temp = new Node();
			temp = head;
			for (int i = 0; i < index - 1; i++) {
				temp = temp.next;
			}

			newNode.next = temp.next;
			temp.next = newNode;
			size++;
		}
	}

	void removeLastNode() {
		if (size == 0) {
			System.out.println("No elements to be removed");
		} else if (size == 1) {
			head = tail = null;
			size = 0;
		} else {
			Node temp = new Node();
			temp = head;
			for (int i = 0; i < size - 2; i++) {
				temp = temp.next;
			}
			tail = temp;
			temp.next = null;
			size--;
		}
	}

	void addFirstNode(int data) {
		if (size == 0) {
			Node temp = new Node();
			temp.data = data;
			temp.next = null;
			head = tail = temp;
			size++;
		} else {
			
			Node temp=new Node();
			temp.data=data;
			temp.next=null;
			tail.next=temp;
			temp=tail;
			
		
		}
	}

	int getDataAtIndex(int index) {
		if (size == 0) {
			System.out.println("List is empty");
			return -1;
		} else if (index < 0 || index >= size) {
			System.out.println("No element found at the index");
			return -1;
		} else {
			Node temp = new Node();
			temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp.data;
		}
	}

	/**
	 * 1. No element 2. One element 3. More than one element
	 */
	void removeFirstNode() {
		if (size == 0) {
			System.out.println("List is empty");
		} else if (size == 1) {
			head = tail = null;
			size = 0;
		} else {

			head = head.next;
			size = size - 1;
		}
	}

	void display() {
		Node temp = new Node();
		temp = head;
		if (temp != null) {
			while (temp != null) {
				System.out.println(temp.data);
				temp = temp.next;
			}
		} else {
			System.out.println("List is empty");
		}

	}

	void addNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = null;

		if (size == 0) {
			head = tail = temp;
		} else {
			tail.next = temp;
			tail = temp;
		}
		size++;
	}
}

public class CreateLinkedList {

	public static void main(String args[]) {
		LinkedListNode linkedList = new LinkedListNode();
		linkedList.addNode(20);
		linkedList.addNode(30);
		linkedList.addNode(50);
		linkedList.addNode(60);
		linkedList.addAtIndex(2, 40);
		linkedList.removeLastNode();
		linkedList.display();

	}

}