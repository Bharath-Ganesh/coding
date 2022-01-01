package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/maximum-path-sum-matrix/
 */
public class MaxPathSumFromVariableStartPoint {

    public static void main(String[] args) {
        int mat[][] = {{10, 10, 2, 0, 20, 4}, {1, 0, 0, 30, 2, 5}, {0, 10, 4, 0, 2, 0}, {1, 0, 2, 20, 0, 4}};
        int maxPath = findMaxPathTabulationSpaceOptimization(mat);
        System.out.println(maxPath);
    }

    public static int findMaxPath(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        int maxPathSum = 0;
        for (int col = 0; col < cols; col++) {
            maxPathSum = Math.max(findMaxPath(0, col, mat, dp), maxPathSum);
        }
        return maxPathSum;
    }

    private static int findMaxPath(int rows, int cols, int[][] mat, int[][] dp) {
        if (rows < 0 || cols < 0 || rows >= mat.length || cols >= mat[0].length) {
            return Integer.MIN_VALUE;
        }
        if (rows == mat.length - 1) {
            return mat[rows][cols];
        }
        if (dp[rows][cols] != -1) {
            return dp[rows][cols];
        }
        int down = findMaxPath(rows + 1, cols, mat, dp);
        int leftD = findMaxPath(rows + 1, cols - 1, mat, dp);
        int rightD = findMaxPath(rows + 1, cols + 1, mat, dp);
        return dp[rows][cols] = mat[rows][cols] + Math.max(Math.max(down, leftD), rightD);
    }


    public static int findMaxPathTabulation(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        for (int col = 0; col < cols; col++) {
            dp[rows - 1][col] = mat[rows - 1][col];
        }

        int maxPathSum = 0;
        for (int row = rows - 2; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                int down = dp[row + 1][col];
                int leftD = Integer.MIN_VALUE;
                if (col - 1 > 0) {
                    leftD = dp[row + 1][col - 1];
                }
                int rightD = Integer.MIN_VALUE;
                if (col + 1 < cols) {
                    rightD = dp[row + 1][col + 1];
                }
                dp[row][col] = mat[row][col] + Math.max(Math.max(down, leftD), rightD);
                maxPathSum = Math.max(dp[row][col], maxPathSum);
            }
        }
        //Arrays.stream(dp).forEach(arr-> System.out.println(Arrays.toString(arr)));
        return maxPathSum;
    }

    public static int findMaxPathTabulationSpaceOptimization(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] dp = new int[cols];
        for (int col = 0; col < cols; col++) {
            dp[col] = mat[rows - 1][col];
        }
        int maxPathSum = 0;
        for (int row = rows - 2; row >= 0; row--) {
            int curr[] = new int[cols];
            for (int col = cols - 1; col >= 0; col--) {
                int down = dp[col];
                int leftD = Integer.MIN_VALUE;
                if (col - 1 > 0) {
                    leftD = dp[col - 1];
                }
                int rightD = Integer.MIN_VALUE;
                if (col + 1 < cols) {
                    rightD = dp[col + 1];
                }
                curr[col] = mat[row][col] + Math.max(Math.max(down, leftD), rightD);
                maxPathSum = Math.max(curr[col], maxPathSum);
            }
            dp = curr;
        }
        return maxPathSum;
    }


}
