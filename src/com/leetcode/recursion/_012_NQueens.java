package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space, respectively.
 * <p>
 * Input: n = 4
 * Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */
public class _012_NQueens {

    public static void main(String[] args) {
        int n = 4;
        //  System.out.println(solveNQueensBruteForce(n));
        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            board[i] = arr;
        }
        int col = 0;
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        solveNQueens(board, col, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }


    public static void solveNQueens(char[][] board, int col, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == board.length) {
            List<String> possibleBoard = generateBoard(board);
            res.add(possibleBoard);
            return;
        }


        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + (col - row)] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + (col - row)] = 1;

                solveNQueens(board, col + 1, res, leftRow, lowerDiagonal, upperDiagonal);

                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + (col - row)] = 0;

                board[row][col] = '.';
            }
        }
    }

    public static List<String> generateBoard(char[][] board) {
        List<String> possibleBoard = new ArrayList();
        for (char[] arr : board) {
            possibleBoard.add(String.valueOf(arr));
        }
        return possibleBoard;
    }

    public static boolean isValidBoard(char[][] board, int row, int col) {

        //down
        int rowD = row;
        int colD = col;
        while (colD >= 0) {
            if (board[rowD][colD] == 'Q') {
                return false;
            }
            colD--;
        }

        rowD = row;
        colD = col;
        //upper diagonal
        while (rowD >= 0 && colD >= 0) {
            if (board[rowD][colD] == 'Q') {
                return false;
            }
            colD--;
            rowD--;
        }

        rowD = row;
        colD = col;
        //lower diagonal
        while (rowD < board.length && colD >= 0) {
            if (board[rowD][colD] == 'Q') {
                return false;
            }
            colD--;
            rowD++;
        }
        return true;
    }


}




