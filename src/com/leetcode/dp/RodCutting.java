package com.leetcode.dp;

public class RodCutting {
    public static void main(String[] args) {
        RodCutting r = new RodCutting();
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        System.out.println(r.cutRod(price, n));
    }

//    public int cutRod(int price[], int n) {
//        //code here
//
//        int[][] dp = new int[n][n + 1];
//
//        for (int i = 0; i <= n; i++) {
//            dp[0][i] = i * price[0];
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int length = 1; length <= n; length++) {
//                int val = price[i];
//                int notTake = dp[i - 1][length];
//                int take = Integer.MIN_VALUE;
//                if (length >= i + 1) {
//                    take = val + dp[i ][length - (i+1)];
//                }
//                dp[i][length] = Math.max(take, notTake);
//            }
//        }
//        return dp[n - 1][n];
//    }

    public int cutRod(int price[], int n) {
        //code here

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = Integer.MIN_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MIN_VALUE;
                int amount = price[i - 1];
                if (j >= i) {
                    int val = dp[i][j - i];
                    if (val != Integer.MIN_VALUE) {
                        take = amount + val;
                    }
                }
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n][n];
    }
}
