package com.practice.geeks.linkedlist;

/**
 * Rearrange a linked list in such a way that all odd position nodes are
 * together and all even positions node are together,
 *
 * Input: 1->2->3->4 Output: 1->3->2->4
 * 
 * Input: 10->22->30->43->56->70 Output: 10->30->56->22->43->70
 */

public class RearrangeLinkedList {

	public static void rearrangeALinkedListOddEvenPositionUsingTwoPointer(Node head) {

		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		if (head.next == null || head.next.next == null) {
			return;
		}
		Node tail = new Node();
		tail = head;
		int counter = 0;
		while (tail.next != null) {
			tail = tail.next;
			counter++;
		}

		int number_of_jumps = counter % 2 == 0 ? counter / 2 + 1 : counter / 2;
		int count = 0;

		Node dummyhead = new Node();
		dummyhead = head;
		while (count <= number_of_jumps) {
			count++;

			tail.next = dummyhead.next;
			dummyhead.next = dummyhead.next.next;
			tail.next.next = null;
			dummyhead = dummyhead.next;
			tail = tail.next;
		}

	}

	public static void rearrangeALinkedListOddEvenPosition(Node head) {

		if (head == null) {
			System.out.println("Empty list");
			return;
		}

		if (head.next == null || head.next.next == null) {
			return;
		}

		Node odd = head;
		Node even = head.next;
		Node even_head = head.next;

		while (even != null && even.next != null) {

			odd.next = odd.next.next;
			even.next = even.next.next;
			odd = odd.next;
			even = even.next;

		}
		odd.next = even_head;

	}

	public static void main(String[] args) {
		LinkedLists linkedList = new LinkedLists();
		linkedList.insertAtHead(80);
		linkedList.insertAtHead(70);
		linkedList.insertAtHead(56);
		linkedList.insertAtHead(43);
		linkedList.insertAtHead(30);
		linkedList.insertAtHead(22);
		linkedList.insertAtHead(10);
		linkedList.display();
		Node head = linkedList.getNode();
		rearrangeALinkedListOddEvenPositionUsingTwoPointer(head);
	//	rearrangeALinkedListOddEvenPosition(head);
		linkedList.display();

	}
}