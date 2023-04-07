package com.practice.coding.freak.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Provided with a array and a given sum . You have to find longest subarray
 * with the given sum int arr[] = { 3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6,
 * 2, 1 }; int given_sum = 5;
 */
public class CountSubArrayWithGivenSum {

	public static void main(String args[]) {
		// { 0, 1, 2, 3 , 4 , 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }
		int arr[] = { 3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1 };
		// { 3 , 12, 10, 14 , 15, 8, 10, 16, 11, 19, 16, 9, 15, 17, 18}
		int given_sum = 5;
		countPairs(arr, given_sum);
		int count = squares(17, 24);
		System.out.println(count);
	}

	private static void countPairs(int[] arr, int element) {
		int sum = 0;
		int length = 0;
		int initial_index = 0;
		int end_index = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (map.containsKey(sum - element) && length < (i - map.get(sum - element))) {
				initial_index = map.get(sum - element) + 1;
				end_index = i + 1;
				length = end_index - initial_index;
			} else {
				map.put(sum, i);
			}

		}
		System.out.println("[" + initial_index + "," + end_index + "]");
	}

	public static int squares(int a, int b) {

		int counter = 0;

		int min = (int) Math.ceil(Math.sqrt(a));
		int max = (int) Math.floor(Math.sqrt(b));

		for (int i = min; i <= max; i++) {
			int square = i * i;
			if (square >= a && square <= b)
				counter++;
		}

		return counter;

	}
}
