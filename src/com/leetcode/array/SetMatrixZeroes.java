package com.leetcode.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

//https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}, {0, 1, 0, 0}};
        setZeroesConstantSpace(matrix);
        Arrays.stream(matrix).forEach(x -> System.out.println(Arrays.toString(x)));
    }

    //Brute force using extra space
    public static void setZeroes(int[][] matrix) {

        int rows[] = new int[matrix.length];
        int cols[] = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = -1;
                    cols[j] = -1;
                }
            }
        }

        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == -1) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < cols.length; i++) {
            if (cols[i] == -1) {
                for (int j = 0; j < rows.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public static void setZeroesConstantSpace(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int colsFlag= 1;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) colsFlag = 0;
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        Arrays.sort(matrix);
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(colsFlag == 0){
                matrix[i][0] = 0;
            }
        }
    }
}
