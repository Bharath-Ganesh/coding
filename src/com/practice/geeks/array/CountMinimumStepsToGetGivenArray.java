package com.practice.geeks.array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * Consider an array with n elements and value of all the elements is zero. We
 * can perform following operations on the array.
 * 
 * 
 * Incremental operations:Choose 1 element from the array and increment its
 * value by 1.
 * 
 * Doubling operation: Double the values of all the elements of array. We are
 * given desired array target[] containing n elements. Compute and return the
 * smallest possible number of the operations needed to change the array from
 * all zeros to desired array.
 * 
 * 
 * Input: target[] = {2, 3}
 * 
 * Output: 4 To get the target array from {0, 0}, we first increment both
 * elements by 1 (2 operations), then double the array (1 operation). Finally
 * increment second element (1 more operation)
 * 
 * Input: target[] = {2, 1}
 * 
 * Output: 3 One of the optimal solution is to apply the incremental operation 2
 * times to first and once on second element.
 * 
 * 
 * int target[] = { 182, 142, 70, 145, 152, 190, 156, 188, 19, 114, 15, 82, 95,
 * 194, 9, 29, 183, 88, 107, 197, 32, 9, 121, 195, 92, 198, 53, 142, 196, 123,
 * 32, 177, 17, 53, 73, 120, 194, 180 };
 *
 */
public class CountMinimumStepsToGetGivenArray {

	public static void main(String[] args) {
		int arr[] = { 182, 142, 70, 145, 152, 190, 156, 188, 19, 114, 15, 82, 95, 194, 9, 29, 183, 88, 107, 197, 32, 9,
				121, 195, 92, 198, 53, 142, 196, 123, 32, 177, 17, 53, 73, 120, 194, 180 };
		int operations = countMinOperationsToConvertNtoZero(arr, arr.length);
		System.out.println(operations);
//		int steps = countMinOperationsToConvertNtoZero(16);
//		System.out.println(steps);

	}

	private static int countMinOperationsToConvertNtoZero(int[] target, int n) {

		int operations = 0;
		while (true) {
			int i = 0;
			int zeroCount = 0;
			for (i = 0; i < target.length; i++) {
				if (target[i] % 2 == 1) {
					break;
				} else if (target[i] == 0) {
					zeroCount++;
				}
			}

			if (zeroCount == n) {
				break;
			}

			for (int j = i; j < target.length; j++) {
				if (target[j] % 2 == 1) {
					target[j] -= 1;
					operations++;
				}
			}

			if (i == n) {
				for (int j = 0; j < target.length; j++) {
					target[j] /= 2;
				}
				operations++;
			}

		}
		return operations;
	}

}
