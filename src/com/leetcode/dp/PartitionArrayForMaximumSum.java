package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/description/
 */
public class PartitionArrayForMaximumSum {

    public static void main(String[] args) {
        PartitionArrayForMaximumSum obj = new PartitionArrayForMaximumSum();
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(obj.maxSumAfterPartitioningTabulation(arr, k));
    }

    public int maxSumAfterPartitioningTabulation(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int index = arr.length - 1; index >= 0; index--) {
            int len = 0;
            int max = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            for (int i = index; i < Math.min(arr.length, index + k); i++) {
                max = Math.max(max, arr[i]);
                len++;
                int sum = max * len + dp[i + 1];
                maxSum = Math.max(maxSum, sum);
            }
            dp[index] = maxSum;
        }
        return dp[0];
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        return maxSumAfterPartitioning(arr, k, 0, dp);
    }

    public int maxSumAfterPartitioning(int[] arr, int k, int index, int[][] dp) {

        if (index == arr.length) return 0;

        if (dp[index][k] != -1) return dp[index][k];

        int len = 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = index; i < Math.min(arr.length, index + k); i++) {
            max = Math.max(max, arr[i]);
            len++;
            int sum1 = max * len;
            int sum = sum1 + maxSumAfterPartitioning(arr, k, i + 1, dp);
            maxSum = Math.max(maxSum, sum);
        }
        return dp[index][k] = maxSum;

    }

}
