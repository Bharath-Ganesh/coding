package com.leetcode.pattern;

/**
 * 5.
 * *
 * **
 * ***
 * ****
 * *****
 * ****
 * ***
 * **
 * *
 */
public class Pattern5 {

    public static void main(String[] args) {

        printPatter(5);
    }

    public static void printPatter(int n) {
        for (int row = 1; row < 2 * n; row++) {
            int temp;
            if (row > n) {
                temp = 2 * n - (row);
            } else {
                temp = row;
            }
            for (int col = 0; col < temp; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
