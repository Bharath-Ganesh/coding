package com.practice.coding.freak.array;

public class FindMaxSumOfArrayWithGivenWindow {

	public static void main(String args[]) {
		int[] arr = { 1, 9, 6, -2, 0, 3, -1, 2 };
		int window = 4;
		System.out.println(brureForceApproach(arr, window));

	}

	public static int slidingWindowApproach(int[] arr, int window) {
		int max_sum = 0;
		int window_sum = 0;

		for (int i = 0; i < window; i++) {
			window_sum += arr[i];
		}

		for (int i = window; i < arr.length; i++) {
			if (window_sum > max_sum) {
				max_sum = window_sum;
			}
			window_sum += arr[i] - arr[i - window];
		}
		return max_sum;

	}

	public static int brureForceApproach(int[] arr, int window) {
		int max_sum = 0;
		int window_sum = 0;

		for (int i = 0; i <= arr.length - window; i++) {
			window_sum = 0;
			for (int j = i; j < i + window; j++) {
				window_sum += arr[j];
			}
			if (window_sum > max_sum) {
				max_sum = window_sum;
			}
		}
		return max_sum;

	}

}
