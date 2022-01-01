package com.practice.geeks.array;

import java.util.Arrays;

/**
 * Given an unsorted array, find the minimum difference between any pair in
 * given array.
 * 
 * Input : {1, 5, 3, 19, 18, 25};
 * 
 * Output : 1 Minimum difference is between 18 and 19
 * 
 * Input : {30, 5, 20, 9};
 * 
 * Output : 4 Minimum difference is between 5 and 9
 * 
 * Input : {1, 19, -4, 31, 38, 25, 100};
 * 
 * Output : 5 Minimum difference is between 1 and -4
 *
 */
public class FindMinDifferenceBetweenAnyTwoElements {

	public static void main(String[] args) {
		int[] arr = { 1, 19, -4, 31, 38, 25, 100 };
		int distance = findMinDifferenceBetweenAnyTwoElementsBrute(arr);
		System.out.println(distance);

		int distance2 = findMinDifferenceBetweenAnyTwoElementsSort(arr);
		System.out.println(distance2);
	}

	/**
	 * O(n^2)
	 */
	public static int findMinDifferenceBetweenAnyTwoElementsBrute(int[] arr) {

		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int diff = Math.abs(arr[j] - arr[i]);
				if (minDiff > diff)
					minDiff = diff;
			}
		}
		return minDiff;
	}

	/**
	 * O(n Log(n))
	 */
	public static int findMinDifferenceBetweenAnyTwoElementsSort(int[] arr) {
		arr = Arrays.stream(arr).sorted().toArray();
		int minDiff = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			int diff = Math.abs(arr[i - 1] - arr[i]);
			if (minDiff > diff)
				minDiff = diff;
		}
		return minDiff;
	}

}
