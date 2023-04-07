package com.practice.leetcode.array.easy;

import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value
 * in-place and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * Input: nums = [3,2,2,3], val = 3 Output: 2, nums = [2,2] Explanation: Your
 * function should return length = 2, with the first two elements of nums being
 * 2. It doesn't matter what you leave beyond the returned length. For example
 * if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will
 * be accepted.
 *
 */
class RemoveElement {

	public static void main(String args[]) {
		int nums[] = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		System.out.println(removeElement(nums, val));
		System.out.println(Arrays.toString(nums));
	}

	public static int removeElement(int[] nums, int val) {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[n++] = nums[i];
			}

		}
		return (n);
	}

	// Best solution
//	public static int removeElement(int[] A, int elem) {
//		int l = A.length;
//		for (int i = 0; i < l; i++) {
//			if (A[i] == elem) {
//				A[i--] = A[l-- - 1];
//			}
//		}
//		return l;
//	}

//	My solution
//	public static int removeElement(int[] nums, int val) {
//		int count = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == val) {
//				for (int j = i + 1; j < nums.length; j++) {
//					if (nums[i] != nums[j]) {
//						swap(nums, i, j);
//						count++;
//						break;
//					}
//				}
//			}
//		}
//		return nums.length - count;
//	}
//
//	// we can only call static method from a static method
//	public static void swap(int[] nums, int i, int j) {
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//	}

}
