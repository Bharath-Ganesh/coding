package com.leetcode.array;

import java.util.Arrays;

/**
 *
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Input: prices = [7,6,5,4,3,2,1]
 * Output: 0
 */
public class _002_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,6,5,4,3,2,1};
        int maxProfit = maxProfitLeetcode(prices);
        System.out.println(maxProfit);
    }

    public static int maxProfit(int[] prices) {

        int maxProfit=0;
        int minProfit=prices[0];
        for(int i=1;i<prices.length;i++){
            minProfit=Math.min(prices[i],minProfit);
            maxProfit=Math.max(maxProfit,prices[i]-minProfit);
        }
        return maxProfit;
    }

    public static int maxProfitLeetcode(int[] prices) {
       int minPrice=prices[0];
       int maxProfit=0;
       for(int i=1;i<prices.length;i++){
           maxProfit=Math.max(prices[i]-minPrice,maxProfit);
           minPrice=Math.min(minPrice,prices[i]);
       }
       return maxProfit;
    }
}
