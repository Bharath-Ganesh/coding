package com.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {

    public static void main(String[] args) {
        Triangle obj = new Triangle();
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7), Arrays.asList(4, 1, 8, 3));
        int minTotal = obj.minimumTotal(triangle);
        System.out.println(minTotal);

    }

//    public int minimumTotal(List<List<Integer>> triangle) {
//        return minimumTotal(triangle,0,0);
//    }
//
//    public int minimumTotal(List<List<Integer>> triangle,int row,int col) {
//        if(row==triangle.size()-1){
//            return triangle.get(row).get(col);
//        }
//        int down=triangle.get(row).get(col)+ minimumTotal(triangle,row+1,col);
//        int diagonal=triangle.get(row).get(col)+ minimumTotal(triangle,row+1,col+1);
//        return Math.min(diagonal,down);
//
//    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows=triangle.size();
        int minTotal=Integer.MAX_VALUE;
        int[][] dp=new int[rows][rows];
        Arrays.stream(dp).forEach(x->Arrays.fill(x,-1));
        for(int i=0;i<rows;i++){
            int total=minimumTotal(triangle,rows-1,i,dp);
            minTotal=Math.min(minTotal,total);
        }
        return minTotal;
    }

    public int minimumTotal(List<List<Integer>> triangle,int row,int col,int[][] dp) {

        if(row<0 || col>=triangle.get(row).size() || col<0) return 1000;

        if(row==0 && col==0) return triangle.get(0).get(0);

        if(dp[row][col]!=-1) return dp[row][col];


        int up=triangle.get(row).get(col)+minimumTotal(triangle,row-1,col,dp);
        int diaLeft=triangle.get(row).get(col)+minimumTotal(triangle,row-1,col-1,dp);
        return dp[row][col]=Math.min(up,diaLeft);
    }
}
