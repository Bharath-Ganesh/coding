package com.leetcode.dp;

/**
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

    public static void main(String[] args) {
        EditDistance obj=new EditDistance();
        String word1 = "horse",  word2 = "ros";
        System.out.println(obj.minDistance(word1,word2));
    }


    public int minDistance(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0){
                    dp[i][j]=j;
                }else if(j==0){
                    dp[i][j]=i;
                }else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int replace=dp[i-1][j-1];
                    int insert=dp[i][j-1];
                    int delete=dp[i-1][j];
                    int minOperation=1+Math.min(Math.min(replace,insert),delete);
                    dp[i][j]=minOperation;
                }
            }
        }
        return dp[n][m];
    }
}

