package com.leetcode.bits;

import java.util.Arrays;

/**
 * 260. Single Number III
 *
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once. You can return the answer in any order.
 *
 * You must write an algorithm that runs in linear runtime complexity and uses only constant extra space.
 *
 *
 * Input: nums = [1,2,1,3,2,5]
 * Output: [3,5]
 * Explanation:  [5, 3] is also a valid answer.
 */
public class _003_SingleNumber3 {

    public static void main(String[] args) {
        int[] nums={1,2,1,3,2,5};
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums)
    {
        // Code here
        int result=0;
        for(int i=0;i<nums.length;i++){
            result=(result^nums[i]);
        }
        System.out.println(result);
        int rmsb=(result & -result);



        int firstNum=0;
        int secondNum=0;
        for(int num : nums){
            if((rmsb & num)==0){
                firstNum=(firstNum^num);
            }else{
                secondNum=(secondNum^num);
            }
        }
        int[] res=new int[2];
        res[0]=firstNum;
        res[1]=secondNum;
        return res;
    }


}
