package com.leetcode.array;

/**
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
 * <p>
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 * <p>
 * Input: n = 5
 * Output: 2
 * Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 */
public class _058_ComplementOfBase10Integer {

    public static void main(String[] args) {
        int n = 25;
        System.out.println(bitwiseComplement(n));
    }

    public static int bitwiseComplement(int n) {
        int complementDecimal = 0;
        StringBuilder complementDecimalString = new StringBuilder();
        //25
        //  25%2=   1  ; 12
        //  12%2=   0  ; 6
        //  6%2=    0  ; 3
        //  3%2=    1  ; 1
        //  1%2=    1  ; 0
        // 10011
        while (n > 0) {
            int remainder = n % 2;
            n = n / 2;
            complementDecimalString.append(remainder);
        }
        complementDecimal=Integer.valueOf(complementDecimalString.reverse().toString());
        return complementDecimal;
    }
}
