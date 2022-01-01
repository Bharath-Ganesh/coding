package com.leetcode.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/target-sum/
 */
public class TargetSum {
    private static int mod = (int) Math.pow(10,9)+7;

    public static void main(String[] args) {
        TargetSum obj = new TargetSum();
        int[] nums = {3,5,6,7};
        int target = 9;
       // System.out.println(obj.findTargetSumWays(nums, target));
        System.out.println(obj.perfectSum(nums, nums.length, target));

    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int requiredSum = (sum + target);
        if (requiredSum % 2 == 1 || requiredSum < 0) {
            return 0;
        }
        requiredSum /= 2;
        return isSubsetSum(nums, requiredSum);
    }


    private int isSubsetSum(int arr[], int sum) {
        // code here
        int N = arr.length;
        int[][] dp = new int[N + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= sum; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (j >= arr[i - 1]) {
                    take = dp[i - 1][j - arr[i - 1]];
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[N][sum];
    }


    public int perfectSum(int arr[], int n, int sum) {
        // Your code goes here
        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                int notTake = (dp[i - 1][j]);
                int take = 0;
                if (j >= arr[i - 1]) {
                    take=(dp[i - 1][j - arr[i - 1]]);
                }
                dp[i][j] = (take + notTake) % mod;
            }
            System.out.println(1);
        }
        return dp[n][sum] % mod;
    }

//    public int findTargetSumWays(int[] nums, int target) {
//        int n = nums.length;
//        int sum = IntStream.of(nums).sum();
//        int[][] dp = new int[n][target + 1];
//        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
//        return countNumberOfSubsetsWithGivenSumWithMemoization(nums.length - 1, nums, dp, target);
//    }
//
//
//    public int countNumberOfSubsetsWithGivenSum(int index, int[] nums, int[][] dp, int target) {
//
//        if (index < 0 && target == 0) return 1;
//        if (index < 0) return 0;
//
//        int notTake = countNumberOfSubsetsWithGivenSum(index - 1, nums, dp, target - nums[index]);
//        int take = countNumberOfSubsetsWithGivenSum(index - 1, nums, dp, target + nums[index]);
//
//        return notTake + take;
//    }
//
//    public int countNumberOfSubsetsWithGivenSumWithMemoization(int index, int[] nums, int[][] dp, int target) {
//
//        if (target < 0 || target >= dp[0].length) return 0;
//
//        if (index == 0 && target == 0) return 1;
//        if (index == 0) return 0;
//
//        if (dp[index][target] != -1) {
//            return dp[index][target];
//        }
//
//
//        int subtract = countNumberOfSubsetsWithGivenSumWithMemoization(index - 1, nums, dp, target - nums[index]);
//        int add = countNumberOfSubsetsWithGivenSumWithMemoization(index - 1, nums, dp, target + nums[index]);
//        return dp[index][target] = add + subtract;
//    }
}
