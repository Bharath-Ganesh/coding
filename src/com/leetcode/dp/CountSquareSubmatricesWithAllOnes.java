package com.leetcode.dp;

public class CountSquareSubmatricesWithAllOnes {

    public static void main(String[] args) {
        CountSquareSubmatricesWithAllOnes obj = new CountSquareSubmatricesWithAllOnes();
        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(obj.countSquares(matrix));
    }

    public int countSquares(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int num = matrix[i][j];
                if (num == 1) {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count+=matrix[i][j];
            }
        }
        return count;

    }
}
