package com.practice.geeks.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of integers, count number of subarrays (of size more than one)
 * that are strictly increasing.
 * 
 * Expected Time Complexity : O(n) Expected Extra Space: O(1)
 * 
 * Input: arr[] = {1, 4, 3}
 * 
 * Output: 1 There is only one subarray {1, 4}
 * 
 * Input: arr[] = {1, 2, 3, 4}
 * 
 * Output: 6 There are 6 subarrays {1, 2}, {1, 2, 3}, {1, 2, 3, 4} {2, 3}, {2,
 * 3, 4} and {3, 4}
 *
 */
public class CountStrictlyIncreasingSubArray {

	// 1, 2 ,3, 4 ,5 ; n= 4
	// {1,2} {1,2,3} {1,2,3,4} {1,2,3,4,5} {2,3} {2,3,4} {2,3,4,5} {3,4} {3,4,5}
	// {4,5}
	// ( n* (n+1) )/ 2 ; (5 * 4 )/ 2

	// {1 ,4 , 3 , 5, 6}
	// {1,4 } {3,5} {3,5,6} {5,6}
	public static void main(String[] args) {
		int[] arr = { 9, 8, 5, 5 };
		int count = findStrictlyIncreasing(arr);
		System.out.println(count);

		List<Integer> subArrayList = findAllSubArrays(arr);
		System.out.println(subArrayList.stream().collect(Collectors.toList()));
	}

	private static int findStrictlyIncreasing(int[] arr) {
		int increasingSubArray = 0;
		int maxIncreasing = -1;
		int increment = 1;
		// 1, 2, 5, 4
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i]) {
				increment++;
			} else {
				increment = 1;
			}
			if (maxIncreasing < increment) {
				maxIncreasing = increment;
			}
		}
		increasingSubArray = (maxIncreasing * (maxIncreasing - 1)) / 2;
		return increasingSubArray;
	}

	private static List<Integer> findAllSubArrays(int[] arr) {
		List<Integer> subArrayList = new ArrayList<>();

		//
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				String num = "";
				for (int k = i; k <= j; k++) {
					num += arr[k];
				}
				subArrayList.add(Integer.parseInt(num));
			}
		}
		return subArrayList;

//		for (int i = 0; i < arr.length; i++) {
//			String element = "";
//			for (int j = i; j < arr.length; j++) {
//				element += arr[j] + "";
//				subArrayList.add(Integer.parseInt(element));
//			}
//
//		}
//		return subArrayList;
	}

}
