package com.practice.coding.freak.array;

import java.util.Arrays;

/**
 * Sort a binary array in linear time Given a binary arry : int[] arr = { 1, 0,
 * 1, 0, 1, 0, 0, 1 }; Sort it in linear time.
 */
public class SortBinaryTree {

	public static void main(String args[]) {
		int[] arr = { 1, 0, 1, 0, 1, 0, 0, 1 };
		swapZero(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void swapZero(int[] arr) {
		int count=0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0) {
				swap(arr, i, count++);
			}
		}
		
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	

}
