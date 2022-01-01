package com.practice;

public class RecursiveSumOracle {

	public static void main(String args[]) {

		int[] arr = { 2, 4, 5, 6, 3, 4, 6, 7, 8, 9 };
		int sum = sumRecursive(arr, arr.length - 1);
		System.out.println(sum);

	}

	private static int sumRecursive(int[] arr, int length) {
		if (length < 0) {
			return 0;
		} else {
			// for recursive function we can't have a separate variable for storing num
			// find the element or process which keeps repeating
			return arr[length] + sumRecursive(arr, --length);
		}

	}

}
