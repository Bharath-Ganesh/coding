package com.leetcode.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 */
public class PathWithMinimumEffort {

    public static void main(String[] args) {
        PathWithMinimumEffort obj = new PathWithMinimumEffort();
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(obj.minimumEffortPath(heights));
    }

    class Pair {

        int row;
        int col;
        int effort;

        public Pair(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effortArr = new int[rows][cols];
        Arrays.stream(effortArr).forEach(x -> Arrays.fill(x, (int) 1e9));

        Comparator<Pair> comparator = (p1, p2) -> p1.effort - p2.effort;
        PriorityQueue<Pair> queue = new PriorityQueue<>(comparator);
        queue.add(new Pair(0, 0, 0));
        effortArr[0][0] = 0;

        // D , L , U , R
        int[] dlr = {1, 0, -1, 0};
        int[] dlc = {0, -1, 0, 1};

        int minimumEffortPath = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int effort = queue.peek().effort;
            queue.remove();

            if (row == rows - 1 && col == cols - 1) {
                minimumEffortPath = Math.min(minimumEffortPath, effort);
            }

            for (int i = 0; i < 4; i++) {
                int nRow = row + dlr[i];
                int nCol = col + dlc[i];

                if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]) , effort) < effortArr[nRow][nCol]) {
                    effortArr[nRow][nCol] = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]) , effort);
                    queue.add(new Pair(nRow, nCol, effortArr[nRow][nCol]));
                }
            }

        }
        return minimumEffortPath;
    }
}
