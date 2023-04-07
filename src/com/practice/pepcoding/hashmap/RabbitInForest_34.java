package com.practice.pepcoding.hashmap;

import java.util.*;

/**
 * There is a forest with an unknown number of rabbits. We asked n rabbits "How many rabbits have the same color as you?" and collected the answers in an integer array answers where answers[i] is the answer of the ith rabbit.
 * <p>
 * Given the array answers, return the minimum number of rabbits that could be in the forest.
 * <p>
 * 100
 * 3 6 8 3 1 7 2 6 3 2 3 10 1 2 3 6 8 2 5 2 2 2 6 4 10 5 4 5 5 6 3 1 7 10 4 9 2 4 8 5 2 2 7 10 5 5 6 5 4 4 3 6 6 1 5 3 5 4 10 10 9 1 5 2
 * 3 6 8 8 3 3 8 10 1 3 7 9 5 10 2 5 5 3 1 10 8 3 8 9 7 10 7 4 8 7 6 10 9 4 5 8
 */
public class RabbitInForest_34 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int count = rabbitInForest(arr);
        System.out.println(count);


    }

    private static int rabbitInForest(int[] arr) {
        Integer totalRabbits = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer rabbit : arr) {
            map.put(rabbit, map.getOrDefault(rabbit, 0) + 1);
        }
        for (Integer rab : map.keySet()) {
            int minRabbit = map.get(rab) / (rab + 1);
            int extraRabbit = map.get(rab) % (rab + 1);
            totalRabbits += minRabbit * (rab + 1);
            if (extraRabbit != 0) {
                totalRabbits += (rab + 1);
            }
        }
        return totalRabbits;
    }
}
