package com.practice.geeks.array;

/**
 * Given an array of n distinct integers sorted in ascending order, write a
 * function that returns a Fixed Point in the array, if there is any Fixed Point
 * present in array, else returns -1. Fixed Point in an array is an index i such
 * that arr[i] is equal to i. Note that integers in array can be negative.
 * 
 * 
 * Input: arr[] = {-10, -5, 0, 3, 7} Output: 3 // arr[3] == 3
 * 
 * Input: arr[] = {0, 2, 5, 8, 17} Output: 0 // arr[0] == 0
 * 
 * Input: arr[] = {-10, -5, 3, 4, 7, 9} Output: -1 // No Fixed Point
 *
 */
public class FindAFixedPointInAGivenArray {

	public static void main(String[] args) {

		int[] arr = { -10, -5, 0, 3, 7 };
		int fixedElement = findFixedPointInArray(arr);
		int fixedElementBinarySearch = binarySearchRecursive(arr, 0, arr.length - 1);
		System.out.println(fixedElement);
		System.out.println(fixedElementBinarySearch);

	}

	private static int findFixedPointInArray(int[] arr) {

		int fixedPoint = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i) {
				fixedPoint = i;
				break;
			}

		}
		return fixedPoint;
	}

	private static int binarySearch(int[] arr) {

		int fixedPoint = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {

			int mid = (start + end) / 2;
			if (arr[mid] == mid) {
				fixedPoint = mid;
				break;
			} else {
				if (arr[mid] < mid) {
					start = mid + 1;
				} else {
					end = end - 1;
				}
			}

		}
		return fixedPoint;

	}

	private static int binarySearchRecursive(int[] arr, int start, int end) {

		int mid = (start + end) / 2;

		if (start > end) {
			return -1;
		}
		if (arr[mid] == mid) {
			return mid;
		} else {
			if (arr[mid] < mid) {
				return binarySearchRecursive(arr, mid + 1, end);
			} else {
				return binarySearchRecursive(arr, start, end - 1);
			}
		}

	}

}
