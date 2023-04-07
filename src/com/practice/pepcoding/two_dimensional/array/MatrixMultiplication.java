package com.practice.pepcoding.two_dimensional.array;

public class MatrixMultiplication {

    static int matrixMultiplication(int n, int arr[]) {
        // code here
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i+1; j < n; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
                    dp[i][j] = minCost = Math.min(minCost, cost);
                }
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {

        //extracted();
        int[] arr = {40, 20, 30, 10, 30};
		int cost = matrixMultiplication(arr.length, arr);
		System.out.println(cost);
	}

    private static void extracted() {
        int row_one = 2;
        int column_one = 3;
        int count = 1;
        int[][] matrix_one = new int[row_one][column_one];
        for (int i = 0; i < row_one; i++) {
            for (int j = 0; j < column_one; j++) {
                matrix_one[i][j] = count++;
            }
        }

        int row_two = 3;
        int column_two = 2;
        count = 10;
        int[][] matrix_two = new int[row_two][column_two];
        for (int i = 0; i < row_two; i++) {
            for (int j = 0; j < column_two; j++) {
                matrix_two[i][j] = count++;
            }
        }

        int[][] matrix_three = new int[row_one][column_two];
        for (int i = 0; i < row_one; i++) {
            for (int j = 0; j < column_two; j++) {
                for (int k = 0; k < row_two; k++) {
                    matrix_three[i][j] += matrix_one[i][k] * matrix_two[k][j];
                }
            }
        }

        for (int i = 0; i < row_one; i++) {
            for (int j = 0; j < column_two; j++) {
                System.out.print(matrix_three[i][j] + " ");
            }
            System.out.println();
        }
    }
}
