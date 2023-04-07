package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up
 * to a multiple of k, or false otherwise.
 *
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 *
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 */
public class _065_ContinuousSubarraySum {

    public static void main(String[] args) {
        int[] arr={23,2,6,4,7};
        int k=6;
        System.out.println(checkSubarraySum(arr,k));
    }

    // O(n)
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap();
        map.put(0,-1);
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if(map.containsKey(sum)){
                if(i-map.get(sum)>1)
                    return true;
            }else {
                map.put(sum,i);
            }
        }
        return false;
    }


}
