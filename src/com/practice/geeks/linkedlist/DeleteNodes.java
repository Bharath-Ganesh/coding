package com.practice.geeks.linkedlist;

/**
 *
 * Given a linked list and two integers M and N. Traverse the linked list such
 * that you retain M nodes then delete next N nodes, continue the same till end
 * of the linked list.
 *
 * Input: M = 2, N = 2
 * 
 * Linked List: 1->2->3->4->5->6->7->8
 * 
 * Output:
 * 
 * Linked List: 1->2->5->6
 * 
 * M = 1, N = 1
 * 
 * Linked List: 1->2->3->4->5->6->7->8->9->10
 * 
 * Output: Linked List: 1->3->5->7->9
 */

public class DeleteNodes {

	public static void deleteNnodesAfterMnodes(Node head, int m, int n) {

		Node currNode = head, temp;
		while (currNode != null) {

			for (int i = 1; i < m && currNode != null; i++) {
				currNode = currNode.next;
			}

			if (currNode == null)
				return;

			temp = currNode.next;
			for (int i = 1; i <= n && temp != null; i++) {
				Node newNode = temp;
				temp = temp.next;

			}

			currNode.next = temp;
			currNode = temp;

		}
	}

	public static void main(String[] args) {
		LinkedLists linkedList = new LinkedLists();
		linkedList.insertAtHead(10);
		linkedList.insertAtHead(9);
		linkedList.insertAtHead(8);
		linkedList.insertAtHead(7);
		linkedList.insertAtHead(6);
		linkedList.insertAtHead(5);
		linkedList.insertAtHead(4);
		linkedList.insertAtHead(3);
		linkedList.insertAtHead(2);
		linkedList.insertAtHead(1);

		Node head = linkedList.getNode();
		deleteNnodesAfterMnodes(head, 1, 1);
		linkedList.display();
	}
}