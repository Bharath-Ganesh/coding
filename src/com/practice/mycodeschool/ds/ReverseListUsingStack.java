package com.practice.mycodeschool.ds;

import java.util.Arrays;
import java.util.Stack;

public class ReverseListUsingStack {

	public static void main(String[] args) {
		int[] arr = { 23, 21, 25, 65, 29 };
		reverseListUsingStack(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void reverseListUsingStack(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		for (Integer number : arr) {
			stack.push(number);
		}

		int count = 0;
		while (!stack.isEmpty()) {
			arr[count++] = stack.pop();
		}

	}

}
