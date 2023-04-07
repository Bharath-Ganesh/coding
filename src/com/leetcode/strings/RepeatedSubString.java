package com.leetcode.strings;

/**
 * \
 * https://leetcode.com/problems/repeated-substring-pattern/
 * 459. Repeated Substring Pattern
 */
public class RepeatedSubString {
    public static void main(String[] args) {
        RepeatedSubString obj = new RepeatedSubString();
        String s = "aba";
        System.out.println(obj.repeatedSubstringPatternKMP(s));
    }

    public boolean repeatedSubstringPatternBruteForce(String s) {
        int n = s.length();
        for (int len = n / 2; len >= 1; len--) {
            if (n % len == 0) {
                int numberOfTimes = n / len;
                String substring = s.substring(0, len );
                StringBuilder concat = new StringBuilder();
                for (int j = 0; j < numberOfTimes; j++) {
                    concat.append(substring);
                }
                if (s.equals(concat.toString())) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean repeatedSubstringPatternKMP(String s) {
        int n = s.length(), prevLPS = 0, i = 1;
        int[] lps = new int[n];
        while (i < n) {
            if (s.charAt(i) == s.charAt(prevLPS)) {
                lps[i++] = ++prevLPS;
            } else if (prevLPS == 0) {
                lps[i++] = 0;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }
        return lps[n - 1] > 0 && n % (n - lps[n - 1]) == 0;
    }
}
