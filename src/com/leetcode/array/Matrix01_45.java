package com.leetcode.array;

import java.util.Arrays;

/**
 * 542. 01 Matrix
 * <p>
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
public class Matrix01_45 {

    public static void main(String[] args) {
        int mat[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] updatedMatrix=updateMatrix(mat);
        System.out.println(Arrays.deepToString(updatedMatrix));

    }

    public static int[][] updateMatrix(int[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    int distance=findAdjacentZero(mat,i,j);
                    mat[i][j]=distance;
                }
            }
        }
        return mat;
    }

    private static int findAdjacentZero(int[][] mat, int sr, int sc) {
        if(sr<0 || sr>=mat.length || sc<0 || sc>mat[0].length || mat[sr][sc]==0){
            return 0;
        }
        int min=mat.length;
        int count=1;
        int count1=findAdjacentZero(mat,sr+1,sc);
        int count2=findAdjacentZero(mat,sr,sc+1);
        int count3=findAdjacentZero(mat,sr-1,sc);
        int count4=findAdjacentZero(mat,sr,sc-1);
        return count;
    }
}
