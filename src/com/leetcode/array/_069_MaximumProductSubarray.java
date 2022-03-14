package com.leetcode.array;

/**
 * 152. Maximum Product Subarray
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class _069_MaximumProductSubarray {

    public static void main(String[] args) {
        long[] nums = {3, 5, -2, 1, 0, -4, -2};
        System.out.println(maxProductLeetcode(nums));
    }

    /*
        SINGLE PASS
     */
    public static long maxProductLeetcode(long[] arr) {
        long currMax = arr[0];
        long currMin = arr[0];
        long res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            long temp = currMax;
            currMax = Math.max(Math.max(currMax * arr[i], currMin * arr[i]), arr[i]);
            currMin = Math.min(Math.min(temp * arr[i], currMin * arr[i]), arr[i]);
            if (res < currMax) {
                res = currMax;
            }
        }
        return res;
    }

    /*
        2 PASS
     */
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currPdt = 1;
        for (int i = 0; i < nums.length; i++) {
            currPdt = currPdt * nums[i];
            max = Math.max(currPdt, max);
            if (currPdt == 0) {
                currPdt = 1;
            }
        }
        currPdt = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            currPdt = currPdt * nums[i];
            max = Math.max(currPdt, max);
            if (currPdt == 0) {
                currPdt = 1;
            }
        }

        return max;
    }
}
