package com.practice.coding.freak.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Find maximum length sub-array having given sum. A[] = { 5, 6, -5, 5, 3, 5, 3,
 * -2, 0 } Sum = 8
 */

public class FindMaxLengthSubArrayGivenSum {

	public static void main(String args[]) {

		int[] arr = { 8, 6, -5, 2, 3, 3, 0, -2, 0 };
		int given_sum = 8;
		int length = findMaxLengthSubArrayGivenSum(arr, given_sum);
		System.out.println(length);

	}

	public static int findMaxLengthSubArrayGivenSum(int[] arr, int given_sum) {
		int maxLength = -1;

		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(sum, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum - given_sum) && maxLength < i - map.get(sum - given_sum)) {
				maxLength = i - map.get(sum - given_sum);
			} else {
				map.put(sum, i);
			}
		}
		return maxLength;
	}

}
