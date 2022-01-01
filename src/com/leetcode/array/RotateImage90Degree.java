package com.leetcode.array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateImage90Degree {

    public static void main(String[] args) {
        RotateImage90Degree obj = new RotateImage90Degree();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        obj.rotate(matrix);
        Arrays.stream(matrix).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                swap(matrix, i, j);
            }
        }

        int m = 0;
        int n = col - 1;
        while (m < n) {
            for (int i = 0; i < row; i++) {
                int temp = matrix[i][m];
                matrix[i][m] = matrix[i][n];
                matrix[i][n] = temp;
            }
            m++;
            n--;
        }
    }

    public void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
