package com.leetcode.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        String text1 = "zaaface", text2 = "fabcde";
        String s = obj.longestCommonSubsequence(text1, text2);
        System.out.println(s);
    }

    public String longestCommonSubsequence(String text1, String text2) {
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
        int length=dp[n][m];
        char[] lcs=new char[length];

        int i=n,j=m;

        while (i>0 && j>0) {
            int val = dp[i][j];
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs[--length] = text1.charAt(i - 1);
                i--;
                j--;
            } else if (val == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        return new String(lcs);
    }
}
