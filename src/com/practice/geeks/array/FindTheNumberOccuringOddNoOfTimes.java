package com.practice.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Input : arr = {1, 2, 3, 2, 3, 1, 3} Output : 3
 * 
 * Input : arr = {5, 7, 2, 7, 5, 2, 5} Output : 5
 *
 */
public class FindTheNumberOccuringOddNoOfTimes {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 2, 3, 1, 3 };
		int oddNumberOfElement = findOddFreqElement(arr);
		System.out.println(oddNumberOfElement);
		
		/**
		 * The problem can be solved best with XOR approach
		 */

	}

	/**
	 * O(n)
	 */
	private static int findOddFreqElement(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				int freq = map.get(arr[i]);
				map.put(arr[i], freq + 1);
			} else {
				map.put(arr[i], 1);
			}
		}

		for (Integer number : map.keySet()) {
			int freq = map.get(number);
			if ((freq % 2) != 0) {
				return number;
			}
		}

		return -1;
	}

}
