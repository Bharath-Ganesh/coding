package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class UniquePathsObstacles {

    public static void main(String[] args) {
        UniquePathsObstacles obj = new UniquePathsObstacles();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(obj.uniquePathsWithObstaclesTabulation(obstacleGrid));

    }


    public int uniquePathsWithObstaclesSpaceOptimization(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols];
        for (int row = 0; row < rows; row++) {
            int temp[] = new int[cols];
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    temp[col] = 1;
                } else if (obstacleGrid[row][col] == 1) {
                    temp[col] = 0;
                } else {
                    int up = dp[col];
                    int left = 0;
                    if (col > 0) {
                        left = temp[col - 1];
                    }
                    temp[col] = up + left;
                }
            }
            dp = temp;
        }
        return dp[cols - 1];
    }


    public int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {

        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[row][col];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        return uniquePathsWithObstacles(obstacleGrid, row - 1, col - 1, dp);
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }
        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int left = uniquePathsWithObstacles(obstacleGrid, row - 1, col, dp);
        int up = uniquePathsWithObstacles(obstacleGrid, row, col - 1, dp);
        return dp[row][col] = left + up;
    }
}
