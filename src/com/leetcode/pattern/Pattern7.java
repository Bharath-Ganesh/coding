package com.leetcode.pattern;

/**
 * 6.
 * *
 * **
 * ***
 * ****
 * *****
 */
public class Pattern7 {

    public static void main(String[] args) {
        printPatter(5);
    }

    public static void printPatter(int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= n - 1; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
