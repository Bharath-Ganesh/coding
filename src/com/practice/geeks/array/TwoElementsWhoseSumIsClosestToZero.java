package com.practice.geeks.array;

import java.util.Arrays;

/**
 * 
 * An Array of integers is given, both +ve and -ve. You need to find the two
 * elements such that their sum is closest to zero.
 * 
 * int arr[] = {1, 60, -10, 70, -80, 85};
 * 
 * output : -80 and 85
 *
 */
public class TwoElementsWhoseSumIsClosestToZero {

	public static void main(String[] args) {
		int[] arr = { 1,2,3,4 };
		minAbsSumPair(arr);
	}

	public static void twoElementsWhoseSumIsClosestToZero(int[] arr) {
		int min = Integer.MAX_VALUE;
		int index1 = -1;
		int index2 = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = Math.abs(arr[i] + arr[j]);
				if (sum < min) {
					min = sum;
					index1 = i;
					index2 = j;
				}
			}
		}
		System.out.println(arr[index1] + " " + arr[index2]);
	}

	public static void minAbsSumPair(int arr[]) {
		int min = Integer.MAX_VALUE;
		int index1 = -1;
		int index2 = -1;
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		// -80, -65, -5, 6, 70
		while (left < right) {
			int sum = arr[left] + arr[right];

			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				index1 = left;
				index2 = right;
			}

			if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(arr[index1] + " " + arr[index2]);
	}

}
