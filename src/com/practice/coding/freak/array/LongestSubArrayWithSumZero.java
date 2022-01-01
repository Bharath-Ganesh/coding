package com.practice.coding.freak.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the sub array with sum zero { 2, 5, -5, 2, -2, 3, 6 };
 *
 */
public class LongestSubArrayWithSumZero {

	public static void main(String args[]) {

		int[] arr = { 2, 5, -5, 2, -2, 3, 6 };
		int sum = 0;

		Map<Integer, Integer> subArrayMap = new HashMap<>();
		subArrayMap.put(0, -1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (subArrayMap.containsKey(sum)) {
				subArrayMap.get(sum);
				System.out.println("[" + (subArrayMap.get(sum) + 1) + "," + i + "]");

			} else {
				subArrayMap.put(sum, i);
			}
		}

	}

}
