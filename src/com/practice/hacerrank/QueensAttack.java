package com.practice.hacerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * You will be given a square chess board with one queen and a number of
 * obstacles placed on it. Determine how many squares the queen can attack.
 * 
 * A queen is standing on an chessboard. The chess board’s rows are numbered
 * from to , going from bottom to top. Its columns are numbered from to , going
 * from left to right. Each square is referenced by a tuple, , describing the
 * row, , and column, , where the square is located.
 * 
 * The queen is standing at position . In a single move, she can attack any
 * square in any of the eight directions (left, right, up, down, and the four
 * diagonals). In the diagram below, the green circles denote all the cells the
 * queen can attack from :
 * 
 * There are obstacles on the chessboard, each preventing the queen from
 * attacking any square beyond it on that path. For example, an obstacle at
 * location in the diagram above prevents the queen from attacking cells , , and
 * :
 * 
 * Function Description
 * 
 * Complete the queensAttack function in the editor below.
 * 
 * queensAttack has the following parameters: - int n: the number of rows and
 * columns in the board
 * 
 * - nt k: the number of obstacles on the board
 * 
 * - int r_q: the row number of the queen's position
 * 
 * - int c_q: the column number of the queen's position
 * 
 * - int obstacles[k][2]: each element is an array of integers, the row and
 * column of an obstacle
 *
 * input : 4 0 4 4
 * 
 * output : 9
 */
public class QueensAttack {

	public static void main(String[] args) {
	}

	public static int queensAttack(int n, int k, int qRow, int qCol, List<List<Integer>> obstacles) {

		int top = n - qRow;
		int bottom = qRow - 1;
		int right = n - qCol;
		int left = qCol - 1;

		int topLeft = Math.min(left, top);
		int topRight = Math.min(top, right);
		int bottomLeft = Math.min(bottom, left);
		int bottomRight = Math.min(bottom, right);

		for (List<Integer> obstacle : obstacles) {
			int pawnRow = obstacle.get(0);
			int pawnCol = obstacle.get(1);

			// right
			if (pawnRow == qRow && pawnCol > qCol)
				right = Math.min(right, pawnCol - qCol - 1);

			// left
			if (pawnRow == qRow && qCol > pawnCol)
				left = Math.min(left, qCol - pawnCol - 1);

			// top
			if (pawnCol == qCol && pawnRow > qRow)
				top = Math.min(top, pawnRow - qRow - 1);

			// bottom
			if (pawnCol == qCol && qRow > pawnRow)
				bottom = Math.min(bottom, qRow - pawnRow - 1);

			// topLeft
			if (pawnCol < qCol && pawnRow > qRow && qCol - pawnCol == pawnRow - qRow)
				topLeft = Math.min(topLeft, qCol - pawnCol - 1);

			// topRight
			if (pawnCol > qCol && pawnRow > qRow && pawnCol - qCol == pawnRow - qRow)
				topRight = Math.min(topRight, pawnRow - qRow - 1);

			// bottomLeft
			if (qCol > pawnCol && qRow > pawnRow && qRow - pawnRow == qCol - pawnCol)
				bottomLeft = Math.min(bottomLeft, qCol - pawnCol - 1);

			// bottom right
			if (pawnCol > qCol && qRow > pawnRow && pawnCol - qCol == qRow - pawnRow)
				bottomRight = Math.min(bottomRight, pawnCol - qCol - 1);

		}

		return top + bottom + right + left + topLeft + topRight + bottomLeft + bottomRight;

	}

}
