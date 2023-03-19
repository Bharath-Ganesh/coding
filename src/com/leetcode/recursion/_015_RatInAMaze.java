package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1).
 * Find all possible paths that the rat can take to reach from source to destination. The directions in which
 * the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is
 * blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
 * Note: In a path, no cell can be visited more than one time.
 * <p>
 * Input:
 * N = 4
 * m[][] = {{1, 0, 0, 0},
 * {1, 1, 0, 1},
 * {1, 1, 0, 0},
 * {0, 1, 1, 1}}
 * Output:
 * DDRDRR DRDDRR
 * Explanation:
 * The rat can reach the destination at
 * (3, 3) from (0, 0) by two paths - DRDDRR
 * and DDRDRR, when printed in sorted order
 * we get DDRDRR DRDDRR.
 */
public class _015_RatInAMaze {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        int[][] mat2 = {{1, 0,},{1,1}};
       // System.out.println(findPath(matrix, matrix.length));
        System.out.println(findPath(mat2, mat2.length));
    }

    public static ArrayList<String> findPath(int[][] mat, int n) {
        // Your code here
        int[] di={1,0,0,-1};
        int[] dj={0,-1,1,0};
        ArrayList<String> res=new ArrayList<>();
        boolean[][] visited=new boolean[n][n];
        for(boolean[] arr : visited){
            Arrays.fill(arr,false);
        }
        if(mat[0][0]==0 || mat[n-1][n-1]==0){
            return res;
        }
        findPath(di,dj,res,"",0,0,visited,mat);
        return res;
    }

    public static void findPath(int[] di,int[] dj,ArrayList<String> res,String path,int rIndex,int cIndex,boolean[][] visited,int[][] mat) {

        if(rIndex==mat.length-1 && cIndex==mat.length-1){
            res.add(path);
            return;
        }
        // DLRU
        String direction = "DLRU";
        for(int i=0;i<4;i++){
            int row=rIndex+di[i];
            int col=cIndex+dj[i];
            Character ch = direction.charAt(i);
            if(row>=0 && row<mat.length && col>=0 && col<mat.length && visited[row][col]==false && mat[row][col]==1){
                visited[rIndex][cIndex]=true;
                findPath(di,dj,res,path+ch,row,col,visited,mat);
                visited[rIndex][cIndex]=false;
            }
        }
    }

//    public static ArrayList<String> findPathOptimum(int[][] matrix, int n) {
//        // Your code here
//        ArrayList<String> res = new ArrayList<>();
//        int row = 0, col = 0;
//        if (matrix[row][col] == 0) {
//            return res;
//        }
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//        int[] i = {1, 0, 0, -1};
//        int[] j = {0, -1, 1, 0};
//        String path = "";
//        findPathOptimum(matrix, res, row, col, i, j, path, visited);
//        return res;
//
//    }
//
//    public static void findPathOptimum(int[][] matrix, ArrayList<String> res, int row, int col, int[] down, int[] up, String path, boolean[][] visited) {
//        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
//            res.add(path);
//            return;
//        }
//
//        String direction = "DLRU";
//        for (int i = 0; i < 4; i++) {
//            int rIndex = row + down[i];
//            int cIndex = col + up[i];
//            Character ch = direction.charAt(i);
//            if (isSafe(rIndex, cIndex, visited, matrix)) {
//                visited[row][col] = true;
//                findPathOptimum(matrix, res, rIndex, cIndex, down, up, path + ch, visited);
//                visited[row][col] = false;
//            }
//        }
//    }
//
//    public static ArrayList<String> findPath(int[][] matrix, int n) {
//        // Your code here
//        ArrayList<String> res = new ArrayList<>();
//        int row = 0, col = 0;
//        if (matrix[row][col] == 0) {
//            return res;
//        }
//        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
//        String path = "";
//        findPath(matrix, res, row, col, path, visited);
//        return res;
//
//    }
//
//    public static void findPath(int[][] matrix, ArrayList<String> res, int row, int col, String path, boolean[][] visited) {
//        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
//            res.add(path);
//            return;
//        }
//
//
//        //downward
//        if (isSafe(row + 1, col, visited, matrix)) {
//            visited[row][col] = true;
//            findPath(matrix, res, row + 1, col, path + "D", visited);
//            visited[row][col] = false;
//        }
//        //Left
//        if (isSafe(row, col - 1, visited, matrix)) {
//            visited[row][col] = true;
//            findPath(matrix, res, row, col - 1, path + "L", visited);
//            visited[row][col] = false;
//        }
//        //right
//        if (isSafe(row, col + 1, visited, matrix)) {
//            visited[row][col] = true;
//            findPath(matrix, res, row, col + 1, path + "R", visited);
//            visited[row][col] = false;
//        }
//        //up
//        if (isSafe(row - 1, col, visited, matrix)) {
//            visited[row][col] = true;
//            findPath(matrix, res, row - 1, col, path + "U", visited);
//            visited[row][col] = false;
//        }
//    }
//
//    private static boolean isSafe(int row, int col, boolean[][] visited, int[][] matrix) {
//        if ((row < 0 || col < 0 || col >= matrix.length || row >= matrix.length) || matrix[row][col] == 0 || visited[row][col] == true) {
//            return false;
//        }
//        return true;
//    }


}
