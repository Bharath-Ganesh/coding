package com.leetcode.bits;

import java.util.Arrays;

/**
 * 260. Single Number III
 * <p>
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once. You can return the answer in any order.
 * <p>
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 * <p>
 * <p>
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 */
public class _003_SingleNumber3 {

    public static void main(String[] args) {
        int[] nums = {7, 6, 25, 4, 25, 15, 15, 7, 4, 3, 29, 6};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {
        // Code here


        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result=(result^nums[i]);
        }   // Code here
        int rmsb = (result & - result);

        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((rmsb & nums[i]) != 0) {
                num1 = (num1 ^ nums[i]);
            } else {
                num2 = (num2 ^ nums[i]);
            }
        }
        int[] op = new int[2];
        op[0] = num1;
        op[1] = num2;
        Arrays.sort(op);
        return op;
    }


}
