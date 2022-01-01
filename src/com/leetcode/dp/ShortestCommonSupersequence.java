package com.leetcode.dp;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        ShortestCommonSupersequence obj = new ShortestCommonSupersequence();
        String s1 = "cab";
        String s2 = "abac";
        System.out.println(obj.shortestCommonSupersequence(s1, s2));
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int[][] dp=longestCommonSubsequence(str1,str2);
        int lcs=dp[n][m];
        int length=n+m-lcs;
        char[] word=new char[length];

        int i=n,j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                word[--length]=str1.charAt(i-1);
                i--;j--;
            }else if(dp[i-1][j]==dp[i][j]){
                word[--length]=str1.charAt(i-1);
                i--;
            }else{
                word[--length]=str2.charAt(j-1);
                j--;
            }
        }

        while(i>0){
            word[--length]=str1.charAt(i-1);
            i--;
        }

        while(j>0){
            word[--length]=str2.charAt(j-1);
            j--;
        }
        return new String(word);
    }

    public int[][] longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp;
    }

//    public String shortestCommonSupersequence(String word1, String word2) {
//        int n = word1.length();
//        int m = word2.length();
//        int[][] dp = new int[n + 1][m + 1];
//        int len = lcs(word1, word2, dp);
//        if (len == n) {
//            return word2;
//        } else if (len == m) {
//            return word1;
//        }
//        int length = (n + m) - len;
//        char[] shortestCommonSuperSequence = new char[length];
//        int i = n;
//        int j = m;
//        while (i > 0 && j > 0) {
//            int left = dp[i][j - 1];
//            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                shortestCommonSuperSequence[--length] = word1.charAt(i - 1);
//                i--;
//                j--;
//            } else if (dp[i][j] == left) {
//                shortestCommonSuperSequence[--length] = word2.charAt(j - 1);
//                j--;
//            } else {
//                shortestCommonSuperSequence[--length] = word1.charAt(i - 1);
//                i--;
//            }
//        }
//        while (i > 0) shortestCommonSuperSequence[--length] = word1.charAt(--i);
//
//        while (j > 0) shortestCommonSuperSequence[--length] = word2.charAt(--j);
//
//        return new String(shortestCommonSuperSequence);
//    }
//
//    public int lcs(String word1, String word2, int[][] dp) {
//        int n = word1.length();
//        int m = word2.length();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//
//                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                    dp[i][j] = 1 + dp[i - 1][j - 1];
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[n][m];
//
//    }
//
//    private void printCommonSubsequence(int[][] dp, String word1, String word2) {
//
//        int n = word1.length();
//        int m = word2.length();
//        int i = n;
//        int j = m;
//        int length = dp[n][m];
//        char[] commonSubsequence = new char[length];
//        while (i > 0 && j > 0) {
//            int left = dp[i][j - 1];
//            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
//                commonSubsequence[--length] = word1.charAt(i - 1);
//                i--;
//                j--;
//            } else if (dp[i][j] == left) {
//                j--;
//            } else {
//                i--;
//            }
//        }
//        System.out.println(new String(commonSubsequence));
//    }


}
