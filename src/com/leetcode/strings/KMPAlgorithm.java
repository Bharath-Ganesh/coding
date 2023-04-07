package com.leetcode.strings;


import java.util.HashMap;

/**
 * https://www.geeksforgeeks.org/kmp-algorithm-for-pattern-searching/
 */
public class KMPAlgorithm {
    public static void main(String[] args) {
        KMPAlgorithm obj = new KMPAlgorithm();
        String word = "THIS IS A TEST TEST";
        String pattern = "TEST";
        obj.longestPrefix(word, pattern);
    }

    public void longestPrefix(String word, String pattern) {
        int[] lps = new int[word.length()];

        computeLPS(lps, pattern);
        int i = 0;
        int j = 0;
        while (i < word.length()) {
            if (word.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == pattern.length()) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }
        }
    }

    private void computeLPS(int[] lps, String word) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < word.length()) {
            if (word.charAt(i) == word.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i++] = 0;
                } else {
                    len = lps[len - 1];
                }
            }
        }
    }

}
