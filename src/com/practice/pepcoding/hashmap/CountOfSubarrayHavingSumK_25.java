package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. You are given an array of integers(arr) and a number K.
 * 2. You have to find the count of subarrays whose sum equals k.
 * <p>
 * Integer arr[] = {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1}
 * int k=5;
 * <p>
 * Output
 */
public class CountOfSubarrayHavingSumK_25 {

    public static void main(String[] args) {
        Integer arr[] = {3, 9, -2, 4, 1, -7, 2, 6, -5, 8, -3, -7, 6, 2, 1};
        int k = 5;
        int count = countOfSubarrayHavingSumK(arr, k);
        System.out.println(count);
    }

    private static int countOfSubarrayHavingSumK(Integer[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;
    }
}
