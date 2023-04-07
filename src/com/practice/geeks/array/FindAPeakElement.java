package com.practice.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers. Find a peak element in it. An array element is a
 * peak if it is NOT smaller than its neighbours. For corner elements, we need
 * to consider only one neighbour.
 * 
 * Input: array[]= {5, 10, 20, 15} Output: 20
 * 
 * The element 20 has neighbours 10 and 15, both of them are less than 20.
 * 
 * 
 * Input: array[] = {10, 20, 15, 2, 23, 90, 67}
 * 
 * Output: 20 or 90
 *
 */
public class FindAPeakElement {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 3, 5, 6, 4 };
//		List<Integer> result = findAPeakElement(arr);

		/*
		 * Binary search
		 */
		int peakElement = findAPeakElementBinarySearch(arr);
		System.out.println(peakElement);
	}

	public static int findAPeakElementBinarySearch(int[] arr) {
		int peakIndex = 0;

		// 2, 10, 15, 20, 23, 67, 90
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if ((mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1])) {
				peakIndex = mid;
				break;
			} else if (mid != 0 && arr[mid - 1] >= arr[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}

		return peakIndex;
	}

	private static List<Integer> findAPeakElement(int[] arr) {
		List<Integer> result = new ArrayList<>();

		if (arr.length == 1) {
			result.add(arr[0]);
			return result;
		}
		// 10, 20, 15, 2, 23, 90, 67
		for (int i = 0; i <= arr.length - 2; i++) {

			if (i == 0 && arr[i] >= arr[i + 1]) {
				result.add(arr[i]);
			} else if (i == (arr.length - 2) && arr[i + 1] >= arr[i]) {
				result.add(arr[i + 1]);
			} else if (i != 0 && arr[i - 1] <= arr[i] && arr[i + 1] <= arr[i]) {
				result.add(arr[i]);
			}
		}
		return result;
	}

}
