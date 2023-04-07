package com.practice.coding.freak.array;

import java.util.Random;

/**
 * Given an array, you'll have to generate a random array. Fisher-Yates
 * algorithm
 *
 */
public class ShuffleAnArray {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String args[]) {

		int[] arr = { 2, 5, 1, 43, 6 };

		for (int i = 0; i < arr.length; i++) {
			Random random = new Random();
			int j = random.nextInt(1 + i);
			swap(arr, i, j);
		}

	}

}
