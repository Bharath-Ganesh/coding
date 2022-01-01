package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PrintLongestIncreasingSubsequence {

    public static void main(String[] args) {
        PrintLongestIncreasingSubsequence obj = new PrintLongestIncreasingSubsequence();
        int nums[] = {1, 2, 5, 3, 2};
        obj.LongestBitonicSequence(nums);
        int[] res = longestSubsequence(nums.length, nums);
        System.out.println(Arrays.toString(res));
    }

    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=1;
        int maxLength=0;

        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }


        int[] dp2=new int[n];
        dp2[n-1]=1;
        for(int i=n-2;i>=0;i--){
            dp2[i]=1;
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j] && dp2[i]<dp2[j]+1){
                    dp2[i]=dp2[j]+1;
                }
            }
        }

        for(int i=0;i<n;i++){
            maxLength=Math.max(dp[i]+dp2[i],maxLength);
        }

        return maxLength-1;
    }

    static int[] longestSubsequence(int size, int nums[]) {
        // code here
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxLength = 1;
        int maxIndex = -1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                    hash[i] = prev;
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }
        int[] res = new int[maxLength];

        while (maxIndex != hash[maxIndex]) {
            res[--maxLength] = nums[maxIndex];
            maxIndex = hash[maxIndex];
        }
        res[0]=nums[maxIndex];
        return res;
    }
}
