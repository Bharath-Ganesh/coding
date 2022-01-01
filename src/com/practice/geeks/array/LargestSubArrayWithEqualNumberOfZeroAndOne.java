package com.practice.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array containing only 0s and 1s, find the largest subarray which
 * contains equal no of 0s and 1s. The expected time complexity is O(n).
 *
 *
 * Input: arr[] = {1, 0, 1, 1, 1, 0, 0} Output: 1 to 6 (Starting and Ending
 * indexes of output subarray)
 * 
 * Input: arr[] = {1, 1, 1, 1} Output: No such subarray
 * 
 * Input: arr[] = {0, 0, 1, 1, 0} Output: 0 to 3 Or 1 to 4
 * 
 * 	int arr[] = { 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
 * 
 * output : 12
 */
public class LargestSubArrayWithEqualNumberOfZeroAndOne {

	public static void main(String[] args) {
		//      0    -1 -2 -1 -2 -1 -2 -1 0  -1 -2 -1  0  1   			
		int arr[] = { 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1 };
		
		// 1, 0, 1, 2, 3, 2, 1
		// 1, 0, 1, 1, 1, 0, 0
		int length = longestSubArray(arr);
		int totalCount = longestSubArrayHavingEqualZeroAndOne(arr);
		System.out.println(totalCount);
		System.out.println(length);
	}

	private static int longestSubArrayHavingEqualZeroAndOne(int[] arr) {
		int maxLength = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				sum += -1;
			} else {
				sum += 1;
			}
			if (map.containsKey(sum)) {
				int length = i - map.get(sum);
				if (maxLength < length) {
					maxLength = length;
				}
			} else {
				map.put(sum, i);
			}
		}
		return maxLength;
	}

	/**
	 * O(n^2)
	 */
	private static int longestSubArray(int[] arr) {

		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			int countOne = 0;
			int countZero = 0;
			for (int j = i; j < arr.length; j++) {

				if (arr[j] == 0) {
					countZero++;
				} else {
					countOne++;
				}
				if (countOne == countZero) {
					int currLength = j - i + 1;
					if (currLength > maxLength) {
						maxLength = currLength;
					}
				}
			}
		}
		return maxLength;
	}
}
