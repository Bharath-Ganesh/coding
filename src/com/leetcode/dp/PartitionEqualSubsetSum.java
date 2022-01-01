package com.leetcode.dp;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println(obj.canPartitionDP(nums));
    }

    public boolean canPartitionDP(int[] nums) {

        int sum = IntStream.of(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];
        dp[0][nums[0]] = true;
        for (int i = 0; i < nums.length; i++) dp[i][0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int val = nums[i];
                boolean take = dp[i - 1][j];
                boolean notTake = false;
                if (j >= val) {
                    notTake = dp[i - 1][j - val];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[n - 1][sum];
    }

    public boolean canPartition(int[] nums) {

        int sum = IntStream.of(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        int[][] dp = new int[n][sum + 1];
        Arrays.stream(dp).forEach(x -> Arrays.fill(x, -1));
        return findSubsetExist(nums, nums.length - 1, sum, dp) == 0 ? false : true;
    }

    public int findSubsetExist(int[] nums, int index, int sum, int[][] dp) {

        if (sum < 0) return 0;
        if (sum == 0) return 1;
        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }
        if (index == 0) return nums[index] == sum ? 1 : 0;
        int notTake = findSubsetExist(nums, index - 1, sum - nums[index], dp);
        int take = findSubsetExist(nums, index - 1, sum, dp);
        dp[index][sum] = take + notTake >= 1 ? 1 : 0;
        if (dp[index][sum] == 1) {
            return 1;
        }
        return 0;
    }


}
