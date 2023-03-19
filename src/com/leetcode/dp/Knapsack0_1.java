package com.leetcode.dp;

/**
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 */
public class Knapsack0_1 {

    public static void main(String[] args) {
        int values[] = {1, 2, 3};
        int weight[] = {4, 5, 1};
        int w = 4;
        System.out.println(knapSack(w, weight, values, values.length));
    }


    static int knapSack(int weight, int wt[], int val[], int n) {


        int[][] dp = new int[n][weight + 1];

        for (int i = wt[0]; i <= weight; i++) {
            dp[0][i] = val[0];
        }


        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= weight; j++) {
                int currW = wt[i];
                int currV = val[i];
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                if (j >= currW) {
                    take = currV + dp[i-1][j - currW];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }
        return dp[n - 1][weight];
    }
}
