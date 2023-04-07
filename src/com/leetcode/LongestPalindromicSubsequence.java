package com.leetcode;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        String s = "agbdba";
        System.out.println(obj.longestPalindromeSubseq(s));
    }

    public String longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; j++, i++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (gap == 1) {
                        dp[i][j] = b ? 2 : 1;
                    } else {
                        if (b) {
                            dp[i][j] = 2 + dp[i + 1][j - 1];
                        } else {
                            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                        }
                    }
                }
            }
        }

        int length = dp[0][n - 1];
        if (length == 0) return "";
        char[] answer = new char[length];
        int start = 0, end = length - 1;
        int i = 0, j = n - 1;
        while (dp[i][j] != 0) {
            int element = dp[i][j];
            if (s.charAt(i) == s.charAt(j)) {
                answer[start++] = s.charAt(i);
                answer[end--] = s.charAt(i);
                i++;
                j--;
            } else if (dp[i + 1][j] == element) {
                i++;
            } else {
                j--;
            }
        }
        return new String(answer);

    }
}
