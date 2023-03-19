package com.leetcode.pattern;

/**
 * 2.
 * *
 * **
 * ***
 * ****
 * *****
 */
public class Pattern2 {

    public static void main(String[] args) {
        printPatter();
    }

    public static void printPatter() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
