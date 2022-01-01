package com.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Fractional Knapsack
 * https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 */
public class FractionalKnapsackProblem {

    class Item {
        int value;
        int weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }

    }


    public static void main(String[] args) {
        FractionalKnapsackProblem obj = new FractionalKnapsackProblem();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        Item[] arr = new Item[n];
        int count = 0;
        int index = 0;
        scanner.nextLine();
        String items[] = scanner.nextLine().split(" ");
        while (n-- > 0) {
            int profit = Integer.parseInt(items[count++]);
            int weight = Integer.parseInt(items[count++]);
            arr[index++] = obj.new Item(profit, weight);
        }
        double v = obj.fractionalKnapsack(w, arr, n);
        System.out.println("Maximum profit : " + v);
    }


    double fractionalKnapsack(int W, Item arr[], int n) {


        // Your code here
        double maxProfit = 0.0;
        if (arr == null) {
            return maxProfit;
        }
        double w = W;

        Comparator<Item> comparator = (o1, o2) -> {

            double o1V_W = o1.value / o1.weight;
            double o2V_W = o2.value / o2.weight;
            return o1V_W > o2V_W ? -1 : o1V_W == o2V_W ? 0 : 1;
        };

        Arrays.sort(arr, comparator);
        for (int i = 0; i < arr.length; i++) {
            Item item = arr[i];
            double weight = item.weight;
            int value = item.value;

            //maximise the profit
            if (w > weight) {
                maxProfit += value;
                w -= weight;
            } else {
                maxProfit += (w / weight) * value;
                break;
            }
        }
        return maxProfit;
    }
}
