package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, find the longest subarray where the absolute
 * difference between any two elements is less than or equal to 1.
 * 
 * int[] arr = {1,1,2,2,4,4,5,5,5};
 * 
 * there are two sub arrays {1,1,2,2} {4,4,5,5,5} : The maximum length 5
 * 
 * 
 * int[] arr = {4 6 5 3 3 1};The maximum length 3
 *
 * List<Integer> arr = new ArrayList<>(Arrays.asList(4, 97, 5, 97, 97, 4, 97, 4,
 * 97, 97, 97, 97, 4, 4, 5, 5, 97, 5, 97, 99, 4, 97, 5, 97, 97, 97, 5, 5, 97, 4,
 * 5, 97, 97, 5, 97, 4, 97, 5, 4, 4, 97, 5, 5, 5, 4, 97, 97, 4, 97, 5, 4, 4, 97,
 * 97, 97, 5, 5, 97, 4, 97, 97, 5, 4, 97, 97, 4, 97, 97, 97, 5, 4, 4, 97, 4, 4,
 * 97, 5, 97, 97, 97, 97, 4, 97, 5, 97, 5, 4, 97, 4, 5, 97, 97, 5, 97, 5, 97, 5,
 * 97, 97, 97));
 */
public class PickingNumbers {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(4, 97, 5, 97, 97, 4, 97, 4, 97, 97, 97, 97, 4, 4, 5, 5, 97, 5,
				97, 99, 4, 97, 5, 97, 97, 97, 5, 5, 97, 4, 5, 97, 97, 5, 97, 4, 97, 5, 4, 4, 97, 5, 5, 5, 4, 97, 97, 4,
				97, 5, 4, 4, 97, 97, 97, 5, 5, 97, 4, 97, 97, 5, 4, 97, 97, 4, 97, 97, 97, 5, 4, 4, 97, 4, 4, 97, 5, 97,
				97, 97, 97, 4, 97, 5, 97, 5, 4, 97, 4, 5, 97, 97, 5, 97, 5, 97, 5, 97, 97, 97));
		int max_length = pickingNumbers(arr);
		System.out.println(max_length);
	}

	public static int pickingNumbers(List<Integer> arr) {

		int max_length = 0;
		int cumulative_sum[] = new int[101];

		for (int i = 0; i < arr.size(); i++) {
			cumulative_sum[arr.get(i)]++;
		}

		int length = cumulative_sum[0];
		for (int i = 1; i < cumulative_sum.length; i++) {
			length += cumulative_sum[i];
			if (length > max_length) {
				max_length = length;
			}
			length = length - cumulative_sum[i - 1];
		}

		return max_length;
	}
}
