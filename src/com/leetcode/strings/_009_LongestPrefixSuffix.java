package com.leetcode.strings;

/**
 * Longest Prefix Suffix
 * Given a string of characters, find the length of the longest proper prefix which is also a proper suffix.
 * <p>
 * NOTE: Prefix and suffix can be overlapping but they should not be equal to the entire string.
 * <p>
 * Input: s = "abab"
 * Output: 2
 * Explanation: "ab" is the longest proper
 * prefix and suffix.
 * <p>
 * Input: s = "aaaa"
 * Output: 3
 * Explanation: "aaa" is the longest proper
 * prefix and suffix.
 */
public class _009_LongestPrefixSuffix {

    public static void main(String[] args) {
        String word = "abababa";
        System.out.println(lps(word));
    }

    private static int lps(String word) {
        // code here
        if (word.length() == 1) {
            return 0;
        }

        int[] lps = new int[word.length()];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        int n = word.length();
        while (i < n) {
            if (word.charAt(i) == word.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else // (pat[i] != pat[len])
            {
                len = 0;
                lps[i] = len;
                i++;

            }
        }
        return 0;
    }
}
