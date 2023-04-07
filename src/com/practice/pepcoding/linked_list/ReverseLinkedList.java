package com.practice.pepcoding.linked_list;

import java.util.LinkedList;

public class ReverseLinkedList {

	public static void display(LinkedList<Integer> linkedList) {

		if (linkedList.size() > 0) {
			for (int i = 0; i < linkedList.size(); i++) {
				System.out.println(linkedList.get(i));
			}
		} else {
			System.out.println("No elements to be displayed");

		}
	}

	public static void main(String args[]) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		LinkedList<Integer> reverseLinkedList = new LinkedList<>();
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);

		while (linkedList.size() > 0) {
			reverseLinkedList.add(linkedList.removeLast());
		}
		display(reverseLinkedList);

	}

}