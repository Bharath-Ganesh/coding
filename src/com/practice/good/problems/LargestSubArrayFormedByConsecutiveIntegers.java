package com.practice.good.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the largest subarray formed by consecutive integers
 * 
 * Input: { 2, 0, 2, 1, 4, 3, 1, 0 } Output: The largest subarray is { 0, 2, 1,
 * 4, 3 }
 *
 */
public class LargestSubArrayFormedByConsecutiveIntegers {

	public static void main(String args[]) {
		int[] arr = { 8, 0, 2, 3, 1, 7, 9, 0 };

		int max_length = -1;
		int initial_index=-1;
		int end_index=-1;
		for (int i = 0; i < arr.length - 1; i++) {
			int max = arr[i];
			int min = arr[i];
			Set<Integer> checkDuplicacy = new HashSet<>();
			checkDuplicacy.add(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {

				if (checkDuplicacy.contains(arr[j])) {
					break;
				}
				checkDuplicacy.add(arr[j]);
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);

				if ((max - min) == (j - i)) {
					int length = (j - i) + 1;
					if (max_length < length) {
						max_length = length;
					}
				}
			}
		}

	}

}
