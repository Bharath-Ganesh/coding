package com.practice.coding.freak.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * Find duplicate element in a limited range array
 */
public class DuplicateElement {

	// Function to find a duplicate element in a limited range array
	public static int findDuplicate(int[] arr) {

		// create a visited array of size `n+1`
		// we can also use a map instead of a visited array

		int duplicate = 0;
		Map<Integer, Integer> duplicateMap = new HashMap<>();
		int i = 0;
		for (int element : arr) {
			i++;
			if (duplicateMap.containsKey(element)) {
				duplicate = element;
				System.out.println("Duplicate element : " + element);
			}
			duplicateMap.put(element, i);
		}

		return duplicate;
	}

	public static int findDuplicateUsingSum(int[] arr) {

		// create a visited array of size `n+1`
		// we can also use a map instead of a visited array

		int total_sum = (arr.length * (arr.length + 1)) / 2;
		int sum = IntStream.of(arr).sum();
		int duplicate = arr.length - (total_sum - sum);
		return duplicate;
	}

	/*
	 * O(n) Time
	 */
	public static int findDuplicateUsingConstantSpace(int[] arr) {

		int duplicates = 0;
		for (int i = 0; i < arr.length; i++) {
			int abs = Math.abs(arr[i]);
			if (arr[abs] >= 0)
				arr[abs] = -arr[abs];
			else
				duplicates = abs;

		}
		return duplicates;
	}

	public static void main(String[] args) {
		// input array contains `n` numbers between 1 and `n-1`
		// with one duplicate, where `n` is the array's length
		int[] A = { 1, 2, 3, 1, 4 };

		System.out.println("The duplicate element is " + findDuplicateUsingConstantSpace(A));

	}

}
