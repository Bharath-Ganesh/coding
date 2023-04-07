package com.practice.good.problems;

/**
 * Find the index of 0 to be replaced to get the maximum length sequence of
 * contiguous ones. You can flip the zero with 1 for k times.
 * 
 * I/P : int[] arr = { 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1 }; k= 1'
 */
public class FindIndexOfZeroToBeReplacedForLongestArray {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1 };
		int max_flip = 2;
		System.out.println(maxLengthOfSubArray(arr, max_flip));
		System.out.println(maxOnesIndex(arr, arr.length));

	}

	private static int maxLengthOfSubArray(int[] arr, int max_flip) {
		int maxLength = 0;
		int initial_pointer = -1;
		int countZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				countZero++;
			}

			while (countZero > max_flip) {
				initial_pointer++;
				if (arr[initial_pointer] == 0) {
					countZero -= 1;
				}

			}

			int length = i - initial_pointer;
			if (maxLength < length) {
				maxLength = length;
			}

		}
		return maxLength;
	}

	

	// Returns index of 0 to be replaced with 1 to get longest
	// continuous sequence of 1s. If there is no 0 in array, then
	// it returns -1.
	public static int maxOnesIndex(int arr[], int n) {
		int max_count = 0; // for maximum number of 1 around a zero
		int max_index = 0; // for storing result
		int prev_zero = -1; // index of previous zero
		int prev_prev_zero = -1; // index of previous to previous zero

		//1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1
		// Traverse the input array
		for (int curr = 0; curr < n; ++curr) {
			// If current element is 0, then calculate the difference
			// between curr and prev_prev_zero
			if (arr[curr] == 0) {
				// Update result if count of 1s around prev_zero is more
				if (curr - prev_prev_zero > max_count) {
					max_count = curr - prev_prev_zero;
					max_index = prev_zero;
				}

				// Update for next iteration
				prev_prev_zero = prev_zero;
				prev_zero = curr;
			}
		}

		// Check for the last encountered zero
		if (n - prev_prev_zero > max_count)
			max_index = prev_zero;

		return max_index;
	}

}
