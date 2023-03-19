package com.leetcode.dp;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence obj = new LongestIncreasingSubsequence();
        int[] nums = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        System.out.println(obj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxLength=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxLength=dp[i];
        }
        return maxLength;
    }

//    public int lengthOfLIS(int[] nums) {
//
//        int n=nums.length;
//        int[] dp=new int[n];
//        Arrays.fill(dp,1);
//        for(int i=1;i<n;i++){
//            for(int prev=0;prev<i;prev++){
//                if(nums[i]>nums[prev] && dp[prev]+1>dp[i]){
//                    dp[i]=dp[prev]+1;
//                }
//            }
//        }
//        return dp[n-1];
//    }

//    public int lengthOfLIS(int[] arr) {
//        //10,9,2,5,3,7,101,18
//        int n = arr.length;
//
//        int length = 1;
//        for (int index = 1; index < n; index++) {
//
//            if (arr[index] > arr[length - 1]) {
//                swap(arr, index, length ++);
//            } else {
//                int pos = findIndex(arr, 0, length - 1, arr[index]);
//                swap(arr, pos, index);
//            }
//        }
//        return length;
//    }
//
//    public void swap(int[] arr, int i, int j) {
//        int temp = arr[j];
//        arr[j] = arr[i];
//        arr[i] = temp;
//    }
//
//    public int findIndex(int[] arr, int low, int high, int target) {
//
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (arr[mid] >= target) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return low;
//    }
}
