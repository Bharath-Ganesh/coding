package com.leetcode.array;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class KthLargestElementInArray_32 {

    public static void main(String[] args) {
        int nums[] = {3,2,3,1,2,4,5,5,6};
        int k=2;
        System.out.println(findKthLargest(nums,k));

    }

    public static int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        int index=nums.length-k;
        return nums[index];

    }
}
