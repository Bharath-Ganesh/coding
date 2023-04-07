package com.practice.geeks.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an array arr[] of N positive integers. Push all the zero’s of the given
 * array to the right end of the array while maitaining the order of non-zero
 * elements.
 * 
 * N = 5 Arr[] = {3, 5, 0, 0, 4}
 * 
 * Output: 3 5 4 0 0 Explanation: The non-zero elements preserve their order
 * while the 0 elements are moved to the right
 *
 */
public class MoveAllZeroesToEndOfArray {

	public static void main(String[] args) {
		int arr[] = { 3, 5, 0, 0, 4 };
		moveAllZeroesToEndOfArray(arr);
	}

	public static void moveAllZeroesToEndOfArray(int[] arr) {

		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				swap(arr, i, counter++);
			}
		}

		Arrays.stream(arr).forEach(x -> System.out.println());

	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
