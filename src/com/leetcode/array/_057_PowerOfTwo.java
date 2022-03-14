package com.leetcode.array;

/**
 * 231. Power of Two
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 *
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 *
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 */
public class _057_PowerOfTwo {

    public static void main(String[] args) {
        int n=16;
        System.out.println(isPowerOfTwo(n));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0 || n < 0) {
            return false;
        }
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
