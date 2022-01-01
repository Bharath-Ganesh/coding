package com.practice.algorithm;

import java.util.Arrays;

public class SelectionSortAlgorithm {

	public static void main(String[] args) {

		int[] arr = {2, 7, 4, 1, 8, 3};
		selectionSort(arr);
	}

	private static void selectionSort(int[] arr) {

		System.out.println(Arrays.toString(arr));
		int counter = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			int min_index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min_index]) {
					min_index = j;
				}
			}
			counter++;
			swap(arr, i, min_index);
		}

		System.out.println("Sorted after " + counter + " iterations : " + Arrays.toString(arr));

	}

	public static void swap(int[] arr, int i, int j) {

		// System.out.printf("Before swapping element at index %d && %d : Having values
		// %d , %d \n", i, j, arr[i],
		// arr[j]);
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		// System.out.printf("After swapping element at index %d && %d : Having values
		// %d , %d \n", i, j, arr[i],
		// arr[j]);
	}
}
