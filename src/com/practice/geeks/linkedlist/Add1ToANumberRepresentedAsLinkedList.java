package com.practice.geeks.linkedlist;

/**
 * Number is represented in linked list such that each digit corresponds to a
 * node in linked list.
 * 
 * Add 1 to it. For example 1999 is represented as
 * 
 * (1-> 9-> 9 -> 9) and adding 1 to it should change it to (2->0->0->0)
 *
 */

//Java program to add 1 to a linked list

class Node {

	int data;
	Node next;

	public Node(int d) {
		data = d;
		next = null;
	}

	public Node() {
	}

}

class LinkedLists {
	Node head;

	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		if (head != null) {
			newNode.next = head;
			head = newNode;
		} else {
			head = newNode;
		}
	}

	public Node getNode() {
		Node temp = new Node();
		temp = head;
		return temp;
	}

	public Node addOne() {

		reverseLinkedList();
		Node prevNode = null;
		Node newNode = new Node();
		newNode = head;
		Integer carry = 0;
		head.data += 1;

		while (head != null && (head.data > 9 || carry > 0)) {
			prevNode = head;
			head.data += carry;
			carry = head.data / 10;
			head.data = head.data % 10;
			head = head.next;
		}

		if (carry > 0) {
			prevNode.next = new Node(carry);
		}
		head = newNode;
		reverseLinkedList();
		return head;

	}

	public void reverseLinkedListUsingRecursion(Node temp) {

		if (temp.next == null) {
			head = temp;
			return;
		}
		reverseLinkedListUsingRecursion(temp.next);
		Node currNode = temp.next;
		currNode.next = temp;
		temp.next = null;
	}

	public void reverseLinkedList() {

		Node currNode = head;
		Node prevNode = null;

		while (currNode != null) {
			Node originalCurrentNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = originalCurrentNode;
		}

		head = prevNode;

	}

	public Node reverseLinkedListUsingHead() {

		Node currNode = head;
		Node prevNode = null;

		while (currNode != null) {
			Node originalCurrentNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = originalCurrentNode;
		}

		head = prevNode;
		return head;

	}

	public void displayRecurive(Node temp) {

		if (temp != null) {
			System.out.printf("%d ", temp.data);
			displayRecurive(temp.next);
		}
	}

	public void display() {

		Node tempNode = new Node();
		Integer sizeOfLinkedList = 0;
		if (head != null) {
			tempNode = head;
			while (tempNode != null) {
				System.out.print(tempNode.data + " ");
				sizeOfLinkedList++;
				tempNode = tempNode.next;
			}
		} else {
			System.out.println("List is empty");
		}
		System.out.println(" Total size: " + sizeOfLinkedList);

	}

	public Node addTwoNumbers(Node l1, Node l2) {
		int carry = 0;
		Node p = new Node(0);
		Node dummy = new Node(0);
		p = dummy;

		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				carry += l1.data;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.data;
				l2 = l2.next;
			}
			p.next = new Node(carry % 10);
			carry /= 10;
			p = p.next;
		}
		return dummy.next;
	}

	public void displayLinkedUsingRecursion(Node temp) {

		if (temp != null) {
			System.out.printf("%d ", temp.data);
			displayLinkedUsingRecursion(temp.next);

		}
	}

	public void test() {
		LinkedLists linkedList = new LinkedLists();
		LinkedLists linkedList2 = new LinkedLists();
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		// linkedList.insertAtHead(9);
		// linkedList.insertAtHead(3);

		linkedList2.insertAtHead(9);
		linkedList2.insertAtHead(9);
		linkedList2.insertAtHead(9);
		linkedList2.insertAtHead(9);

		linkedList.display();
		linkedList2.display();

		linkedList.reverseLinkedList();
		linkedList2.reverseLinkedList();

		Node l1 = linkedList.getNode();
		Node l2 = linkedList2.getNode();

		Node l3 = addTwoNumbers(l1, l2);
		displayLinkedUsingRecursion(l3);

	}

	public void test2() {
		LinkedLists linkedList = new LinkedLists();
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(9);
		Node l1 = linkedList.getNode();
		Node head = linkedList.addOne();
		displayLinkedUsingRecursion(head);

	}

}

public class Add1ToANumberRepresentedAsLinkedList {

	public static void main(String[] args) {
		LinkedLists linkedList = new LinkedLists();
		linkedList.test2();

	}
}