package com.practice.coding.freak.array;

import java.util.Arrays;

/*
 * The contigous sum is stored. 
 */
public class PrefixSumAlgorithm {

	public static void main(String args[]) {

		int[] arr = { 6, 3, -2, 4, -1, 0, -5 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			arr[i] = sum;
		}
		System.out.println(Arrays.toString(arr));
	}
}
