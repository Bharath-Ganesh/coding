package com.practice.algorithm;

import java.util.Arrays;

/**
 * Given an array . Sort the array using bubble sort algorithm o(n^2)
 */
public class BubbleSortAlgorithm {

	public static void main(String args[]) {
		int[] arr = { 2, 4, 3, 65, 32, 89, 0, 1, 43 };
		// { 2, 3, 4, 32, 65, 0, 1, 43, 89 };
		// { 2, 3, 4, 32, 0, 1, 43, 65, 89 };89 sorted
		// { 2, 3, 4, 0, 1, 32, 43, 65, 89 }; 89 , 65 sorted
		// { 2, 3, 0, 1, 4, 32, 43, 65, 89 }; 89 , 65 , 43 sorted
		// { 2, 0, 1, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 sorted
		// { 0, 1, 2, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 , 4 sorted
		// { 0, 1, 2, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 , 4 , 3 sorted
		// { 0, 1, 2, 3, 4, 32, 43, 65, 89 }; 89 , 65 , 43 , 32 , 4 , 3 , 2 sorted
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j-1] > arr[j]) {
					swap(arr, j, j-1);
				}

			}
		}

		System.out.println(Arrays.toString(arr));


		int[] arr2 = { 2, 4, 3, 65, 32, 89, 0, 1, 43 };
		for(int i=0;i<arr2.length;i++){
			int minIndex = i;
			for(int j=i+1;j<arr2.length;j++){
				if(arr2[minIndex]>arr2[j]){
					minIndex = j;
				}
			}
			swap(arr2, minIndex, i);
		}
		System.out.println(Arrays.toString(arr2));


		int[] arr3 = { 2, 4, 3, 65, 32, 89, 0, 1, 43 };
		for(int i=1; i<arr3.length; i++){

			int hole = i;
			int element = arr3[hole];

			while(hole>0 && arr3[hole-1]>element){
				arr3[hole] = arr3[hole-1];
				hole--;
			}
			arr3[hole] = element;
		}
		System.out.println(Arrays.toString(arr3));




	}



	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
