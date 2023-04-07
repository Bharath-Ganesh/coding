package com.practice.mycodeschool.ds;

import java.util.List;

public class MatrixRepresentation {

	public static Integer matrixRepresentation(List<List<Integer>> arr) {

		Integer max_sum = arr.get(0).get(0);
		Integer sum = 0;
		for (int i = 0; i <= 3; i++) {
			for (int j = 0; j <= 3; j++) {
				sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1)
						+ arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
				if (sum > max_sum) {
					max_sum = sum;
				}

			}

		}
		return max_sum;
	}

	public static void main(String[] args) {

		int[][] arr = { { -1, -1, 0, -9, -2, -2 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 }, { 0, 0, 2, 4, 4, 0 },
				{ 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };

	}
}
