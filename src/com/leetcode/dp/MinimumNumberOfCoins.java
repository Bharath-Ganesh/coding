package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class MinimumNumberOfCoins {

    public static void main(String[] args) {
        MinimumNumberOfCoins c = new MinimumNumberOfCoins();
        int[] coins = {1, 5, 2};
        int amount = 12;
        int minCoins = c.coinChange(coins, amount);
        System.out.println(minCoins);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // more convenient to have the coins sorted
        dp[0] = 0;
        Arrays.sort(coins);
        // populating our dp array
        for (int i = 1; i <= amount; i++) {
            // setting dp[0] base value to 1, 0 for all the rest
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (i - c < 0) break;
                // if it was a previously not reached cell, we do not add use it
                if (dp[i - c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
