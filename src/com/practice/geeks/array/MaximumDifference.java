package com.practice.geeks.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an array arr[] of integers, find out the maximum difference between any
 * two elements such that larger element appears after the smaller number.
 * 
 * Input : arr = {2, 3, 10, 6, 4, 8, 1}
 * 
 * Output : 8 Explanation : The maximum difference is between 10 and 2.
 * 
 * Input : arr = {7, 9, 5, 6, 3, 2}
 * 
 * Output : 2 Explanation : The maximum difference is between 9 and 7.
 * 
 * 
 *
 */
public class MaximumDifference {

	public static void main(String[] args) {
		int arr[] = { 2, 3, 10, 6, 4, 8, 1 };
		int max = maximumDifferenceBrute(arr);
		int max2 = maximumDifference(arr);
		System.out.println(max);
		System.out.println(max2);

	}

	/**
	 * O(n2)
	 */
	private static int maximumDifferenceBrute(int[] arr) {
		int max = 0;
		int maxDiff = 0;
		for (int i = 0; i < arr.length; i++) {
			max = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			maxDiff = maxDiff < max - arr[i] ? max - arr[i] : maxDiff;
		}
		return maxDiff;
	}

	/**
	 * O(n)
	 */
	private static int maximumDifference(int[] arr) {
		int max = arr[arr.length - 1];
		int maxDiff = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
			} else {
				maxDiff = maxDiff < max - arr[i] ? max - arr[i] : maxDiff;
			}
		}
		return maxDiff;
	}

}
