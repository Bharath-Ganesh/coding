package com.leetcode.pattern;

/**
                 *
            *
        *
     *
 *

 */
public class Pattern6 {
    public static void main(String[] args) {
        printPatter(5);
    }

    public static void printPatter(int n) {
        for (int i = 5; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                if (j == i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
