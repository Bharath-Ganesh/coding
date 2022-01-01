package com.leetcode.searchandsort;

import java.util.*;


/**
 * https://practice.geeksforgeeks.org/problems/minimum-swaps/1#
 * Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.
 * <p>
 * Input:
 * nums = {2, 8, 5, 4}
 * Output:
 * 1
 * Explaination:
 * swap 8 with 4.
 * <p>
 * Input:
 * nums = {10, 19, 6, 3, 5}
 * Output:
 * 2
 * Explaination:
 * swap 10 with 3 and swap 19 with 5.
 */


class Pair {
    Integer val;
    Integer index;

    Pair(Integer val, Integer index) {
        this.val = val;
        this.index = index;
    }
}

public class _011_MinSwapsToSort {

    public static void main(String[] args) {
        int nums[] = {2, 8, 5, 4};
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int nums[]) {
        // Code here
        Pair[] pair = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Pair p = new Pair(nums[i], i);
            pair[i] = p;
        }

        Arrays.sort(pair, Comparator.comparingInt(p -> p.val));
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        int swapCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i == pair[i].index) {
                continue;
            }

            int cycleLength = 0;
            int j = i;
            while (visited[j] == false) {
                visited[j] = true;
                cycleLength++;
                j = pair[j].index;
            }
            swapCount += cycleLength - 1;
        }
        return swapCount;
    }
}
