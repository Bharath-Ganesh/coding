package com.leetcode.array;


/**
 * 209. Minimum Size Subarray Sum
 * <p>
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 * <p>
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *
 * int[] nums={12,28,83,4,25,26,25,2,25,25,25,12};
 * int target=213;
 * output=8
 *
 *
 */
public class _085_MinimumSizeSubarray {

    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int target=7;
        System.out.println(minSubArrayLen(target,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int n=nums.length;
        int minSize=n;
        int i=-1;
        int j=-1;
        int sum=0;
        while(true){
            boolean flag1=false;
            boolean flag2=false;
            while(i<n-1 && sum<target){
                sum+=nums[++i];
                flag1=true;
            }

            while(i>j && sum>=target){
                int length=(i-j);
                minSize=Math.min(length,minSize);
                sum-=nums[++j];
                flag2=true;
            }

            if(!flag1 && !flag2){
                break;
            }
        }
        return minSize;

    }
}