package com.practice.geeks.array;

import java.util.Arrays;

/**
 * Replace every element with the greatest element on right side
 *
 *
 * iven an array of integers, replace every element with the next greatest
 * element (greatest element on the right side) in the array. Since there is no
 * element next to the last element, replace it with -1. For example, if the
 * array is
 * 
 * I/P : {16, 17, 4, 3, 5, 2}
 * 
 * O/P : {17, 5, 5, 5, 2, -1}.
 *
 */
public class ReplaceEveryElementWithGreeatestElementOnRight {

	public static void main(String[] args) {

		int arr[] = { 16, 17, 22, 12, 8, 4, 3, 5, 2, 1 };
		int result[] = findGreatestElementToRight(arr);
		System.out.println(Arrays.toString(result));

		int result2[] = findGreatestElementToRightUsingBruteForce(arr);
		System.out.println(Arrays.toString(result2));

	}

	/**
	 * O(n)
	 */
	private static int[] findGreatestElementToRight(int[] arr) {
		//16, 17, 4, 3, 5, 2
		int[] result = new int[arr.length];
		result[arr.length - 1] = -1;
		int max = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			result[i] = max;
			if (arr[i] > max) {
				max = arr[i];
			}

		}
		return result;

	}

	/**
	 * O(n^2)
	 */
	private static int[] findGreatestElementToRightUsingBruteForce(int[] arr) {
		// 16, 17, 4, 3, 5, 2
		int result[] = new int[arr.length];

		for (int i = 0; i < result.length - 1; i++) {
			int max_element = -1;
			for (int j = i + 1; j < result.length - 1; j++) {
				if (max_element < arr[j]) {
					max_element = arr[j];
				}
			}
			result[i] = max_element;
		}
		result[arr.length - 1] = -1;
		result[arr.length - 2] = arr[arr.length - 1];
		return result;
	}

}
