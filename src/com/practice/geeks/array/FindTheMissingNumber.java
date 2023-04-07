package com.practice.geeks.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1
 * to n. There are no duplicates in the list. One of the integers is missing in
 * the list. Write an efficient code to find the missing integer.
 * 
 * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
 * 
 * Output: 5 Explanation: The missing number from 1 to 8 is 5
 * 
 * Input: arr[] = {1, 2, 3, 5}
 * 
 * Output: 4 Explanation: The missing number from 1 to 5 is 4
 *
 */
public class FindTheMissingNumber {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 6 };
		findTheMissingNumber(arr);
		findTheMissingNumberUsingSumApproach(arr);

	}

	// second approach
	// find the sum of all elements using n(n+1)/2 - sumofarray elements

	private static void findTheMissingNumberUsingSumApproach(int[] arr) {

		int n = arr.length;
		int total_sum = ((n + 1) * (n + 2)) / 2;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(total_sum - sum);

	}

	private static void findTheMissingNumber(int[] arr) {

		// sort the array and look for the missing index
		arr = Arrays.stream(arr).sorted().toArray();

		for (int i = 0; i < arr.length; i++) {
			if (!(arr[i] == i + 1)) {
				System.out.println(i + 1);
				break;
			}
		}

	}

}
