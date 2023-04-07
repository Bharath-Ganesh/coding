package com.practice.geeks.array;

/**
 * 
 * Given an array Arr[0 … N-1] containing N positive integers, a subarray Arr[i
 * … j] is bitonic if there is a k with i <= k <= j such that A[i] <= Arr[i+1]
 * <= ... <= Arr[k] >= Arr[k+1] >= ... A[j – 1] >= A[j]. Write a function that
 * takes an array and array length as arguments and returns the length of the
 * maximum length bitonic subarray.
 * 
 * For Example: In array {20, 4, 1, 2, 3, 4, 2, 10}
 * 
 * the maximum length bitonic subarray is {1, 2, 3, 4, 2} which is of length 5.
 * 
 * Input: N = 4 Arr[] = {10, 20, 30, 40}
 * 
 * Output: 4 Explanation: In the given array, bitonic subarray is 10 <= 20 <= 30
 * <= 40.
 *
 */
public class MaximumLengthBitonicSubArray {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40 };
		int maxLength = maximumLengthBitonicSubArray(arr, arr.length);
		System.out.println(maxLength);
	}

	public static int maximumLengthBitonicSubArray(int arr[], int n) {
		// Length of increasing subarray ending
		// at all indexes
		int[] inc = new int[n];
		// Length of decreasing subarray starting
		// at all indexes
		int[] dec = new int[n];
		int max;

		// Length of increasing sequence ending at first index is 1
		inc[0] = 1;

		// Length of increasing sequence starting at first index is 1
		dec[n - 1] = 1;

		// 41, 18, 49, 15, 71, 79, 42, 51, 18, 94, 34, 96, 48, 15, 45, 18, 84

		// Step 1) Construct increasing sequence array
		for (int i = 1; i < n; i++)
			inc[i] = (arr[i] >= arr[i - 1]) ? inc[i - 1] + 1 : 1;

		// Step 2) Construct decreasing sequence array
		for (int i = n - 2; i >= 0; i--)
			dec[i] = (arr[i] >= arr[i + 1]) ? dec[i + 1] + 1 : 1;

		// Step 3) Find the length of maximum length bitonic sequence
		max = inc[0] + dec[0] - 1;
		for (int i = 1; i < n; i++)
			if (inc[i] + dec[i] - 1 > max)
				max = inc[i] + dec[i] - 1;

		return max;
	}
}
