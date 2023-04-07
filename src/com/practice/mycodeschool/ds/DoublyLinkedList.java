package com.practice.mycodeschool.ds;

//private class is only accessible within the class scope
class Node {

	Node prevNode;
	int data;
	Node nextNode;

	public Node() {
	}

}

class DoublyLinkedNode {

	Node head;

	public Node getNode(int data) {

		Node newNode = new Node();
		newNode.data = data;
		newNode.prevNode = null;
		newNode.nextNode = null;
		return newNode;

	}

	public Integer getSize() {
		Integer size = 0;
		if (head != null) {
			Node newNode = new Node();
			newNode = head;
			while (newNode != null) {
				size++;
				newNode = newNode.nextNode;
			}
		}
		return size;
	}

	public void display() {
		if (head != null) {
			Node newNode = new Node();
			newNode = head;
			while (newNode != null) {
				System.out.printf("%d ", newNode.data);
				newNode = newNode.nextNode;
			}
			System.out.println("");
		} else {
			System.out.println("No elements to be displayed");
		}
	}

	public void insertNodeAtIndex(int index, int data) {
		Integer size = getSize();

		if (index < 0 || index >= size) {
			System.out.println("Invalid index");
		} else if (index == 1) {
			insertNodeAtHead(data);
		} else if (index == (size)) {
			insertNodeAtEnd(data);
		} else {

			Node temp = new Node();
			temp = head;
			for (int ind = 0; ind < index - 1; ind++) {
				temp = temp.nextNode;
			}
			Node nodeToBeInserted = getNode(data);
			nodeToBeInserted.nextNode = temp.nextNode;
			nodeToBeInserted.prevNode = temp;
			temp.nextNode = nodeToBeInserted;

		}
	}

	public void insertNodeAtHead(int data) {
		Node newNode = getNode(data);
		if (head != null) {
			newNode.nextNode = head;
			head.prevNode = newNode;
		}
		head = newNode;
	}

	public void deleteNode(Node del) {

		// Base case
		if (head == null || del == null) {
			return;
		}

		// If node to be deleted is head node
		if (head == del) {
			head = del.nextNode;
		}

		// Change next only if node to be deleted
		// is NOT the last node
		if (del.nextNode != null) {
			del.nextNode.prevNode = del.prevNode;
		}

		// Change prev only if node to be deleted
		// is NOT the first node
		if (del.prevNode != null) {
			del.prevNode.nextNode = del.nextNode;
		}

		// Finally, free the memory occupied by del
		return;
	}

	public void insertNodeAtEnd(int data) {

		if (head == null) {
			insertNodeAtHead(data);
		} else {
			Node temp = new Node();
			temp = head;
			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}
			Node newNode = getNode(data);
			newNode.prevNode = temp;
			temp.nextNode = newNode;

		}

	}

}

public class DoublyLinkedList {

	public static void main(String[] args) {

		DoublyLinkedNode doublyLinkedNode = new DoublyLinkedNode();
		doublyLinkedNode.insertNodeAtHead(30);
		doublyLinkedNode.insertNodeAtHead(20);
		doublyLinkedNode.insertNodeAtHead(10);
		doublyLinkedNode.insertNodeAtEnd(50);
		doublyLinkedNode.insertNodeAtEnd(60);
		doublyLinkedNode.display();
		doublyLinkedNode.insertNodeAtIndex(4, 40);
		doublyLinkedNode.display();

	}
}
