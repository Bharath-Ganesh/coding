package com.leetcode.array;

/**
 * 188. Best Time to Buy and Sell Stock IV
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * <p>
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *  *
 */
public class _095_BestTimeToBuyAndSellStock4 {

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int k = 4;
        System.out.println(maxProfit(k, prices));
    }

    /**
     * O(n^2)
     */
    public static int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int profits[][] = new int[k + 1][prices.length];
        for (int transaction = 1; transaction <= k; transaction++) {
            int maxDiffProfitForTMinus1Transaction = Integer.MIN_VALUE;
            for (int day = 1; day < prices.length; day++) {
                int maxProfitforT = profits[transaction][day - 1];
                maxDiffProfitForTMinus1Transaction = Math.max(maxDiffProfitForTMinus1Transaction, profits[transaction - 1][day - 1] - prices[day - 1]);
                maxProfitforT = Math.max(maxDiffProfitForTMinus1Transaction+prices[day], maxProfitforT);
                profits[transaction][day] = maxProfitforT;
            }

        }
        return profits[k][prices.length - 1];
    }

    /**
     * o(n^3)
     */
    public static int maxProfitBruteForce(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int profits[][] = new int[k + 1][prices.length];
        for (int transaction = 1; transaction <= k; transaction++) {
            for (int day = 1; day < prices.length; day++) {
                int maxProfitforT = profits[transaction][day - 1];
                for (int previousDay = 0; previousDay < day; previousDay++) {
                    int profitTillTMinus1Transaction = profits[transaction - 1][previousDay];
                    int profitTillTthTransaction = prices[day] - prices[previousDay];
                    maxProfitforT = Math.max(profitTillTMinus1Transaction + profitTillTthTransaction, maxProfitforT);
                }
                profits[transaction][day] = maxProfitforT;
            }
        }
        return profits[k][prices.length - 1];
    }
}
