package com.practice.pepcoding.two_dimensional.array;

public class DisplayTwoDimensionalArray {

	public static void main(String[] args) {

		int rows = 2;
		int column = 3;
		int[][] arr = new int[rows][column];
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				arr[i][j] = ++count;
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		/**
		 * ALTERNATE WAY OF REPRESENTING AN ARRAY
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
