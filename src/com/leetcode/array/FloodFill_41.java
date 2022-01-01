package com.leetcode.array;

import java.util.Arrays;

/**
 * 733. Flood Fill
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers row, col, and newColor. You should perform a flood fill on the image starting from the pixel image[row][col].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], row = 1, col = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (row, col) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */
public class FloodFill_41 {

    public static void main(String[] args) {
        int[][] image = {{0,0,0}, {0,0,0}};
        int row = 0, col = 0;
        int newColor = 0;
        int[][] output = floodFills(image, row, col, newColor);
        System.out.println(Arrays.deepToString(output));

    }

    public static int[][] floodFills(int[][] image, int sr, int sc, int color) {
        int startColor=image[sr][sc];
        dfs(image,sr,sc,startColor,color);
        return image;
    }

    public static void dfs(int[][] image,int i,int j,int startColor,int color) {

        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=startColor){
            return;
        }

        if(image[i][j]==startColor){
            image[i][j]=color;
        }

        // D, R , L, U
        dfs(image,i+1,j,startColor,color);
        dfs(image,i,j+1,startColor,color);
        dfs(image,i,j-1,startColor,color);
        dfs(image,i-1,j,startColor,color);
    }



    public static int[][] floodFillLeetcode(int[][] image, int row, int col, int newColor) {
        if (image[row][col] == newColor) {
            return image;
        }
        floodFillLeetcode(image, row, col,  image[row][col],newColor);
        return image;
    }

    public static void floodFillLeetcode(int[][] image, int row, int col, int oldColor, int newColor) {

        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }
        image[row][col] = newColor;

        floodFillLeetcode(image, row - 1, col, oldColor, newColor);
        floodFillLeetcode(image, row + 1, col, oldColor, newColor);
        floodFillLeetcode(image, row, col + 1, oldColor, newColor);
        floodFillLeetcode(image, row, col - 1, oldColor, newColor);
    }


    public static int[][] floodFill(int[][] image, int row, int col, int newColor) {
        if (image[row][col] == newColor) {
            return image;
        }
        floodFill(image, row, col, image[row][col], newColor);
        return image;
    }


    public static void floodFill(int[][] image, int row, int col, int oldColor, int newColor) {

        //index out of bound condition
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }
        image[row][col] = newColor;
        //update the color
        floodFill(image, row + 1, col, oldColor, newColor);
        floodFill(image, row, col + 1, oldColor, newColor);
        floodFill(image, row - 1, col, oldColor, newColor);
        floodFill(image, row, col - 1, oldColor, newColor);
    }

}
