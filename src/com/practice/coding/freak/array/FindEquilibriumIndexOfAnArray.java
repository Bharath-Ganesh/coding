package com.practice.coding.freak.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Find the index such arr[0]+...arr[i-1]=arr[i+1]....arr[n-1]
 */
public class FindEquilibriumIndexOfAnArray {

	public static void main(String args[]) {
		int[] arr = { 0, -3, 5, -4, -2, 3, 1, 0 };

		int leftSubArraySum = 0;
		List<Integer> indices = new ArrayList<>();

		// `total` stores the sum of all the array elements
		int total = IntStream.of(arr).sum();

		for (int i = arr.length - 1; i >= 0; i--) {

			if (leftSubArraySum == (total - (arr[i] + leftSubArraySum))) {
				indices.add(i);
			}
			leftSubArraySum += arr[i];
		}

		indices.forEach(element -> System.out.printf("%d ", element));

	}

}
