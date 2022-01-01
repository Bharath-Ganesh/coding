package com.practice.coding.freak.array;

import java.util.Arrays;

/**
 * Move all zeros present in an array to the end
 *
 *
 * Input: { 6, 0, 8, 2, 3, 0, 4, 0, 1 }
 * 
 * Output: { 6, 8, 2, 3, 4, 1, 0, 0, 0 }
 */
public class MoveAllZero {

	public static void main(String args[]) {
		int[] arr = { 6, 0, 0, 8, 2, 3, 0, 4, 0, 1 };
		moveAllZero(arr);

	}

	private static void moveAllZero(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				swap(arr, i, counter);
				counter++;
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
