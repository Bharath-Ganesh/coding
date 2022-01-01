package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

// int[] arr={77,22,56,11,45,34,78,29,23,55}
//int[] arr = { 9, 56, 25, 52, 72, 44, 80, 36, 71, 55 };
public class PairsDivisibleByK {

	public static int countPairs(int[] arr, int k, Map<Integer, Integer> map) {
		int countPairs = 0;
		for (int element : map.keySet()) {
			int rem = element % k;
			if (rem == 0) {
				if (map.get(rem) % 2 == 0) {
					countPairs += map.get(rem) / 2;
				} else {
					return 0;
				}
			} else if (2 * rem == k) {
				if (map.get(rem) % 2 == 0) {
					countPairs += map.get(rem) / 2;
				} else {
					return 0;
				}
			} else {

				int frequency = map.get(k - rem);
				if (frequency != (map.getOrDefault(rem, 0))) {
					return 0;
				} else {
					countPairs += frequency / 2;
				}

			}
		}
		return countPairs;
	}

	private static void hashMapApproach(int[] arr, int count, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int element : arr) {
			int remainder = element % k;
			int oldRemainderFrequency = map.getOrDefault(remainder, 0);
			map.put(remainder, oldRemainderFrequency + 1);

		}
		int pairs = countPairs(arr, k, map);
		System.out.println(pairs);

	}

	public static void primitiveApproach(int[] arr, int count, int k) {
		int sum;
		for (int i = 0; i < arr.length - 1; i++) {
			sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if (sum % k == 0) {
					count++;
					System.out.println(arr[i] + " && " + arr[j]);
					sum -= arr[j];
				} else {
					sum -= arr[j];
				}
			}
		}
	}

	public static void main(String[] args) {

		// int[] arr = { 77, 22, 56, 11, 45, 34, 78, 29, 93, 23, 55 };
		int[] arr = { 9, 56, 25, 52, 72, 36, 71, 55 };
		int count = 0;
		int k = 8;
		// primitiveApproach(arr, count, k);
		hashMapApproach(arr, count, k);
	}

}
