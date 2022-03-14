package com.leetcode.recursion;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/fibonacci-number/
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
 * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * <p>
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * <p>
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 */
public class _001_Fibanocci {

    public static void main(String[] args) {
        int n = 50;
        long[] temp = new long[ n + 1];
        Arrays.fill(temp, -1);
        System.out.println(fibIterative(n));
        System.out.println(fibRecursiveWithMemoization(n, temp));

    }

    public static long fibRecursiveWithMemoization(int n, long[] temp) {

        if (n <= 1) {
            return n;
        }
        if (temp[n] != -1) {
            return temp[n];
        }
        long fibN = fibRecursiveWithMemoization(n - 1, temp) + fibRecursiveWithMemoization(n - 2, temp);
        temp[n] = fibN;
        return fibN;
    }


    public static long fibRecursive(long n) {

        if (n <= 1) {
            return n;
        }
        long fibN = fibRecursive(n - 1) + fibRecursive(n - 2);
        return fibN;
    }

    public static long fibIterative(int n) {
        long sum = 0;
        if (n <= 1) {
            return n;
        }
        long lastSum = 1;
        long prevLastSum = 0;
        for (int i = 2; i <= n; i++) {
            sum = prevLastSum + lastSum;
            prevLastSum = lastSum;
            lastSum = sum;
        }
        return sum;
    }

}
