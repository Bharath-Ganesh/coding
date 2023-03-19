package com.leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinNumberOfCoins {

    public static void main(String[] args) {
        FindMinNumberOfCoins obj = new FindMinNumberOfCoins();
        int amount = 71;
        int minCoins = findMinNumberOfCoins(amount);
        System.out.println(minCoins);
    }

    private static int findMinNumberOfCoins(int amount) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int currIndex = coins.length - 1;
        List<Integer> totalCoins = new ArrayList<>();
        while (currIndex >= 0) {
            if (amount == 0) {
                break;
            } else if (coins[currIndex] <= amount) {
                amount -= coins[currIndex];
                totalCoins.add(coins[currIndex]);
            } else {
                currIndex--;
            }
        }
        return amount == 0 ? totalCoins.size() : -1;
    }

}
