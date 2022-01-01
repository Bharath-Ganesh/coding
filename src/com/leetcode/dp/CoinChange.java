package com.leetcode.dp;

/**
 * https://leetcode.com/problems/coin-change-ii/
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(obj.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }


}
