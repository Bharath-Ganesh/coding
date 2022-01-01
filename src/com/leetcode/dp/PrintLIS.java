package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintLIS {

    public static void main(String[] args) {
        PrintLIS obj=new PrintLIS();
        int[] nums={0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        ArrayList<Integer> integerArrayList = obj.longestIncreasingSubsequence(nums.length, nums);
        System.out.println(integerArrayList);
    }

    public ArrayList<Integer> longestIncreasingSubsequence(int N, int nums[]){
        // Code here
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int maxLength=1;
        int[] prev=new int[n];
        Arrays.fill(prev,-1);
        int index=-1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(maxLength<dp[i]){
                maxLength=dp[i];
                index=i;
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        if(maxLength==1){
            res.add(nums[0]);
            return res;
        }

        while(index!=-1){
            res.add(nums[index]);
            index=prev[index];
        }
        Collections.sort(res);
        return res;

    }
}
