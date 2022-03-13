package com.leetcode.array;


import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * Input: board =
 * [['5','3','.','.','7','.','.','.','.']
 * ,['6','.','.','1','9','5','.','.','.']
 * ,['.','9','8','.','.','.','.','6','.']
 * ,['8','.','.','.','6','.','.','.','3']
 * ,['4','.','.','8','.','3','.','.','1']
 * ,['7','.','.','.','2','.','.','.','6']
 * ,['.','6','.','.','.','.','2','8','.']
 * ,['.','.','.','4','1','9','.','.','5']
 * ,['.','.','.','.','8','.','.','7','9']]
 * Output: true
 */
public class _006_ValidSudoku {

    public static void main(String[] args) {
        char[][] board =
                 {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudokuLeetcode(board));
        System.out.println(isValidSudoku(board));


    }

    public static boolean isValidSudoku(char[][] board) {
        boolean isValid = false;
        Set<String> hashSet = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //elements in the 3*3 matrix
                char element = board[i][j];
                if (element != '.' && (!hashSet.add(element + " found in row " + i) || !hashSet.add(element + " found in col " + j) || !hashSet.add(element + " found in box " + i / 3 + "-" + j / 3))) {
                    return isValid;
                }

            }
        }
        return true;
    }


    /**
     * Great solution!. Just trying to explain how to think about % and /.
     * These two operators can be helpful for matrix traversal problems.
     * For a block traversal, it goes the following way.
     * 0,0, 0,1, 0,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
     * 1,0, 1,1, 1,2; < --- 3 Horizontal Steps followed by 1 Vertical step to next level.
     * 2,0, 2,1, 2,2; < --- 3 Horizontal Steps.

     * And so on...
     * But, the j iterates from 0 to 9.
     * But we need to stop after 3 horizontal steps, and go down 1 step vertical.
     * Use % for horizontal traversal.
     * Because % increments by 1 for each j : 0%3 = 0 , 1%3 = 1, 2%3 = 2, and resets back.
     * So this covers horizontal traversal for each block by 3 steps.
     *
     * Use / for vertical traversal.
     * Because / increments by 1 after every 3 j: 0/3 = 0; 1/3 = 0; 2/3 =0; 3/3 = 1.
     * So far, for a given block, you can traverse the whole block using just j.

     * But because j is just 0 to 9, it will stay only first block.
     * But to increment block, use i. To move horizontally to next block, use % again :
     * ColIndex = 3 * i%3 (Multiply by 3 so that the next block is after 3 columns.
     * Ie 0,0 is start of first block, second block is 0,3 (not 0,1);
     *
     */
    public static boolean isValidSudokuLeetcode(char[][] board) {

        for(int row=0;row<board.length;row++){
            Set<Character> rowSet=new HashSet();
            Set<Character> colSet=new HashSet();
            Set<Character> boxSet=new HashSet();
            for(int col=0;col<board[0].length;col++){

                    if(board[row][col]!='.' && !rowSet.add(board[row][col])){
                        return false;
                    }

                    if(board[col][row]!='.' && !colSet.add(board[col][row])){
                        return false;
                    }

                    int rIndex= 3*(row/3);
                    int cIndex= 3*(row%3);

                    if(board[rIndex+(col/3)][cIndex+(col%3)]!='.' && !boxSet.add(board[rIndex+(col/3)][cIndex+(col%3)])){
                        return false;
                    }

            }
        }
        return true;
    }

    public static boolean isValidSudoku2(char[][] board) {

        for(int i=0;i<board.length;i++){
            Set<Character> row=new HashSet<>();
            Set<Character> col=new HashSet<>();
            Set<Character> box=new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                Character rv=board[i][j];
                Character cv=board[j][i];
                if(rv!='.' && !row.add(rv)){
                    return false;
                }
                if(cv!='.' && !col.add(cv)){
                    return false;
                }
                int row_value=3*(i/3);
                int col_value=3*(i%3);
                char bv = board[row_value + (j / 3)][col_value + (j % 3)];
                if(bv!='.' && !box.add(bv)){
                    return false;
                }
            }
        }
        return true;
    }
}
