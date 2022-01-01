package com.practice.geeks.array;

import java.util.Arrays;

/**
 * Given an array of integers print the missing elements that lie in range 0-99.
 * If there are more than one missing, collate them, otherwise just print the
 * number. Note that the input array may not be sorted and may contain numbers
 * outside the range [0-99], but only this range is to be considered for
 * printing missing elements.
 * 
 * Input: {88, 105, 3, 2, 200, 0, 10}
 * 
 * Output: 1 4-9 11-87 89-99
 *
 */
public class PrintMissingElementsThatLieInRange {

	public static void main(String[] args) {
		int[] arr = { 88, 99, 105, 3, 2, 200, 0, 10 };
		printMissingElementsThatLieInRange(arr);
	}

	private static void printMissingElementsThatLieInRange(int[] arr) {
		Arrays.sort(arr);

		// 0 , 2, 3, 10, 88 , 105 , 200
		for (int i = 1; i < arr.length; i++) {

			int diff = arr[i] - arr[i - 1];
			if (diff == 2) {
				System.out.println(arr[i] - 1);
			} else if (arr[i] >= 100) {
				int prev = arr[i - 1] + 1;
				int last = 99;
				System.out.println(prev + "-" + last);
				break;
			} else if (diff > 2) {
				int prev = arr[i - 1] + 1;
				int last = arr[i] - 1;
				System.out.println(prev + "-" + last);
			}
		}

	}

	/**
	 * 
	 * O(k)
	 */
	private static void printMissingElementsThatLieInRangeUsingCount(int[] arr) {
		int LIMIT = 100;

		boolean seen[] = new boolean[LIMIT];

		// Initialize all number from 0 to 99 as NOT seen
		for (int i = 0; i < LIMIT; i++)
			seen[i] = false;
		// Mark present elements in range [0-99] as seen
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < LIMIT)
				seen[arr[i]] = true;
		}
		// Print missing element
		int i = 0;

		while (i < LIMIT) {
			if (seen[i] == false) {
				int j = i + 1;
				while (j < LIMIT && seen[j] == false) {
					j++;
				}
				int last_index = j - 1;
				if (i == last_index)
					System.out.println(i);
				else
					System.out.println(i + "-" + last_index);
				i = j;
			} else
				i++;
		}
	}

}
