package com.leetcode.dp;

import java.util.Arrays;

public class BooleanParenthesization {

    public static void main(String[] args) {
        String S = "T|T&F^T";
        System.out.println(countWays(S.length(), S));
    }

    static int countWays(int n, String S){
        // code here
        long[][][] dp=new long[n][n][2];
        Arrays.stream(dp).forEach(x->{
            Arrays.stream(x).forEach(y->Arrays.fill(y,-1));
        });
        return (int) (countWays(0,n-1,S,1,dp)%1003);
    }


    static long countWays(int i,int j,String word,int isTrue,long[][][] dp){

        if(i>j) return 0;

        if(i==j){
            if(isTrue==1){
                return word.charAt(i)=='T'?1:0;
            }else{
                return word.charAt(i)=='F'?1:0;
            }
        }
        if(dp[i][j][isTrue]!=-1){
            return dp[i][j][isTrue];
        }

        long ways=0;
        for(int index=i+1;index<=j-1;index+=2){

            long leftTrue=countWays(i,index-1,word,1,dp);
            long leftFalse=countWays(i,index-1,word,0,dp);
            long rightTrue=countWays(index+1,j,word,1,dp);
            long rightFalse=countWays(index+1,j,word,0,dp);

            char operator=word.charAt(index);
            if(operator=='&'){
                if(isTrue==1){
                    ways+=rightTrue*leftTrue;
                }else{
                    ways+=leftTrue*rightFalse+leftFalse*rightTrue+leftFalse*rightFalse;
                }
            }else if(operator=='|'){
                if(isTrue==1){
                    ways+=leftTrue*rightFalse+leftFalse*rightTrue+leftTrue*rightTrue;
                }else{
                    ways+=leftFalse*rightFalse;
                }
            }else{
                if(isTrue==1){
                    ways+=leftTrue*rightFalse+leftFalse*rightTrue;
                }else{
                    ways+=leftTrue*rightTrue+leftFalse*rightFalse;
                }
            }
        }
        return dp[i][j][isTrue] = ways;

    }
}
