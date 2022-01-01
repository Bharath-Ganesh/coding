package com.leetcode.array;

/**
 * 695. Max Area of Island
 * <p>
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * int[][] grid =
 * {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
 * {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
 * {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
 * {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
 * {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
 * {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
 * {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
 * {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 */
public class MaxAreaOfIsland_42 {

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int maxArea = maxAreaOfIsland(grid);
        System.out.println(maxArea);
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Integer num = grid[i][j];
                if (num == 1) {
                    maxArea=Math.max(maxArea,markAdjacentIsland(grid,i,j));
                }
            }
        }
        return maxArea;
    }

    private static int markAdjacentIsland(int[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }
        grid[row][col] = 0;
        int count=1;
        count+=markAdjacentIsland(grid, row + 1, col);
        count+=markAdjacentIsland(grid, row, col + 1);
        count+=markAdjacentIsland(grid, row - 1, col);
        count+=markAdjacentIsland(grid, row, col - 1);
        return count;
    }
}
