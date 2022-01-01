/**
 *
 */
package com.practice.algorithm;

import java.util.List;

/**
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 *
 * Input : { -2, -3, -4, -5, 112, -100, -8 }; Output : {112}; You have to find
 * the max sum
 */

public class KadaneAlgorithum {

    public static void main(String[] args) {
        int[] arr = {-2, -1, -8, -5, -112, -100, -8};
        KadaneAlgorithum kadaneAlgorithum = new KadaneAlgorithum();
        Integer max_sum = kadaneAlgorithum.findMaxContigousSum(arr);
        System.out.println(max_sum);
    }

    // Kadane's algorithm is used to find the max contiguous sum in an array in O(n)
    private Integer findMaxContigousSum(int[] arr) {

        int maxSoFar = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(maxSum + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar, maxSum);
        }
        return maxSoFar;
    }

}
