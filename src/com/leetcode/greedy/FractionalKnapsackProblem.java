package com.leetcode.greedy;

import com.leetcode.trees.heaps.BuildingHeapFromArray;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Fractional Knapsack
 * https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 */
public class FractionalKnapsackProblem {

//    class Item {
//        int value;
//        int weight;
//
//        Item(int x, int y) {
//            this.value = x;
//            this.weight = y;
//        }
//
//    }


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

//
//    double fractionalKnapsack(int W, Item arr[], int n) {
//
//
//        // Your code here
//        double maxProfit = 0.0;
//        if (arr == null) {
//            return maxProfit;
//        }
//        double w = W;
//
//        Comparator<Item> comparator = (o1, o2) -> {
//
//            double o1V_W = o1.value / o1.weight;
//            double o2V_W = o2.value / o2.weight;
//            return o1V_W > o2V_W ? -1 : o1V_W == o2V_W ? 0 : 1;
//        };
//
//        Arrays.sort(arr, comparator);
//        for (int i = 0; i < arr.length; i++) {
//            Item item = arr[i];
//            double weight = item.weight;
//            int value = item.value;
//
//            //maximise the profit
//            if (w > weight) {
//                maxProfit += value;
//                w -= weight;
//            } else {
//                maxProfit += (w / weight) * value;
//                break;
//            }
//        }
//        return maxProfit;
//    }

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }

    class Pair implements Comparable<Pair> {

        int qty;
        int price;


        public Pair(int qty, int price) {
            this.qty = qty;
            this.price = price;

        }

        public int compareTo(Pair p) {
            double netProfit = ((this.price) / this.qty * 1.0) - ((p.price) / p.qty * 1.0);
            if (netProfit > 0.0) {
                return -1;
            } else if (netProfit < 0.0) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) {
        // Your code here
        n=73;
        Pair[] list = new Pair[n];

        int i = 0;
        for (Item item : arr) {
            list[i++] = new Pair(item.weight, item.value);
        }

        Arrays.sort(list);
        double maxProfit = 0;
        for (Pair p : list) {

            if (w >= p.qty) {
                maxProfit += p.price;
                w -= p.qty;
            } else {
                maxProfit += ((double) w / p.qty) * p.price;
                break;
            }
        }
        return maxProfit;
    }
}
