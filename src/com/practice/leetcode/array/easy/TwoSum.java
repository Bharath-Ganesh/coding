package com.practice.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9 Output: [0,1] Output: Because nums[0] +
 * nums[1] == 9, we return [0, 1].
 *
 */
class TwoSum {

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				 break;
			} else {
				map.put(nums[i], i);
			}
		}
		return result;

	}

}
