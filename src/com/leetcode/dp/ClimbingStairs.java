package com.leetcode.dp;

import java.util.Arrays;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {


    public static void main(String[] args) {
        int n = 42;
        ClimbingStairs obj = new ClimbingStairs();
        int ways = obj.climbStairsTabulation(n);
        System.out.println(ways);
    }

    public int climbStairsTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return climbStairs(n,dp);
    }

    public int climbStairs(int n,int[] dp) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int left=climbStairs(n-1,dp);
        int right=climbStairs(n-2,dp);
        int totalWays=left+right;
        dp[n]=totalWays;
        return totalWays;
    }
}
