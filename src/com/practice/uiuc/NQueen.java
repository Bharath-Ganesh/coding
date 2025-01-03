package com.practice.uiuc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    public static void main(String[] args) {
        NQueen obj = new NQueen();
        System.out.println(obj.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        Character[][] queenBoard = new Character[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(queenBoard[i], '.');
        }

        boolean[] leftRow = new boolean[n];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        boolean[] uppderDiagonal = new boolean[2*n-1];
        solveNQueens(n, queenBoard, 0, leftRow, lowerDiagonal,uppderDiagonal, result);
        return result;
    }

    public void solveNQueens(int n, Character[][] queenBoard, int col, boolean[] leftRow, boolean[] lowerDiagonal, boolean upperDiagonal[], List<List<String>> result) {

        if(col == n){
            List<String> rowString = new ArrayList<>();
            for(int row = 0; row<n; row++){
                StringBuilder res = new StringBuilder();
                for(int cols=0; cols<n; cols++){
                    res.append(queenBoard[row][cols]);
                }
                rowString.add(res.toString());
            }
            result.add(rowString);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isValid(row, col, n, leftRow, lowerDiagonal,upperDiagonal, queenBoard)) {
                leftRow[row] = true;
                queenBoard[row][col] = 'Q';
                lowerDiagonal[row+col] = true;
                upperDiagonal[(n-1)-(col-row)] = true;
                solveNQueens(n, queenBoard, col + 1, leftRow, lowerDiagonal,upperDiagonal, result);
                leftRow[row] = false;
                lowerDiagonal[row+col] = false;
                upperDiagonal[(n-1)-(col-row)] = false;
                queenBoard[row][col] = '.';

            }
        }
    }

    private boolean isValid(int rows, int cols, int n, boolean[] leftRow, boolean[] lowerDiagonal, boolean upperDiagonal[], Character[][] queenBoard) {

        // check col
        if(leftRow[rows]==true || upperDiagonal[(n-1)-(cols-rows)]==true || lowerDiagonal[rows+cols]==true){
            return false;
        }

        return true;
    }



    

}
