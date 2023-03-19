package com.leetcode.pattern;

/**
 * 28.
 * *
 * * *
 * * * *
 * * * * *
 * * * * * *
 * * * * *
 * * * *
 * * *
 * *
 */
public class Pattern8 {

    public static void main(String[] args) {
        printPatter(5);
    }

    public static void printPatter(int n) {
        for (int row = 0; row < 2 * n; row++) {
            int totalCols = row > n ?  2 * n - row : row;
            int totalSpace = n - totalCols ;

            for (int s = 0; s < totalSpace; s++) {
                System.out.print(" ");
            }

            for (int col = 0; col < totalCols; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
