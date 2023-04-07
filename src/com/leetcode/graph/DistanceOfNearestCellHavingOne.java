package com.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {

    int row;
    int col;
    int steps;

    Pair(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

public class DistanceOfNearestCellHavingOne {

    public static void main(String[] args) {
        DistanceOfNearestCellHavingOne obj = new DistanceOfNearestCellHavingOne();
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}};
        int[][] nearest = obj.nearest(grid);
        Arrays.stream(nearest).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    public int[][] nearest(int[][] grid) {
        // Code here
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();

        int[][] newArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                newArray[i][j] = grid[i][j];
            }
        }

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (newArray[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        return bfs(visited, newArray, queue);
    }

    public int[][] bfs(boolean[][] visited, int[][] grid, Queue<Pair> queue) {


        int[] dlRow = {-1, 0, +1, 0};
        int[] dlCol = {0, +1, 0, -1};

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];

        while (!queue.isEmpty()) {
            int cRow = queue.peek().row;
            int cCol = queue.peek().col;
            int cSteps = queue.peek().steps;
            distance[cRow][cCol] = cSteps;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = cRow + dlRow[i];
                int nCol = cCol + dlCol[i];

                if (nRow >= 0 && nCol >= 0 && nRow < grid.length && nCol < grid[0].length && grid[nRow][nCol] == 0 && visited[nRow][nCol] == false) {
                    visited[nRow][nCol] = true;
                    queue.add(new Pair(nRow, nCol, cSteps + 1));
                }
            }
        }
        return distance;
    }
}
