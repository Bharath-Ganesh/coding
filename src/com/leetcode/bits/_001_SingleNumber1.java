package com.leetcode.bits;

/**
 * 136. Single Number
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Input: nums = [2,2,1]
 * Output: 1
 */
public class _001_SingleNumber1 {

    public static void main(String[] args) {
        int nums[]={2,2,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            num=(num^nums[i]);
        }
        return num;
    }
}
