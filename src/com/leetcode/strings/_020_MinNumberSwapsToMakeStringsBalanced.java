package com.leetcode.strings;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 * <p>
 * A string is called balanced if and only if:
 * <p>
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * You may swap the brackets at any two indices any number of times.
 * <p>
 * Return the minimum number of swaps to make s balanced.
 * <p>
 * Input: s = "]]][[["
 * Output: 2
 * Explanation: You can do the following to make the string balanced:
 * - Swap index 0 with index 4. s = "[]][][".
 * - Swap index 1 with index 5. s = "[[][]]".
 * The resulting string is "[[][]]".
 */
public class _020_MinNumberSwapsToMakeStringsBalanced {

    public static void main(String[] args) {
        String word = "]]][[[";
        System.out.println(minSwaps(word));
    }

    public static int minSwaps(String word) {

        int minSwaps = 0;
        int i = 0;
        char[] brackets = word.toCharArray();
        int extraClosingBracket = 0;
        int maxClosingBracket = 0;
        while (i < brackets.length) {
            Character ch = brackets[i];
            if (ch == ']') {
                extraClosingBracket += 1;
            } else {
                extraClosingBracket -= 1;
            }
            maxClosingBracket = Math.max(maxClosingBracket, extraClosingBracket);
            i++;
        }
        minSwaps = (maxClosingBracket + 1) / 2;
        return minSwaps;
    }
}
