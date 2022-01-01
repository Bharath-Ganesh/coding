package com.leetcode.recursion;

/**
 * https://leetcode.com/problems/island-perimeter/
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is
 * exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a
 * square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 */
public class _020_isLandPerimeter {
    public static void main(String[] args) {
        int[][] grid={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
    public static int islandPerimeter(int[][] grid) {
        int p=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    p=isLandPerimeter(grid,i,j,grid.length,grid[0].length);
                    break;
                }
            }
        }
        return p;
    }



    public static int isLandPerimeter(int[][] grid,int row,int col,int maxRow,int maxCol){

        int perimeter=0;
        if(row<0 || col<0 || row>=maxRow || col>=maxCol || grid[row][col]==0){
            return 1;
        }
        if(grid[row][col]==2){
            return 0;
        }
        grid[row][col]=2;
        //down
        perimeter=isLandPerimeter(grid,row+1,col,maxRow,maxCol);
        //up
        perimeter+=isLandPerimeter(grid,row-1,col,maxRow,maxCol);
        //right
        perimeter+=isLandPerimeter(grid,row,col+1,maxRow,maxCol);
        //left
        perimeter+=isLandPerimeter(grid,row,col-1,maxRow,maxCol);
        return perimeter;
    }
}
