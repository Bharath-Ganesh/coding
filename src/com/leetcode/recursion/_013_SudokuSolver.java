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
        Arrays.stream(board).forEach(x -> System.out.println(Arrays.toString(x)));



    }


    public static void solveSudoku(char[][] board) {
        solveSudokuBoard(board);

    }

    public static boolean solveSudokuBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValidBoard(row, col, board, ch)) {
                            board[row][col] = ch;
                            if (solveSudokuBoard(board)) {
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

//        for(int i=0;i<0;i++){
//            if(board[i][col]==ch || board[row][i]==ch){
//                return false;
//            }
//            int rowD= (row/3)*3 + (i/3);
//            int colD= (col/3)*3 + (i%3);
//
//            if(board[rowD][colD]==ch){
//                return false;
//            }
//        }
//        return true;

    }

    public static boolean isValidBoard(int row, int col, char[][] board, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch || board[i][col] == ch) {
                return false;
            }

            int rIndex = 3 * (row / 3) + i / 3;
            int cIndex = 3 * (col / 3) + i % 3;
            if (board[rIndex][cIndex] == ch) {
                return false;
            }
        }
        return true;
    }




}
