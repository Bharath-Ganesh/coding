package com.leetcode.array;

import java.util.ArrayList;

/**
 * 123. Best Time to Buy and Sell Stock III
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * <p>
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 */
public class _094_BestTimeToBuyAndSellStock3 {

    public static void main(String[] args) {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {

        //Two transactions are allowed
        // So we divide the problems into two subparts
        int maxProfit = 0;
        //1 transaction => For any particular day, if it's mandatory to sell the stock
        // then we would look to the left(past prices) to find the minimum buy price
        int sp[] = new int[prices.length];
        ;
        int minBuyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minBuyPrice = Math.min(minBuyPrice, prices[i]);
            sp[i] = Math.max(prices[i] - minBuyPrice,sp[i-1]);
        }


        // 2 transaction => For any particular day, if it's mandatory to buy the stock
        // then we would look to the right(future prices) to find the maximum selling price
        int bp[] = new int[prices.length];
        int maxSellingPrice = prices[prices.length - 1];
        maxProfit = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            maxSellingPrice = Math.max(maxSellingPrice, prices[i]);
            bp[i] = Math.max(maxSellingPrice - prices[i],bp[i+1]);
        }


        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, bp[i] + sp[i]);
        }
        return maxProfit;
    }
}
