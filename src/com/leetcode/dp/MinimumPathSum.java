package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum obj = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(obj.minPathSumSpace(grid));
//        int rows = grid.length;
//        int cols = grid[0].length;
//        int[][] dp = new int[rows][cols];
//        Arrays.stream(dp).forEach(x->Arrays.fill(x,-1));
//        dp[0][0]=grid[0][0];
//        System.out.println(obj.minPathSumRecursive(rows - 1, cols - 1, grid, dp));
//        System.out.println();
    }

    public int minPathSumSpace(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int[] dp = new int[cols];
        for (int i = 0; i < rows; i++) {
            int[] temp = new int[cols];
            for (int j = 0; j < cols; j++) {
                int left = Integer.MAX_VALUE;
                if (i == 0) {
                    left = grid[i][j];
                    if (j >0) {
                        left += temp[j - 1];
                    }
                    temp[j] = left;
                } else {
                    if (j > 0) {
                        left = temp[j - 1];
                    }
                    temp[j] = grid[i][j] + Math.min(dp[j], left);
                }
            }
            dp = temp;
        }
        return dp[cols - 1];
    }


    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public int minPathSumRecursive(int rows, int cols, int[][] grid, int[][] dp) {
        if (rows < 0 || rows >= dp.length || cols < 0 || cols >= grid[0].length) return Integer.MAX_VALUE;
        if (dp[rows][cols] != -1) {
            return dp[rows][cols];
        }
        int up = minPathSumRecursive(rows - 1, cols, grid, dp);
        int left = minPathSumRecursive(rows, cols - 1, grid, dp);
        return dp[rows][cols] = grid[rows][cols] + Math.min(up, left);
    }
}
