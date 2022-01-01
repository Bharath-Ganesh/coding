package com.leetcode.array;

/**
 * 69. Sqrt(x)
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * <p>
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5
 */
public class SquareRoot_25 {

    public static void main(String[] args) {
        int x = 9;
        System.out.println(mySqrt(2147395599));
    }


    public static int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                end = mid;
                break;
            } else if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return end;
    }
}
