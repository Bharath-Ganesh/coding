package com.practice.mycodeschool.ds;

//private class is only accessible within the class scope
class Nodes {

	int data;
	Nodes next;

	public Nodes() {
	}

}

class LinkedLists {
	Nodes head;

	/**
	 * 
	 * 
	 */

	// **********************REVERSE LINKED LIST START************************//

	public Integer getSize() {
		Integer sizeOfLinkedList = 0;
		if (head != null) {
			Nodes temp = new Nodes();
			temp = head;
			while (temp != null) {
				sizeOfLinkedList++;
				temp = temp.next;
			}
		}
		return sizeOfLinkedList;
	}

	public Nodes getNode(int index) {

		Nodes temp = new Nodes();
		temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;

	}

	// 10|add-> 20 30 40 50 60 70
	public void reverseLinkedListUsingPointer() {

		Nodes prev = null;
		Nodes curr = head;

		while (curr != null) {
			Nodes originalCurrent = curr.next;
			curr.next = prev;
			prev = curr;
			curr = originalCurrent;
		}
		head = prev;

	}

	public void reverseLinkedList() {

		int leftIndex = 0;
		Integer sizeOflinkedList = getSize();
		int rightIndex = sizeOflinkedList - 1;

		while (leftIndex <= rightIndex) {
			Nodes leftNode = getNode(leftIndex);
			Nodes rightNode = getNode(rightIndex);

			int temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;

			leftIndex++;
			rightIndex--;

		}
	}

	public void displayLinkedUsingRecursion(Nodes temp) {

		if (temp != null) {
			System.out.printf("%d ", temp.data);
			displayLinkedUsingRecursion(temp.next);
		}
	}

	public void displayInReverseLinkedUsingRecursion(Nodes temp) {

		if (temp != null) {
			displayLinkedUsingRecursion(temp.next);
			System.out.printf("%d ", temp.data);
		}
	}

	// 10 20 30 40 50
	/**
	 * Important
	 */
	public Nodes reverseLinkedListUsingRecursion(Nodes prevNode) {

		if(prevNode==null || prevNode.next==null){
			head=prevNode;
			return prevNode;
		}
		Nodes nextNode=prevNode.next;
		Nodes newHead=reverseLinkedListUsingRecursion(nextNode);
		nextNode.next=prevNode;
		prevNode.next=null;
		return newHead;
	}

	// ********REVERSE LINKED LIST END******************************//

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public void removeAtIndex(int index) {

		Integer sizeOfLinkedList = 0;
		if (head != null) {
			Nodes temp = new Nodes();
			temp = head;
			while (temp != null) {
				sizeOfLinkedList++;
				temp = temp.next;
			}
		}

		if (index < 0 || sizeOfLinkedList < index) {
			System.out.println("Invalid index");
		} else if (index == 1) {
			removeAtBeginning();
		} else if (index == (sizeOfLinkedList - 1)) {
			removeAtEnd();
		} else {
			Nodes temp = new Nodes();
			temp = head;
			for (int ind = 0; ind < index - 1; ind++) {
				temp = temp.next;
			}
			Nodes nodeToBeRemoved = new Nodes();
			nodeToBeRemoved = temp.next;
			temp.next = nodeToBeRemoved.next;
			nodeToBeRemoved = null;
		}
	}

	// 10 20 30 40 50 60 70
	public void removeAtEnd() {
		Nodes temp = new Nodes();
		Nodes prevNode = new Nodes();
		temp = head;
		while (temp.next != null) {
			prevNode = temp;
			temp = temp.next;
		}
		temp = null;
		prevNode.next = null;

	}

	public void removeAtBeginning() {

		if (head != null) {
			Nodes tempNode = new Nodes();
			tempNode = head.next;
			head = null;
			head = tempNode;
		}

	}

	public void searchElement(int element) {

		Nodes tempNode = new Nodes();
		tempNode = head;
		while (tempNode != null) {
			if (tempNode.data == element) {
				break;
			}
			tempNode = tempNode.next;
		}
		if (tempNode != null) {
			System.out.println("Element found");
		} else {
			System.out.println("Not found");
		}
	}

	// 10 20 30 40 50
	public void getValueAtIndex(int index) {

		Integer size = 0;

		if (head != null) {
			Nodes temp = new Nodes();
			temp = head;
			while (temp != null) {
				size++;
				temp = temp.next;
			}
		}

		if (index < 0 || index >= size) {
			System.out.println("Invalid index");
		} else {
			Nodes tempNode = new Nodes();
			tempNode = head;
			for (int ind = 0; ind < index; ind++) {
				tempNode = tempNode.next;
			}
			System.out.println("Element at index :" + tempNode.data);

		}

	}

	// 10 20 30 40 60 70 80
	// if index is 4;n is 60; i have to get the index of n-1(40);
	// establish a link btw n-1 and temp; and temp and n+1;
	public void insertAtIndex(int index, int data) {

		Integer sizeOfLinkedList = 0;
		if (null == head) {
			insertAtBeginning(data);
		} else {
			Nodes temp = new Nodes();
			temp = head;
			while (temp != null) {
				sizeOfLinkedList++;
				temp = temp.next;
			}
		}

		if (index > (sizeOfLinkedList)) {
			System.out.println("Index out of bound");
		} else if (sizeOfLinkedList == index) {
			insertAtEnd(data);
		} else {
			Nodes temp = new Nodes();
			temp = head;
			for (int ind = 0; ind < index - 1; ind++) {
				temp = temp.next;
			}
			Nodes tempNode = new Nodes();
			tempNode.data = data;
			tempNode.next = temp.next;
			temp.next = tempNode;
		}

	}

	public void insertAtEnd(int data) {

		if (head != null) {
			// 10 20 30 40 50 60
			Nodes temp = new Nodes();
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			Nodes tempNode = new Nodes();
			tempNode.data = data;
			tempNode.next = null;
			temp.next = tempNode;

		} else {
			insertAtBeginning(data);
		}

	}

	public void insertAtBeginning(int data) {

		Nodes tempNode = new Nodes();
		tempNode.data = data;
		tempNode.next = null;

		if (null != head) {
			tempNode.next = head;
			head = tempNode;
		} else {
			head = tempNode;
		}

	}

	public void display() {

		Nodes tempNode = new Nodes();
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

}

public class LinkedListNode {

	public static void main(String[] args) {
		LinkedLists linkedList = new LinkedLists();
		linkedList.insertAtBeginning(40);
		linkedList.insertAtBeginning(30);
		linkedList.insertAtBeginning(20);
		linkedList.insertAtBeginning(10);
//		linkedList.insertAtEnd(60);
//		linkedList.insertAtEnd(70);
//		linkedList.insertAtIndex(4, 50);
//		linkedList.insertAtIndex(4, 80);
//		linkedList.removeAtIndex(4);
		// linkedList.getValueAtIndex(7);
		// linkedList.insertAtIndex(4, 80);
		linkedList.display();
		// linkedList.searchElement(80);
		// linkedList.reverseLinkedList();
		// linkedList.reverseLinkedListUsingPointer();
		// linkedList.display();
		Nodes head = linkedList.getNode(0);
		linkedList.reverseLinkedListUsingRecursion(head);
		linkedList.display();

	}
}
