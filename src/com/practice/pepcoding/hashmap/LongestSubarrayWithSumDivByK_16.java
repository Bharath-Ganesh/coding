package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. You are given an array of integers(arr) and a number K.
 * 2. You have to find length of the longest subarray whose sum is divisible by K.
 * <p>
 * Integer arr[] = {2,4,8,1,7,3,6,1,9,2,7,3}
 * int k=5;
 * Output
 * 11
 * <p>
 * Integer arr2[] = {2, 7 ,6, 1, 4 ,5};
 * int k=3;
 * Output
 * 4
 * <p>
 * Integer arr3[] = {-3,-9 ,-4, 8, 5 ,4 , 2 ,6};
 * int k=7;
 * Output
 * 6
 */
public class LongestSubarrayWithSumDivByK_16 {
    public static void main(String[] args) {
        Integer arr[] = {2, 4, 8, 1, 7, 3, 6, 1, 9, 2, 7, 3};
        int k = 5;
        int length = longestSubarrayWithSumDivByK(arr, k);
        System.out.println(length);
    }

    private static int longestSubarrayWithSumDivByK(Integer[] arr, int k) {
        int maxLength = 0;
        int initial_index = -1;
        int final_index = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = sum % k;

            //If the reminder is negative number, we need to consider the positive value
            //Third example
            if (rem < 0) {
                rem += k;
            }
            if (map.containsKey(rem)) {
                int length = i - map.get(rem);
                if (length > maxLength) {
                    maxLength = length;
                    initial_index = map.get(rem);
                    final_index = i;
                }
            } else {
                map.put(sum % k, i);
            }
        }
        System.out.println("The elements are found between the index [" + (initial_index + 1) + "," + (final_index + 1) + "]");
        return maxLength;
    }

}
