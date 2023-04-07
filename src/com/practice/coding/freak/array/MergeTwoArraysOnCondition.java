package com.practice.coding.freak.array;

import java.util.Arrays;

/**
 * Given two arrays X[] and Y[] of size m and n such that m>=n and X[] has
 * exactly n vacant cells Merge elements in their order
 * 
 * Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0} Y[] = { 1, 8, 9, 10, 15 } The
 * vacant cells in X[] is represented by 0 Output: X[] = { 1, 2, 3, 5, 6, 8, 9,
 * 10, 15 }
 * 
 */
public class MergeTwoArraysOnCondition {

	private static void addElement(int[] arr, int i, int element) {

		arr[i] = element;

	}

	public static void main(String[] args) {
		int[] X = { 0, 2, 0, 3, 0, 5, 6, 0, 0 };
		int[] Y = { 1, 8, 9, 10, 15 };
		int count = 0;
		for (int i = 0; i < X.length; i++) {
			if (X[i] == 0) {
				

				addElement(X, i, Y[count++]);
			}
		}
		Arrays.sort(X);
	}

}
