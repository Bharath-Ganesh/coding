package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        int m = 3, n = 7;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(obj.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        return paths(m-1,n-1);
    }

    public int paths(int rows, int cols) {
        if(rows<0 || cols<0){
            return 0;
        }
        if(rows==0 && cols==0){
            return 1;
        }
        int up=paths(rows-1,cols);
        int left=paths(rows,cols-1);
        return up+left;
    }

//    public int uniquePathsSpaceOptimization(int m, int n) {
//        int[] dp=new int[n];
//        for(int i=0;i<n;i++){
//            dp[i]=1;
//        }
//        int[] temp=new int[n];
//        temp[0]=1;
//        for(int row=1;row<m;row++){
//            for(int col=1;col<n;col++){
//                temp[col]=dp[col]+temp[col-1];
//            }
//            dp=temp;
//        }
//        return dp[n-1];
//    }
//
//    public int uniquePathsTabulation(int m, int n) {
//        int[][] dp=new int[m][n];
//        for(int i=0;i<m;i++){
//            dp[i][0]=1;
//        }
//        for(int i=0;i<n;i++){
//            dp[0][i]=1;
//        }
//
//        for(int row=1;row<m;row++){
//            for(int col=1;col<n;col++){
//                dp[row][col]=dp[row-1][col]+dp[row][col-1];
//            }
//        }
//        return dp[m-1][n-1];
//    }
//
//    public int uniquePaths(int m, int n) {
//        int[][] dp = new int[m][n];
//        for (int arr[] : dp) {
//            Arrays.fill(arr, -1);
//        }
//        return uniquePaths(m - 1, n - 1, dp);
//    }
//
//    private boolean isSafe(int row, int col) {
//        if (row < 0 || col < 0) {
//            return false;
//        }
//        return true;
//    }
//
//    private int uniquePaths(int row, int col, int[][] dp) {
//        if (row == 0 && col == 0) {
//            return 1;
//        }
//        if (!isSafe(row, col)) {
//            return 0;
//        }
//        if (dp[row][col] != -1) {
//            return dp[row][col];
//        }
//        int up = uniquePaths(row - 1, col, dp);
//        int left = uniquePaths(row, col - 1, dp);
//        return dp[row][col] = up+left;
//    }


}
