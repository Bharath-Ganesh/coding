package com.practice.geeks.array;

import java.util.stream.IntStream;

/**
 * Given two arrays that are duplicates of each other except one element, that
 * is one element from one of the array is missing, we need to find that missing
 * element.
 * 
 * Input: arr1[] = {1, 4, 5, 7, 9} arr2[] = {4, 5, 7, 9}
 * 
 * Output: 1 is missing from second array.
 * 
 * Input: arr1[] = {2, 3, 4, 5} arr2[] = {2, 3, 4, 5, 6}
 * 
 * Output: 6 is missing from first array.
 *
 */
public class FindLostElementFromADuplicatedArray {

	public static void main(String[] args) {
		int[] arr2 = { 1, 4, 5, 7, 8, 9 };
		int[] arr1 = { 1, 4, 5, 7, 9 };
		int duplicateElement = findLostElementFromADuplicatedArrayBinary(arr1, arr2);
		System.out.println(duplicateElement);
	}

	/**
	 * O(n)
	 */
	public static int findLostElementFromADuplicatedArray(int[] arr1, int[] arr2) {
		return Math.abs(IntStream.of(arr1).sum() - IntStream.of(arr2).sum());
	}

	public static int findLostElementFromADuplicatedArrayBinary(int[] arr1, int[] arr2) {
		int duplicateElement = 0;
		if (arr1.length > arr2.length) {
			duplicateElement = binarySearch(arr1, arr2, arr1.length);
		} else {
			duplicateElement = binarySearch(arr2, arr1, arr2.length);
		}
		return duplicateElement;
	}

	public static int binarySearch(int[] arr1, int[] arr2, int size) {
		if (size == 1)
			return arr1[0];

		// special case, for first
		// element missing
		if (arr1[0] != arr2[0])
			return arr1[0];

		// Initialize current corner points
		int lo = 0, hi = size - 1;

		// loop until lo < hi
		while (lo < hi) {
			int mid = (lo + hi) / 2;

			// If element at mid indices are
			// equal then go to right subarray
			if (arr1[mid] == arr2[mid])
				lo = mid;
			else
				hi = mid;

			// if lo, hi becomes
			// contiguous, break
			if (lo == hi - 1)
				break;
		}

		// missing element will be at hi
		// index of bigger array
		return arr1[hi];
	}

}
