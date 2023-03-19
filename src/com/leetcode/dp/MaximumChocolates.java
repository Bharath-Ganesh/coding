package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 */
public class MaximumChocolates {

    public static void main(String[] args) {
        MaximumChocolates obj = new MaximumChocolates();
        int[][] grid = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
        int pts = maximumChocolatesTabulation(grid.length, grid[0].length, grid);
        System.out.println(pts);
    }

    public static int maximumChocolates(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[r][c][c];
        Arrays.stream(dp).forEach(x -> Arrays.stream(x).forEach(y -> Arrays.fill(y, -1)));
        return maximumChocolates(0, 0, c - 1, grid, dp);
    }


    public static int maximumChocolates(int i, int j1, int j2, int[][] grid, int[][][] dp) {

        if (j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length) return Integer.MIN_VALUE;

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int k1 = -1; k1 <= 1; k1++) {
            for (int k2 = -1; k2 <= 1; k2++) {
                int points = maximumChocolates(i + 1, j1 + k1, j2 + k2, grid, dp);
                if (j1 == j2) {
                    points += grid[i][j1];
                } else {
                    points += grid[i][j1] + grid[i][j2];
                }
                max = Math.max(max, points);
            }
        }
        return dp[i][j1][j2] = max;

    }

    public static int maximumChocolatesTabulation(int r, int c, int[][] grid) {
        // Write your code here.
        int[][][] dp = new int[r][c][c];

        for (int j1 = 0; j1 < c; j1++) {
            for (int j2 = 0; j2 < c; j2++) {
                if (j1 == j2) {
                    dp[r - 1][j1][j2] = grid[r - 1][j2];
                } else {
                    dp[r - 1][j1][j2] = grid[r - 1][j2] + grid[r - 1][j1];
                }
            }
        }

        for (int i = r - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int k1 = -1; k1 <= 1; k1++) {
                        for (int k2 = -1; k2 <= 1; k2++) {
                            int points = Integer.MIN_VALUE;
                            if (j1 + k1 >= 0 && j2 + k2 >= 0 && j1 + k1 < c && j2 + k2 < c) {
                                points = dp[i + 1][j1 + k1][j2 + k2];
                                if (j1 == j2) {
                                    points += grid[i][j1];
                                } else {
                                    points += grid[i][j1] + grid[i][j2];
                                }
                            }
                            max = Math.max(max, points);
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }

        }
        return dp[0][0][c - 1];
    }
}
