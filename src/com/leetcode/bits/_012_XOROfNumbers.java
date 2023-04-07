package com.leetcode.bits;

/**
 * Find XOR of all numbers from A to B
 */
public class _012_XOROfNumbers {

    public static void main(String[] args) {
        int a = 3;
        int b = 10;
        System.out.println(findXOROfNumFromAtoB(a, b));
    }

    private static int findXOROfNumFromAtoB(int a, int b) {
        int xorTillB = XOR(b);
        int xorTillAMinus1 = XOR(a - 1);
        return xorTillAMinus1 ^ xorTillB;
    }

    private static int XOR(int a) {
        if (a % 4 == 0) {
            return a;
        } else if (a % 4 == 1) {
            return 1;
        } else if (a % 4 == 2) {
            return a + 1;
        } else {
            return 0;
        }
    }
}
