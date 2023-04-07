package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find all subarrays having sum zero
 * int[] arr = { 2, 8, -3, -5, 2, -4, 6 , 1 , 2 , 1 , -3 , 4};
 * Count all sub arrays with sum zero
 * O/P : 6
 * [8, -3, -5],[2, 8,  -3, -5, 2, -4], [-5, 2, -4, 6, 1],[2, 1,  -3],[-5, 2, -4, 6, 1, 2, 1,  -3],[-3, -5, 2, -4, 6, 1, 2, 1]
 */

public class CountZeroSumSubArray_06 {

    public static void main(String[] args) {
        //sum     0  2  10  7   2  4   0  6  7  9  10  7  11
        int[] arr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        int count = countZeroSumSubArray(arr);
        System.out.println("Number of sub-arrays with sum zero " + count);

    }

    private static int countZeroSumSubArray(int[] arr) {

        int countOfZeroSubArray = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            countOfZeroSubArray += freqMap.getOrDefault(sum, 0);
            freqMap.put(sum, freqMap.getOrDefault(sum, 0) + 1);
        }
        return countOfZeroSubArray;

    }

}
