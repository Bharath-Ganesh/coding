package com.practice.mycodeschool.ds;

import java.util.Arrays;

public class BubbleSortAlgorithm {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 3, 65, 32, 89, 0, 1, -1 };
		// array length = 9; Total 8 iterations
		// i=0 { 2, 3, 4, 32, 65, 0, 1, 43, 89 }; 89 sorted j < 8 => j=7
		// i=1 { 2, 3, 4, 32, 0, 1, 43, 65, 89 }; 89 , 65 sorted j < 7 => j=6
		// i=2 { 2, 3, 4, 0, 1, 32, 43, 65, 89 }; 89 , 65 , 43 sorted j < 6 => j=5
		// i=3 { 2, 3, 0, 1, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 sorted j < 5 => j=4
		// i=4 { 2, 0, 1, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 , 4 sorted j < 4 =>
		// j=3
		// i=5 { 0, 1, 2, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 , 4 , 3 sorted j < 3
		// => j=2
		// i=6 { 0, 1, 2, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 , 4 , 3 , 2 sorted j
		// < 2 => j=1
		// i=7 { 0, 1, 2, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 , 4 , 3 , 2,1 sorted
		// j < 1 => j=0
		bubbleSortAlgorithm(arr);

	}

	private static void bubbleSortAlgorithm(int[] arr) {

		System.out.println(Arrays.toString(arr));
		int flag = 0;
		int counter = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - (i + 1); j++) {
				counter++;
				if (i != j && arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}

		}
		System.out.println("Sorted after " + counter + " iterations : " + Arrays.toString(arr));
	}

	public static void swap(int[] arr, int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
