package com.leetcode.dp;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence obj = new NumberOfLongestIncreasingSubsequence();
        int nums[] = {1, 5, 4, 3, 2, 6, 7, 10, 8, 9};
        System.out.println(obj.findNumberOfLIS(nums));

    }

    public int findNumberOfLIS(int[] nums) {

        int n=nums.length;
        int[] dp=new int[n];
        int[] count=new int[n];
        int maxLength=1;
        Arrays.fill(dp,1);
        Arrays.fill(count,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }else if(dp[j]+1==dp[i]){
                        count[i]+=count[j];
                    }
                }
            }
            if(maxLength < dp[i]) maxLength=dp[i];
        }

        int cnt=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxLength){
                cnt+=count[i];
            }
        }
        return cnt;

    }
}
