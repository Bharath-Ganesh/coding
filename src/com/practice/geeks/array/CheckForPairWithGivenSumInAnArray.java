package com.practice.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in A[] whose sum is exactly
 * x.
 * 
 *
 *
 * Input: arr[] = {0, -1, 2, -3, 1} sum = -2 Output: -3, 1 If we calculate the
 * sum of the output, 1 + (-3) = -2
 * 
 * Input: arr[] = {1, -2, 1, 0, 5} sum = 0 Output: -1 No valid pair exists.
 */
public class CheckForPairWithGivenSumInAnArray {

	public static void main(String[] args) {
		int arr[] = { 1, -2, 1, 0, 5};
		int sum = 0;
		checkForPairWithGivenSumInAnArray(arr, sum);
	}

	private static void checkForPairWithGivenSumInAnArray(int[] arr, int sum) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int diff = sum - arr[i];
			if (map.containsKey(diff)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + diff + ")");
				return;
			}
			map.put(arr[i], i);
		}
		System.out.println(-1);

	}

}
