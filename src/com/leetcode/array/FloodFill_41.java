package com.leetcode.array;

import java.util.Arrays;

/**
 * 733. Flood Fill
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */
public class FloodFill_41 {

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1;
        int newColor = 2;
        int[][] output = floodFill(image, sr, sc, newColor);
        System.out.println(Arrays.deepToString(output));

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        floodFill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }


    public static void floodFill(int[][] image, int sr, int sc, int source, int newColor) {

        //index out of bound condition
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc]!=source) {
            return;
        }
        image[sr][sc] = newColor;
        //update the color
        floodFill(image, sr + 1, sc, source, newColor);
        floodFill(image, sr, sc + 1, source, newColor);
        floodFill(image, sr - 1, sc, source, newColor);
        floodFill(image, sr, sc - 1, source, newColor);
    }

}
