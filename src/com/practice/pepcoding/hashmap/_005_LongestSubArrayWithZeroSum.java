package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;


/**
 * Find the longest subarray with sum zero
 * Given an array , int[] arr = { 2, 8, -3, -5, 2, -4, 6, 1, 2,  1, -3, 4 };
 * Output
 * [3,10] : [-5, 2, -4, 6, 1, 2,  1, -3]
 * <p>
 * Find the longest subarray with sum k, where k = 7
 * Output
 * [5,11] : [-4, 6, 1, 2,  1, -3, 4]
 */
public class _005_LongestSubArrayWithZeroSum {

    public static void main(String[] args) {
        //            -------4-------|##sum-k; 11-7=4#########
        //index       0  1   2   3  4   5  6  7  8   9  10  11
        //sum-k      -5  3   0  -5 -3  -7 -1  0  2   3   0  4
        // sum        2  10  7   2  4   0  6  7  9   10  7  11
        int[] arr =  {2, 8, -3, -5, 2, -4, 6, 1, 2,  1, -3, 4};
        largestSubArrayWithSumZero(arr);
        int k = 7;
        largestSubArrayWithSumK(arr, k);

    }

    private static void largestSubArrayWithSumK(int[] arr, int k) {
        int sum = 0;
        int length = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int end_index = -1;
        int initial_index = -1;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - k) && length < (i - map.getOrDefault(sum - k, arr.length))) {
                end_index = i;
                initial_index = map.get(sum - k);
                length = i - map.getOrDefault(sum - k, 0);
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("[" + (initial_index + 1) + "," + end_index + "]");

    }

    private static void largestSubArrayWithSumZero(int[] arr) {

        int sum = 0;
        int length = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int end_index = -1;
        int initial_index = -1;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum) && length < (i - map.get(sum))) {
                end_index = i;
                initial_index = map.get(sum);
                length = i - i - map.get(sum);
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("[" + (initial_index + 1) + "," + end_index + "]");
    }

}
