package com.leetcode.pattern;

/**
 * *****
 * *****
 * *****
 * *****
 * *****
 */
public class Pattern1 {
    public static void main(String[] args) {
        printPatter();
    }

    public static void printPatter() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
