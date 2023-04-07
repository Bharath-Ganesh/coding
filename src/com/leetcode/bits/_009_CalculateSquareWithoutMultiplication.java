package com.leetcode.bits;


/**
 * https://www.geeksforgeeks.org/calculate-square-of-a-number-without-using-and-pow/
 * Given an integer n, calculate the square of a number without using *, / and pow().
 * <p>
 * Input: n = 5
 * Output: 25
 * <p>
 * Input: 7
 * Output: 49
 * <p>
 * Input: n = 12
 * Output: 144
 */
public class _009_CalculateSquareWithoutMultiplication {

    // Driver code
    public static void main(String[] args) {
        int n = -11;
        System.out.println(square(n));
    }

    public static int square(int n) {
        int square = 0;
        n = Math.abs(n);
        int temp = n;
        int pos = 0;
        while (temp != 0) {
            if ((temp & 1) == 1) {
                square += n << pos;
            }
            pos++;
            temp = temp >> 1;
        }
        return square;
    }


}
