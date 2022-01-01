package com.practice.coding.freak.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array , determine if can be divided into pairs such that sum
 * of the elements in each pair is divisible by a given integer k
 * 
 * Input: arr[] = { 3, 1, 2, 6, 9, 4 } k = 5 Output: Pairs can be formed
 * Explanation: Array can be divided into pairs {(3, 2), (1, 9), (4, 6)} where
 * the sum of elements in each pair is divisible by 5.
 * 
 * Input: arr[] = { 2, 9, 4, 1, 3, 5 } k = 6
 *
 */
public class ArrayCanBeDividedIntoPairs {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 6, 9, 4, 10, 20, 30, 40 };
		int k = 5;

		int numberOfPairs = findPairsWithSumK(arr, k);
		System.out.println(numberOfPairs);
	}

	public static int findPairsWithSumK(int arr[], int k) {

		Map<Integer, Integer> remainderFreq = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			remainderFreq.put(arr[i] % k, remainderFreq.getOrDefault(arr[i] % k, 0) + 1);
		}
		int totalPairs = 0;

		for (Integer remainder : remainderFreq.keySet()) {
			int freq = remainderFreq.get(remainder);
			if (remainder == 0) {
				totalPairs = freq / 2;
			} else {
				if (remainderFreq.containsKey(k - remainder)) {
					int counterFreq = remainderFreq.get(k - remainder);
					int pairs = counterFreq >= freq ? freq : counterFreq;
					totalPairs += pairs;
					remainderFreq.put(k - remainder, 0);
				}
			}

		}
		return totalPairs;
	}

}
