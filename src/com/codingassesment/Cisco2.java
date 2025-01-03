package com.codingassesment;

import java.util.HashMap;
import java.util.Map;

public class Cisco2 {


    // Method to find the last cell Lucy hops onto
    public static int findLastHopCell(int[][] matrix, int rows, int cols) {

        boolean[][] visited = new boolean[rows][cols]; // Track visited cells
        int row = 0, col = 0; // Starting at (1, 1) or (0, 0) in 0-indexed matrix
        int direction = 1; // Start by moving down
        int[] rowChange = { 0, 1, 0, -1 }; // For changing rows
        int[] colChange = { 1, 0, -1, 0 }; // For changing columns

        int totalSteps = rows * cols;
        int steps = 0;
        int lastCellValue = matrix[row][col];

        while (steps < totalSteps) {
            // Mark current cell as visited
            visited[row][col] = true;
            steps++; // Increment steps

            // Move to the next cell
            int nextRow = row + rowChange[direction];
            int nextCol = col + colChange[direction];

            // Check if new position is valid
            if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !visited[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
                if (steps % 2 == 0) { // Skip alternate cells
                    lastCellValue = matrix[row][col];
                }
            } else {
                // Change direction (anti-clockwise)
                direction = (direction + 1) % 4;
            }
        }

        return lastCellValue;
    }

    public static int findLastHopCell1(int[][] matrix, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols]; // Track visited cells
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int hops = 0;
        int lastHopValue = -1;

        while (top <= bottom && left <= right) {
            // Traverse down the left column
            for (int i = top; i <= bottom; i++) {
                if (!visited[i][left]) {
                    if (hops % 2 == 0) {
                        lastHopValue = matrix[i][left];
                    }
                    visited[i][left] = true;
                    hops++;
                }
            }
            left++;

            // Traverse right across the bottom row
            for (int i = left; i <= right; i++) {
                if (!visited[bottom][i]) {
                    if (hops % 2 == 0) {
                        lastHopValue = matrix[bottom][i];
                    }
                    visited[bottom][i] = true;
                    hops++;
                }
            }
            bottom--;

            // Traverse up the right column
            for (int i = bottom; i >= top; i--) {
                if (!visited[i][right]) {
                    if (hops % 2 == 0) {
                        lastHopValue = matrix[i][right];
                    }
                    visited[i][right] = true;
                    hops++;
                }
            }
            right--;

            // Traverse left across the top row
            for (int i = right; i >= left; i--) {
                if (!visited[top][i]) {
                    if (hops % 2 == 0) {
                        lastHopValue = matrix[top][i];
                    }
                    visited[top][i] = true;
                    hops++;
                }
            }
            top++;
        }

        return lastHopValue;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[][] matrix = { { 29, 8, 37 }, { 15, 41, 3 }, { 1, 10, 14 } };
        System.out.println(findLastHopCell1(matrix, n, m));
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        int hops = 0;
        int lastHopValue = -1;

        while (top <= bottom && left <= right) {
            // Traverse down the left column
            for (int i = top; i <= bottom; i++) {
                if (hops % 2 == 0) {
                    lastHopValue = matrix[i][left];
                }
                hops++;
            }
            left++;

            // Traverse right across the bottom row
            for (int i = left; i <= right; i++) {
                if (hops % 2 == 0) {
                    lastHopValue = matrix[bottom][i];
                }
                hops++;
            }
            bottom--;

            // Traverse up the right column
            for (int i = bottom; i >= top; i--) {
                if (hops % 2 == 0) {
                    lastHopValue = matrix[i][right];
                }
                hops++;
            }
            right--;

            // Traverse left across the top row
            for (int i = right; i >= left; i--) {
                if (hops % 2 == 0) {
                    lastHopValue = matrix[top][i];
                }
                hops++;
            }
            top++;
        }

        System.out.println(lastHopValue);
    }

}
