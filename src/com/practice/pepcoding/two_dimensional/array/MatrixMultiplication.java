package com.practice.pepcoding.two_dimensional.array;

public class MatrixMultiplication {

	public static void main(String[] args) {

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
