package com.practice.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two binary arrays arr1[] and arr2[] of same size n. Find length of the
 * longest common span (i, j)
 * 
 * where j >= i such that arr1[i] + arr1[i+1] + …. arr1[j] = arr2[i] + arr2[i+1]
 * + …. + arr2[j].
 * 
 * Expected time complexity is Θ(n).
 * 
 * arr1[i]+arr1[i+1] + ... arr1[j] == arr2[i]+arr2[i+1] + ... arr1[j]
 * 
 * Input: arr1[] = {0, 1, 0, 0, 0, 0};
 * 
 * arr2[] = {1, 0, 1, 0, 0, 1};
 * 
 * Output: 4 The longest span with same sum is from index 1 to 4.
 *
 */
public class LongestSpanWithSameSumInTwoBinaryArray {

	public static void main(String[] args) {

		// 			-1, 1, -1,0, 0, 1, 0, 1,-1,0 ,-1,-1
		int arr1[] = { 0, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0 };
		int arr2[] = { 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1 };
		int message = findMaxLengthSubArraySum(arr1, arr2);
		int maxLength = countOfSubArrayUsingHashMap(arr1, arr2);
		System.out.printf("Hashmap : %d \n", maxLength);
		// countOfContgiousArrayWithEqualZeroAndOne();
		System.out.printf("Brute force :  %d \n", message);

	}

	private static void countOfContgiousArrayWithEqualZeroAndOne() {

		int max_length = 0;
		int[] arr = { -1, 1, -1, 0, 0, -1 };
		Map<Integer, Integer> mapFreq = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (mapFreq.containsKey(sum)) {
				max_length = Math.max((i - mapFreq.get(sum)), max_length);
			} else {
				mapFreq.put(sum, i);
			}
		}
		System.out.println(max_length);

	}

	private static int countOfSubArrayUsingHashMap(int[] arr1, int[] arr2) {

		// Find difference between the two
		int n = arr1.length;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = arr1[i] - arr2[i];

		Map<Integer, Integer> mapFreq = new HashMap<>();
		int sum = 0;
		int max_length = 0;
		mapFreq.put(0, -1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (mapFreq.containsKey(sum)) {
				max_length = Math.max((i - mapFreq.get(sum)), max_length);
			} else {
				mapFreq.put(sum, i);
			}
		}

		return max_length;
	}

	private static int findMaxLengthSubArraySum(int[] arr1, int[] arr2) {

		int max_length = 0;
		for (int i = 0; i < arr2.length; i++) {
			int countOneFirstArray = 0;
			int countOneSecondArray = 0;
			for (int index = i; index < arr2.length; index++) {

				if (arr1[index] == 1)
					countOneFirstArray++;

				if (arr2[index] == 1)
					countOneSecondArray++;

				if (countOneFirstArray == countOneSecondArray) {
					int length = index - i + 1;
					if (length > max_length) {
						max_length = length;
					}
				}

			}

		}

		return max_length;
	}

}
