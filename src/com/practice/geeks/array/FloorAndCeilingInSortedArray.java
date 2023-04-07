
package com.practice.geeks.array;

/**
 * Given a sorted array and a value x, the ceiling of x is the smallest element
 * in array greater than or equal to x, and the floor is the greatest element
 * smaller than or equal to x. Assume than the array is sorted in non-decreasing
 * order. Write efficient functions to find floor and ceiling of x.
 * 
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 *
 * For x = 0: floor doesn't exist in array, ceil = 1
 * 
 * For x = 1: floor = 1, ceil = 1
 * 
 * For x = 5: floor = 2, ceil = 8
 * 
 * For x = 20: floor = 19, ceil doesn't exist in array
 *
 */
public class FloorAndCeilingInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 8, 10, 12, 13, 19 };
		int element = 0;
		floorAndCeilingInSortedArray(arr, element);
		binarySearch(arr, element);

	}

	private static void floorAndCeilingInSortedArray(int[] arr, int x) {

		Integer ceil = arr[arr.length - 1] + 1;
		Integer floor = arr[0] - 1;

		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] == x) {
				ceil = arr[mid];
				floor = arr[mid];
				break;
			} else if (arr[mid] < x) {
				floor = arr[mid];
				low = mid + 1;
			} else {
				ceil = arr[mid];
				high = mid - 1;
			}
		}
		String ceilMessage = (ceil == arr[arr.length - 1] + 1) ? "Not found " : ceil + "";
		String floorMessage = (floor == arr[0] - 1) ? "Not found " : floor + "";
		System.out.println("Ceil  :" + ceilMessage);
		System.out.println("Floor :" + floorMessage);

	}

	private static void binarySearch(int[] arr, int element) {

		int start = 0;
		int end = arr.length - 1;
		int floor = 0;
		int ceil = 0;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (arr[mid] == element) {
				floor = element;
				ceil = element;
				break;
			} else if (mid == 0 || (arr[mid] > element && arr[mid - 1] < element)) {
				if (mid == 0) {
					floor = -1;
				} else {
					floor = arr[mid - 1];
				}

				ceil = arr[mid];
				break;
			} else if (mid == arr.length - 1 || (arr[mid] < element && arr[mid + 1] > element)) {

				if (mid == arr.length - 1) {
					ceil = -1;
				} else {
					ceil = arr[mid + 1];
				}
				floor = arr[mid];
				break;
			} else if (arr[mid] > element) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println("Ceil  :" + ceil);
		System.out.println("Floor :" + floor);

	}

}
