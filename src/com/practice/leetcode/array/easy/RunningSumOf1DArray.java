package com.practice.leetcode.array.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Input: nums = [1,1,1,1,1] Output: [1,2,3,4,5] Explanation: Running sum is
 * obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
 *
 */
public class RunningSumOf1DArray {

	public static void main(String args[]) {
		// Scanner sc = new Scanner(System.in);
		// String[] numbers = sc.next().split(",");
		// int nums[] = new int[numbers.length];
		// int count = 0;
		// for (String num : numbers) {
		// nums[count++] = Integer.parseInt(num);
		// }
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(runningSumStream(nums)));
	}

	/**
	 * Stream
	 */
	public static int[] runningSumStream(int[] nums) {
		return IntStream.range(0, nums.length).map(i -> i == 0 ? nums[i] : (nums[i] += nums[i - 1])).toArray();
	}

	/*
	 * My solution
	 */
	public int[] runningSum(int[] nums) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			nums[i] = sum;
		}
		return nums;

		// best approach
		// nums[i]+=nums[i-1];
	}

}