package com.leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInABinaryMaze {

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int[] source = {0, 1}, destination = {4, 0};
        System.out.println(new ShortestDistanceInABinaryMaze().shortestPath(grid, source, destination));
    }

    class Pair {

        int row;
        int col;
        int distance;

        public Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distance = new int[rows][cols];
        Arrays.stream(distance).forEach(x -> Arrays.fill(x, (int) 1e9));

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source[0], source[1], 0));
        distance[source[0]][source[1]] = 0;

        // D , L , U , R
        int[] dlr = {1, 0, -1, 0};
        int[] dlc = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().distance;
            queue.remove();

            if (row == destination[0] && col == destination[1]) {
                return dist;
            }
            for (int i = 0; i < 4; i++) {
                int nRow = row + dlr[i];
                int nCol = col + dlc[i];

                if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1 && dist + 1 < distance[nRow][nCol]) {
                    distance[nRow][nCol] = dist + 1;
                    queue.add(new Pair(nRow, nCol, dist + 1));
                }
            }

        }
        return -1;
    }
}
