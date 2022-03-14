package com.leetcode.recursion;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * A sudoku solution must satisfy all of the following rules:
 * <p>
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 */
public class _013_SudokuSolver {

    public static void main(String[] args) {

        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                 {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                 {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                 {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                 {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                 {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                 {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                 {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                 {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        Arrays.stream(board).forEach(x-> System.out.println(Arrays.toString(x)));


    }

    public static void solveSudoku(char[][] board) {
        solveSudokuBoard(board);
    }


    public static boolean solveSudokuBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] =='.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValidSudoku(board, ch, row, col)) {
                            board[row][col]=ch;
                            if (solveSudokuBoard(board) == true) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }

                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean isValidSudoku(char[][] board, char k, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == k) {
                return false;
            }
            if (board[i][col] == k) {
                return false;
            }
            int rIndex = (3 * (row / 3)) + i / 3;
            int cIndex = (3 * (col / 3)) + i % 3;
            if (board[rIndex][cIndex] == k) {
                return false;
            }
        }
        return true;

    }
}
