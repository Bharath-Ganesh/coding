package com.leetcode.dp;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        String word = "mississippi";
        String pattern = "mis*is*ip*.";
        System.out.println(obj.isMatch(word, pattern));
    }

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();
        Boolean[][] dp = new Boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 2][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    char prevChar = p.charAt(i - 2);
                    char wordChar = s.charAt(j - 1);

                    dp[i][j] = dp[i - 2][j];
                    if (prevChar == wordChar || prevChar == '.') {
                        dp[i][j] = dp[i][j] | dp[i][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

//    public boolean isMatch(String word, String pattern) {
//
//        int n = pattern.length();
//        int m = word.length();
//
//        boolean[][] dp = new boolean[n + 1][m + 1];
//
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                if (i == 0 && j == 0) {
//                    dp[i][j] = true;
//                } else if (i == 0) {
//                    dp[i][j] = false;
//                } else if (j == 0) {
//                    dp[i][j] = pattern.charAt(i - 1) == '*' ? dp[i - 2][j] : false;
//                } else {
//                    char sc = word.charAt(j - 1);
//                    char pc = pattern.charAt(i - 1);
//
//                    if (sc == pc) {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    } else if (pc == '.') {
//                        dp[i][j] = dp[i - 1][j - 1];
//                    } else if (pc == '*') {
//                        dp[i][j] = dp[i - 2][j];
//                        if (pattern.charAt(i - 2) == sc || pattern.charAt(i - 2) == '.') {
//                            dp[i][j] = dp[i][j] || dp[i][j-1];
//                        }
//                    } else {
//                        dp[i][j] = false;
//                    }
//                }
//            }
//        }
//        return dp[n][m];
//    }
}
