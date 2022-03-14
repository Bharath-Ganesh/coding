package com.leetcode.array;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class _068_ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        int product=1;
        for(int i=0;i<nums.length;i++){
            product=product*nums[i];;
            res[i]=product;
        }

        int rightSum=nums[nums.length-1];
        res[nums.length-1]=res[nums.length-2];
        for(int i=nums.length-2;i>=1;i--){
            res[i]=res[i-1]*rightSum;
            rightSum*=nums[i];
        }

        res[0]=rightSum;
        return res;
    }
}
