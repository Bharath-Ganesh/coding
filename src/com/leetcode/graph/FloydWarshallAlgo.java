package com.leetcode.graph;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 */
public class FloydWarshallAlgo {

    public static void main(String[] args) {
        FloydWarshallAlgo obj = new FloydWarshallAlgo();
        int[][] matrix = {{0,1,43},{1,0,6},{-1,-1,0}};
        obj.shortest_distance(matrix);
        Arrays.stream(matrix).forEach(x-> System.out.println(Arrays.toString(x)));
    }

    public void shortest_distance(int[][] matrix) {
        // Code here
        int $SystemValue=2;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    boolean infinity = matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE;
                    if (!infinity) {
                        matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = -1;
                }
            }
        }

    }
}
