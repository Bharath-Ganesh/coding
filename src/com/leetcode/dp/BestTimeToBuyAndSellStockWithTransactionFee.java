package com.leetcode.dp;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        System.out.println(obj.maxProfit(prices, fee));
    }


    public int maxProfit(int[] prices, int fee) {

        int maxProfit = 0;
        int minPrice = 0;
        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < prices[minPrice]) minPrice = i;

            if (prices[i] > prices[minPrice] && prices[i] - prices[minPrice] > fee) {
                maxProfit += (prices[i] - prices[minPrice]) - fee;
                minPrice = i;
            }
        }
        return maxProfit;
    }
}
