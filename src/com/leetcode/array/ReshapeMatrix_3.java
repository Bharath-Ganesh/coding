package com.leetcode.array;

/**
 *
 * 566. Reshape the Matrix
 *
 * In MATLAB, there is a handy function called reshape which can reshape an columns x n matrix into a new one with a different size
 * r x c keeping its original data.
 * You are given an columns x n matrix mat and two integers r and c representing
 * the number of rows and the number of columns of the wanted reshaped matrix.
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4
 * Output: [[1,2,3,4]]
 *
 * Input: mat = [[1,2],[3,4]], r = 2, c = 4
 * Output: [[1,2],[3,4]]
 */
public class ReshapeMatrix_3 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2,3}, {4, 5,6}};
        int r = 3, c = 2;
        int[][] result = matrixReshapeLeetCode(mat, r, c);
        for (int i=0;i<result.length;i++){
            for(int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        if(mat.length*mat[0].length != r*c){
            return mat;
        }
        //define the array only if the conditions fails
        int[][] result = new int[r][c];
        int rowIncrement=0;
        int columnIncrement=0;
        for (int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                result[rowIncrement][columnIncrement++]=mat[i][j];
                if(columnIncrement== (c)){
                    rowIncrement++;
                    columnIncrement=0;
                }
            }
        }

        return result;
    }

    public static int[][] matrixReshapeLeetCode(int[][] nums, int r, int c) {
        int rows = nums.length, columns = nums[0].length;
        if(nums.length*nums[0].length != r*c){
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i=0;i<r*c;i++){
            result[i/c][i%c]=nums[i/columns][i%columns];
        }
        return result;
    }


}
