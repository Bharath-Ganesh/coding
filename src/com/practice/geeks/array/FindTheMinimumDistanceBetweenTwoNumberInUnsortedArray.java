package com.practice.geeks.array;

/**
 * Given an unsorted array arr[] and two numbers x and y, find the minimum
 * distance between x and y in arr[]. The array might also contain duplicates.
 * You may assume that both x and y are different and present in arr[].
 * 
 * 
 * Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3},
 * 
 * x = 3, y = 6 Output: Minimum distance between 3 and 6 is 4.
 * 
 * Explanation:3 is at index 0 and 6 is at index 5, so the distance is 4
 *
 */
public class FindTheMinimumDistanceBetweenTwoNumberInUnsortedArray {

	public static void main(String[] args) {
		int arr[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		int n = arr.length;
		int x = 3;
		int y = 6;

		System.out.println("Minimum distance between " + x + " and " + y + " is " + minDist(arr, n, x, y));
		System.out.println("Minimum distance between " + x + " and " + y + " is " + minDistUsingOneLoop(arr, n, x, y));

	}

	private static int minDistUsingOneLoop(int[] arr, int n, int firstElement, int secondElement) {
		int minDistance = arr.length + 1;

		int currIndex = 0;
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == firstElement || arr[i] == secondElement) {
				currIndex = i;
				break;
			}
		}

		for (int j = i; j < arr.length; j++) {
			if ((arr[j] == firstElement || arr[j] == secondElement) && arr[j] != arr[currIndex]) {
				int length = j - currIndex;
				if (minDistance > length) {
					minDistance = length;
					currIndex = j;
				}

			}
		}
		return minDistance;
	}

	/**
	 * O(n^2)
	 */
	private static int minDist(int[] arr, int n, int x, int y) {

		int min_length = arr.length + 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == x && arr[j] == y || arr[i] == y && arr[j] == x) {
					int length = j - i;
					if (length < min_length) {
						min_length = length;
					}
				}
			}
		}
		return min_length;
	}

}
