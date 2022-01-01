package com.practice.coding.freak.array;

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
		int length = largestSubArrayFormedByConsecutiveIntegers(arr);
		System.out.println(length);
		int length2 = largestSubArrayFormedByConsecutiveIntegersHash(arr);
		System.out.println(length2);
	}

	public static int largestSubArrayFormedByConsecutiveIntegers(int[] arr) {
		int max_length = 0;
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

				if ((max - min) == (j - i) && (max - min) > max_length) {
					max_length = max - min + 1;
				}
			}
		}
		return max_length;
	}

	public static int largestSubArrayFormedByConsecutiveIntegersHash(int[] arr) {
		int max_length = -1;
	
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
		return max_length;
	}

}
