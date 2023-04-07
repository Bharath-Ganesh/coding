package com.leetcode.pattern;

/**
 * *****
 * ****
 * ***
 * **
 * *
 */
public class Pattern3 {

    public static void main(String[] args) {
        printPatter();
    }

    public static void printPatter() {
        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
