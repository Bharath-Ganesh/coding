package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find the number of pairs which are divisible by k.
 * // 9 56 25 52 72 44 80 36 96 71 55
 * // k->8
 * // (56,72) (9,55) (44,80)
 *
 * // 77 22 56 11 45 34 78 13
 * // K ->7
 * // (77,56) (45,11) (22,34) (78,13)  => 4
 */


public class CheckIfPairsDivisibleByK_03 {

	public static void main(String[] args) {

		int[] arr = { 9, 56, 25, 52, 72, 44, 80, 36, 96, 71, 55 };

		// int[] arr = { 77, 22, 56, 11, 45, 34, 78, 13 };
		int k = 8;
		int number = checkIfPairsDivisibleByK(arr, k);
		System.out.println(number);
	}

	private static int checkIfPairsDivisibleByK(int[] arr, int k) {
		int numberOfPairs = 0;
		Map<Integer, Integer> remainderFreq = new HashMap<>();
		//Remainder
		for (int i = 0; i < arr.length; i++) {
			int rem = arr[i] % k;
			remainderFreq.put(rem, remainderFreq.getOrDefault(rem, 0) + 1);
		}

		for (Integer remainder : remainderFreq.keySet()) {
			int freq = remainderFreq.get(remainder);
			if (freq == 0) {
				continue;
			} else if (remainder == 0 || 2 * remainder == k) {
				numberOfPairs += freq / 2;
				remainderFreq.put(remainder, 0);
			} else {
				int complementRemainder = k - remainder;
				int complementRemainderFreq = remainderFreq.getOrDefault(complementRemainder, 0);
				if (complementRemainderFreq == 0) {
					remainderFreq.put(remainder, 0);
					continue;
				} else {
					if (complementRemainderFreq > freq) {
						numberOfPairs += freq;
					} else {
						numberOfPairs += complementRemainderFreq;
					}
					remainderFreq.put(remainder, 0);
					remainderFreq.put(complementRemainder, 0);
				}

			}

		}

		return numberOfPairs;

	}

}
