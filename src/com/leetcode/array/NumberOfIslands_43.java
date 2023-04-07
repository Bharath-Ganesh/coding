package com.leetcode.array;

/**
 * 200. Number of Islands
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * a
 * char[][] grid = {
 * {'1', '1', '1', '1', '0'},
 * {'1', '1', '0', '1', '0'},
 * {'1', '1', '0', '0', '0'},
 * {'0', '0', '0', '0', '0'}
 * };
 * Output: 1
 * <p>
 * char[][] grid = {
 * {'1','1','0','0','0'},
 * {'1','1','0','0','0'},
 * {'0','0','1','0','0'},
 * {'0','0','0','1','1'}
 * };
 * Output: 3
 */
public class NumberOfIslands_43 {

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int totalIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Character ch = grid[i][j];
                if (ch == '1') {
                    totalIslands++;
                    markAdjacentIsland(grid, i, j);
                }
            }
        }
        return totalIslands;
    }

    private static void markAdjacentIsland(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '2';
        markAdjacentIsland(grid, row + 1, col);
        markAdjacentIsland(grid, row, col + 1);
        markAdjacentIsland(grid, row - 1, col);
        markAdjacentIsland(grid, row, col - 1);
    }
}

