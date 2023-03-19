package com.leetcode.array;

/**
 * https://leetcode.com/problems/powx-n/
 */
public class Power {

    public static void main(String[] args) {
        Power obj = new Power();
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(obj.myPow(x, n));
    }

    public double myPow(double x, int n) {

        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            x = x * x;
            n = n / 2;
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
