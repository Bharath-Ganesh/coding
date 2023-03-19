package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/
 */
public class MinimumCostToCutAStick {

    public static void main(String[] args) {
        MinimumCostToCutAStick obj = new MinimumCostToCutAStick();
        int[] arr = {1, 5, 3};
        int cuts = 7;
        System.out.println(obj.minCost(cuts, arr));
    }

    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] temp = new int[c + 2];
        int length = temp.length;
        for (int i = 0; i < c; i++) {
            temp[i + 1] = cuts[i];
        }
        temp[length - 1] = n;
        //Arrays.sort(temp);
        int[][] dp = new int[c + 1][c + 1];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        return minCost(temp, dp, 1, c);
    }

    public int minCost(int[] temp, int[][] dp, int i, int j) {

        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = temp[j + 1] - temp[i - 1] + minCost(temp, dp, i, index - 1) + minCost(temp, dp, index + 1, j);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }
}
