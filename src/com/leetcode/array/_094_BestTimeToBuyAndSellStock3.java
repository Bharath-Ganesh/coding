package com.leetcode.array;

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
        int[] arr = {1,2,3,4,5};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice=prices[0];
        int[] sellPrices=new int[prices.length];
        sellPrices[0]=0;
        for(int i=1;i<prices.length;i++){
            minBuyPrice=Math.min(minBuyPrice,prices[i]);
            sellPrices[i]=Math.max(prices[i]-minBuyPrice,sellPrices[i-1]);
        }


        int[] buyPrices=new int[prices.length];
        int maxSoldPrice=prices[prices.length-1];
        buyPrices[prices.length-1]=0;
        for(int i=prices.length-2;i>=0;i--){
            maxSoldPrice=Math.max(maxSoldPrice,prices[i]);
            buyPrices[i]=Math.max(maxSoldPrice-prices[i],buyPrices[i+1]);
        }

        for(int i=0;i<prices.length;i++){
            maxProfit=Math.max(buyPrices[i]+sellPrices[i],maxProfit);
        }
        return maxProfit;

    }
}
