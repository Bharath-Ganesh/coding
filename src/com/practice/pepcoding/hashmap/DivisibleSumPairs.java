package com.practice.pepcoding.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * int[] arr = {1,3 ,2 ,6 ,1 ,2}; k=3
 * 
 * Output : (1,2) (1,2) (3,6) (2,1) (1,2)
 * 
 * IIndex : (0,2) (0,5) (1,3) (2,4) (4,5)
 * 
 * Find all divisible pairs
 *
 */
public class DivisibleSumPairs {

	public static void main(String[] args) {

		int k = 3;
		List<Integer> ar = new ArrayList(Arrays.asList(1, 3, 2, 6, 1, 2, 3, 6));
		divisibleSumPairs(ar.size(), k, ar);
		divisibleSumPairsUsingHashMap(ar.size(), k, ar);
	}

	/**
	 * O(n^2)
	 */
	public static int divisibleSumPairs(int n, int k, List<Integer> ar) {

		int sum = 0;
		int numberOfPairs = 0;
		for (int i = 0; i < ar.size(); i++) {
			sum = ar.get(i);
			for (int j = i + 1; j < ar.size(); j++) {
				sum += ar.get(j);
				if (sum % k == 0) {
					numberOfPairs++;
				}
				sum -= ar.get(j);

			}
		}
		System.out.println("Brute force approach  : " + numberOfPairs);
		return numberOfPairs;

	}

	/**
	 * O(n)
	 */
	public static int divisibleSumPairsUsingHashMap(int n, int k, List<Integer> arr) {

		Map<Integer, Integer> remainderFreqMap = new HashMap<>();
		int numberOfPairs = 0;

		// 1, 3, 2, 6, 1, 2, 3, 6 k=3
		for (int i = 0; i < arr.size(); i++) {
			int remainder = arr.get(i) % k;
			int compliment_rem = (k - remainder) == k ? 0 : k - remainder;

			if (remainderFreqMap.containsKey(compliment_rem)) {
				numberOfPairs += remainderFreqMap.get(compliment_rem);
			}
			if (remainderFreqMap.containsKey(remainder)) {
				remainderFreqMap.put(remainder, remainderFreqMap.getOrDefault(remainder, 0) + 1);
			} else {
				remainderFreqMap.put(remainder, 1);
			}
		}
		System.out.println("HashMap  : " + numberOfPairs);
		return numberOfPairs;

	}

}
