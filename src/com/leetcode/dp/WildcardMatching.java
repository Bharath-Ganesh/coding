package com.leetcode.dp;

public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching obj = new WildcardMatching();

        String word = "aaaa";
        String pattern = "aa";
        System.out.println(obj.isMatch(word, pattern));
    }

    public boolean isMatch(String word, String pattern) {
        int n = pattern.length();
        int m = word.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {
                if (i == n && j == m) {
                    dp[i][j] = true;
                } else if (i == n) {
                    dp[i][j] = false;
                } else if (j == m) {
                    dp[i][j] = pattern.charAt(i) == '*' ? dp[i + 1][j] : false;
                } else {
                    if (word.charAt(j) == pattern.charAt(i)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (pattern.charAt(i) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (pattern.charAt(i) == '*') {
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

//    public boolean isMatch(String s, String p) {
//
//        int n=s.length();
//        int m=p.length();
//        Boolean[][] dp=new Boolean[n][m];
//        return isMatch(s,p,n-1,m-1,dp);
//    }


    public boolean isMatch(String s, String p, int i, int j, Boolean[][] dp) {

        if (i < 0 || j < 0) return true;
        if (i < 0 && j >= 0) {
            for (int j1 = 0; j <= j; j++) {
                if (p.charAt(j1) != '*') return false;
            }
            return true;
        }
        if(j<0 && i>=0) return false;

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = isMatch(s, p, i - 1, j - 1, dp);
        }
        if (p.charAt(j) == '*') {
            if (isMatch(s, p, i, j - 1, dp) || isMatch(s, p, i - 1, j, dp)) {
                return dp[i][j] = true;
            }
        }
        return dp[i][j] = false;
    }

//    public boolean isMatch(String word, String pattern, int i, int j, boolean[][] dp) {
//
//        if (dp[i][j] == true) return dp[i][j];
//        if (i == 0 && j == 0) return true;
//        if (j == 0 && i > 0) return false;
//        if (i == 0 && j > 0) {
//            for (int index = 1; index <=j; index++) {
//                if (pattern.charAt(index - 1) != '*') return false;
//            }
//            return true;
//        }
//
//
//        if (word.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '?') {
//            return dp[i][j] = isMatch(word, pattern, i - 1, j - 1, dp);
//        } else if (pattern.charAt(j - 1) == '*') {
//            return dp[i][j] = isMatch(word, pattern, i, j - 1, dp) || isMatch(word, pattern, i - 1, j, dp);
//        }
//        return false;
//    }
}
