package com.practice.algorithm;

import java.util.HashMap;
import java.util.Map;

/*
 * Find pair with given sum in an array
 */
public class GivenSumInArray {

	public static void main(String args[]) {
		extracted();

	}

	public static void extracted() {
		int[] arr = { 2, 6, 2, 8, 5 };
		int sum = 14;

		Map<Integer, Integer> arrayMap = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			if (arrayMap.containsKey(sum - arr[i])) {
				System.out.println("index at " + arrayMap.get((sum - arr[i])) + ": " + i);
				break;
			}
			arrayMap.put(arr[i], i);
		}
	}

}
