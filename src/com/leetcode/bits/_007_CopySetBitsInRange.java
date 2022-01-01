package com.leetcode.bits;

/**
 * https://www.geeksforgeeks.org/copy-set-bits-in-a-range/
 * <p>
 * Given two numbers x and y, and a range [l, r] where 1 <= l, r <= 32. The task is consider set bits of y in range [l, r] and set these bits in x also.
 * <p>
 * Input  : x = 10, y = 13, l = 2, r = 3
 * Output : x = 14
 * Binary representation of 10 is 1010 and
 * that of y is 1101. There is one set bit
 * in y at 3'rd position (in given range).
 * After we copy this bit to x, x becomes 1110
 * which is binary representation of 14.
 * <p>
 * Input  : x = 8, y = 7, l = 1, r = 2
 * Output : x = 11
 */
public class _007_CopySetBitsInRange {

    public static void main(String[] args) {
        int x = 10, y = 13, l = 2, r = 3;
        x = copySetBits(x, y, l, r);
        System.out.print("Modified x is " + x);
    }

    private static int copySetBits(int x, int y,
                                   int left, int right) {
        int mask= 1<<(right-left+1);
        mask=mask-1;
        mask=mask<<left-1;
        mask=mask&y;
        x=x | mask;
        return x;
    }
}
