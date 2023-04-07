package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/cherry-pickup/
 */
public class CherryPickup {

    public static void main(String[] args) {
        CherryPickup obj = new CherryPickup();
        int[][] grid = {{0, 1, -1}, {1, 0, -1}, {1, 1, 1}};
        System.out.println(obj.cherryPickup(grid));
    }

    public int cherryPickup(int[][] grid) {
        int[][][][] prev=new int[2][2][2][];
        double x=-Math.pow(1,8);
        int row = grid.length;
        int startRow = 0, startCol = 0;
        int endRow = row - 1, endCol = row - 1;
        if (grid[startRow][startCol] == -1 || grid[endRow][endCol] == -1) {
            return 0;
        }
        int topToBottom = cherryPickup(grid, startRow, startCol, endRow, endCol);
        int bottomToTop = cherryPickup(grid, endRow, endCol, startRow, startCol);
        return topToBottom + bottomToTop;
    }

    private int cherryPickup(int[][] grid, int startRow, int startCol, int endRow, int endCol) {
        if (startRow > endRow || startCol > endCol || startCol < 0 || endCol < 0 || grid[startRow][startCol] == -1) {
            return 0;
        }
        if (startRow == endRow && startCol == endCol) {
            return grid[startRow][startCol] == 1 ? 1 : 0;
        }
        int down = grid[startRow][startCol] + cherryPickup(grid, startRow + 1, startCol, endRow, endCol);
        int right = grid[startRow][startCol] + cherryPickup(grid, startRow, startCol + 1, endRow, endCol);
        if (grid[startRow][startCol] == 1) {
            grid[startRow][startCol] = 0;
        }
        return Math.max(down, right);
    }
}
