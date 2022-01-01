package com.practice.good.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of integers, return the number of (contiguous, non-empty)
 * subarrays that have a sum divisible by k.
 * 
 *
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * 
 * Output: 7 Explanation: There are 7
 * 
 * subarrays with a sum divisible by
 * 
 * k = 5: [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3],
 * [-2, -3]
 */
public class SubArraysDivisibleByK {

	public static void main(String[] args) {
		int[] arr = { -1, 2, 9 };
		int k = 2;
		int result = subarraysDivByK(arr, k);
		System.out.println(result);
	}

	public static int subarraysDivByK(int[] nums, int k) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0, 1);
		for (int num : nums) {
			// 7n-4 == 7n+3 ex : 18; 7(2)+4== 7(3)-3
			sum += num;
			int rem = sum % k < 0 ? k + (sum % k) : sum % k;
			if (map.containsKey(rem)) {
				int freq = map.get(rem);
				result += freq;
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);

		}
		return result;

	}

}
