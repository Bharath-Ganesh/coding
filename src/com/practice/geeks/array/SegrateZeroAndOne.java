package com.practice.geeks.array;

import java.util.Arrays;

/**
 * You are given an array of 0s and 1s in random order. Segregate 0s on left
 * side and 1s on right side of the array. Traverse array only once.
 * 
 * Input array = [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
 * 
 * Output array = [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
 */
public class SegrateZeroAndOne {

	public static void main(String[] args) {
		// 0 0 0 0 0 1 1 1 1 1
		int[] arr = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1 };
		segrateZeroAndOne(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void segrateZeroAndOne(int[] arr) {
		int zeroIndex = 0;
		int counter = 0;
		while (counter <= arr.length - 1) {
			if (arr[counter] == 0) {
				swap(arr, counter, zeroIndex);
				zeroIndex++;
			}
			counter++;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
