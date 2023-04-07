package com.leetcode.strings;

/**
 * Min Number of Flips
 * https://practice.geeksforgeeks.org/problems/min-number-of-flips3210/1
 * Given a binary string, that is it contains only 0s and 1s. We need to make this string
 * a sequence of alternate characters by flipping some of the bits, our goal is to minimize the number of bits to be flipped.
 * <p>
 * S = "001"
 * Output: 1
 * Explanation:
 * We can flip the 0th bit to 1 to have
 * 101.
 * <p>
 * S = "0001010111"
 * Output: 2
 * Explanation: We can flip the 1st and 8th bit
 * bit to have "0101010101"
 * 101.
 */
public class _018_MinNumberOfFlips {

    public static void main(String[] args) {
        String word = "0001010111";
        System.out.println(minFlips(word));
    }

    public static int minFlips(String word) {
        // Code here
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i % 2 == 0 && word.charAt(i) == '0' || i % 2 != 0 && word.charAt(i) == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        return Math.min(oneCount, zeroCount);


    }

}
