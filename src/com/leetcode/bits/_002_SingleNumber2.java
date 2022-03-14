package com.leetcode.bits;


/**
 * 137. Single Number II
 *
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Input: nums = [2,2,3,2]
 * Output: 3
 *
 Input: nums = [0,1,0,1,0,1,99]
 Output: 99
 */
public class _002_SingleNumber2 {

    public static void main(String[] args) {
        int[] nums={0,1,0,1,99,0,1};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int ones=0;
        int twos=0;
        for(int i=0;i<nums.length;i++){
            ones=ones^nums[i];
            ones=(ones& (~twos));

            twos=twos^nums[i];
            twos=(twos& (~ones));

        }
       return ones;

    }
}
