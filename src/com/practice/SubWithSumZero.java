package com.practice;

import java.util.HashMap;
import java.util.Map;

public class SubWithSumZero {

	public static void main(String[] args) {
		int[] arr = { 4, -6, 3, -1, 5, 4, 2, -6, 6, -6, 6 };
		findSubArrayWithZeroSum(arr);
		findLargestSubArrayWithZeroSum(arr);

	}

	private static void findSubArrayWithZeroSum(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			// if the sum is seen before it indicates that the sum between the elements is
			// zero
			if (map.containsKey(sum)) {
				flag = false;
				System.out.printf("Elements found at index :  %d  &  : %d  length : %d \n", (map.get(sum) + 1), i,
						(i - (map.get(sum))));
			} else {
				map.put(sum, i);
			}

		}
		if (flag) {
			System.out.println("Sub array does not exist");
		}

	}

	private static void findLargestSubArrayWithZeroSum(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum = 0;
		int maxLength = 0;

		int initialIndex = 0;
		int finalIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (map.containsKey(sum)) {
				if ((i - map.get(sum)) > maxLength) {
					maxLength = i - map.get(sum);
					initialIndex = map.get(sum);
					finalIndex = i;
				}
			} else {
				map.put(sum, i);
			}

		}
		System.out.printf("Elements found at index :  %d  &  : %d  \n", initialIndex + 1, finalIndex);
	}
}
