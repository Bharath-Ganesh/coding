package com.practice.geeks.array;

/**
 * Given an array of n elements that contains elements from 0 to n-1, with any
 * of these numbers appearing any number of times. Find these repeating numbers
 * in O(n) and using only constant memory space.
 * 
 * Input : n = 7 and array[] = {1, 2, 3, 6, 3, 6, 1} Output: 1, 3, 6
 * 
 * Explanation: The numbers 1 , 3 and 6 appears more than once in the array.
 * 
 * Input : n = 5 and array[] = {1, 2, 3, 4 ,3} Output: 3
 * 
 * Explanation: The number 3 appears more than once in the array.
 */
public class FindDuplicatesInConstantSpace {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 ,3};
		findDuplicatesInConstantSpace(arr);

	}

	private static void findDuplicatesInConstantSpace(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int abs = Math.abs(arr[i]);
			if (arr[abs] < 0) {
				System.out.printf("%d ", abs);
			} else {
				arr[abs] = -arr[abs];
			}
		}

	}

}
