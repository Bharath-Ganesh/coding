package com.practice.pepcoding.generic_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//		     10
//	    /    |    \
//	  20     30    40
//   /  \   / | \    \
// 50   60 70 80 90   100
//	         / \
//	       110  120 

// int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1}
// Stack implementation of generic tree using array using euler's representation.
public class GenericTree {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static int size(Node node) {
		int size = 0;
		for (Node element : node.children) {
			int cs = size(element);
			size += cs;
		}
		return size + 1;
	}

	public static int maximumInGenericTree(Node node) {
		Integer max = Integer.MIN_VALUE;
		for (Node element : node.children) {
			Integer child_max = maximumInGenericTree(element);
			max = Math.max(max, child_max);
		}
		max = Math.max(max, node.data);
		return max;
	}

	public static void display(Node node) {
		String str = node.data + " -> ";
		for (Node element : node.children) {
			str += element.data + " ";
			display(element);
		}
		str += ".";
		System.out.println(str);
	}

	public static void main(String[] args) {

		int[] arr = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1,
				-1 };

		stackImplementation(arr);
		// queueImplementation(arr);
	}

	/**
	 * @param arr
	 */
	public static void stackImplementation(int[] arr) {
		Stack<Node> stack = new Stack<>();
		Node root = new Node();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stack.pop();
			} else {
				Node temp = new Node();
				temp.data = arr[i];
				if (stack.size() == 0) {
					root = temp;
				} else {
					stack.peek().children.add(temp);
				}
				stack.push(temp);
			}

		}
		display(root);
		// size(root);
		// System.out.println(size(root));
		System.out.println(maximumInGenericTree(root));
	}
}