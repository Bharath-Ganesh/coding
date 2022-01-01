package com.leetcode.dp;

import java.util.Arrays;
import java.util.Map;

public class FrogJumpsEnergy {

    public static void main(String[] args) {

        int[] heights = {10, 20, 30, 10};
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        int n = heights.length - 1;
        int jump = frogJump(heights.length, heights);
        System.out.println(jump);
    }

//    public static int frogJump(int n, int heights[]) {
//
//        // Write your code here..
//        int[] dp = new int[n];
//        if (n <= 1) return 0;
//        dp[0] = 0;
//        dp[1] = Math.abs(heights[1] - heights[0]);
//        for (int i = 2; i < n; i++) {
//            dp[i] = Math.min(dp[i - 1] + Math.abs(heights[i - 1] - heights[i]), dp[i - 2] + Math.abs(heights[i - 2] - heights[i]));
//        }
//        return dp[n - 1];
//    }

    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogJump(n - 1, heights, dp);
    }

    public static int frogJump(int index, int heights[], int[] dp) {

        // Write your code here..
        if (index < 0) return Integer.MAX_VALUE;
        if (index == 0) return 0;
        if (dp[index] != -1) {
            return dp[index];
        }
        int left = frogJump(index - 1, heights, dp) + Math.abs(heights[index - 1] - heights[index]);
        int right = frogJump(index - 2, heights, dp);
        if (index > 1) {
            right += Math.abs(heights[index - 2] - heights[index]);
        }
        return dp[index] = Math.min(left, right);
    }

    public static int frogJumpRecursive(int index, int heights[]) {

        // Write your code here..
        if (index < 0) return Integer.MAX_VALUE;
        if (index == 0) return 0;

        int left = frogJumpRecursive(index - 1, heights) + Math.abs(heights[index - 1] - heights[index]);
        int right = frogJumpRecursive(index - 2, heights) + Math.abs(heights[index - 2] - heights[index]);
        return Math.min(left, right);
    }

//    private static int frogJump(int n, int[] heights, int[] dp) {
//        if (n < 0) {
//            return 100000;
//        }
//        if (n == 0) {
//            return heights[0];
//        }
//        if (dp[n] != -1) {
//            return dp[n];
//        }
//        int left = Math.abs(heights[n] - frogJump(n - 1, heights, dp));
//        int right = Math.abs(heights[n] - frogJump(n - 2, heights, dp));
//        dp[n] = Math.min(left, right);
//        return dp[n];
//    }
}
