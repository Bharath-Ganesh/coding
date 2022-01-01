package com.practice.hacerrank;

/*
 * 5 3 4
 * 1 5 8
 * 6 4 2
 * 
 * 8 3 4 
 * 1 5 9 
 * 6 7 2
 * 
 * You will be given a  matrix  of integers in the inclusive range [1,9] . We can convert any digit a to any other digit b in the range [1,9]
 *   at cost of |a -b |.Given s, convert it into a magic square at minimal cost. Print this cost on a new line.

Note: The resulting magic square must contain distinct integers in the inclusive range .
 * 
 */
public class FormAMagicSquare {

	public static void main(String[] args) {
		int[][] square = { { 2, 9, 8}, { 4, 2, 7 }, { 5 ,6 ,7 } };
		int cost = formMagicSquare(square);
		System.out.println(cost);
	}

	private static int formMagicSquare(int[][] square) {
		int cost = 100;
		int[][] possibleSum = { { 8, 1, 6, 3, 5, 7, 4, 9, 2 }, { 8, 3, 4, 1, 5, 9, 6, 7, 2 },
				{ 4, 9, 2, 3, 5, 7, 8, 1, 6 }, { 4, 3, 8, 9, 5, 1, 2, 7, 6 }, { 2, 9, 4, 7, 5, 3, 6, 1, 8 },
				{ 2, 7, 6, 9, 5, 1, 4, 3, 8 }, { 6, 7, 2, 1, 5, 9, 8, 3, 4 }, { 6, 1, 8, 7, 5, 3, 2, 9, 4 } };

		for (int i = 0; i < possibleSum.length; i++) {
			int currsum = 0;
			for (int j = 0; j < possibleSum[i].length; j++) {
				currsum += Math.abs(square[j / 3][j % 3] - possibleSum[i][j]);
			}
			if (currsum < cost) {
				cost = currsum;
			}
		}
		return cost;

	}

}
