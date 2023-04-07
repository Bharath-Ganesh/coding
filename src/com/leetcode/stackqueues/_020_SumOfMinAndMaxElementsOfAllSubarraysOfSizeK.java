package com.leetcode.stackqueues;

import java.util.*;

/**
 * Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.
 * Examples:
 * <p>
 * Input : arr[] = {2, 5, -1, 7, -3, -1, -2}
 * K = 4
 * Output : 18
 * Explanation : Subarrays of size 4 are :
 * {2, 5, -1, 7},   min + max = -1 + 7 = 6
 * {5, -1, 7, -3},  min + max = -3 + 7 = 4
 * {-1, 7, -3, -1}, min + max = -3 + 7 = 4
 * {7, -3, -1, -2}, min + max = -3 + 7 = 4
 * Sum of all min & max = 6 + 4 + 4 + 4
 * = 18
 */
public class _020_SumOfMinAndMaxElementsOfAllSubarraysOfSizeK {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(20 ,3 ,1,3 ,5 ,11 ,13 ,2 ,8 ,19 );
        int k = 6;
        long sum = sumOfMaxAndMin(arr, arr.size(),k);
        System.out.println(sum);
    }

    public static long sumOfMaxAndMin(List<Integer> nums, int n, int k) {
        // Write your code here.
        long sum = 0;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        for (int i = 0; i < k-1 ; i++) {
            while (!max.isEmpty() && nums.get(i) >= nums.get(max.peekLast())) {
                max.removeLast();
            }
            while (!min.isEmpty() && nums.get(i) <= nums.get(min.peekLast())) {
                min.removeLast();
            }
            min.add(i);
            max.add(i);
        }

        for (int i = k - 1; i < n; i++) {

            while (!max.isEmpty() && nums.get(i) >= nums.get(max.peekLast())) {
                max.removeLast();
            }
            while (!min.isEmpty() && nums.get(i) <= nums.get(min.peekLast())) {
                min.removeLast();
            }
            min.add(i);
            max.add(i);

            long currMax=nums.get(max.peekFirst());
            long currMin=nums.get(min.peekFirst());
            sum+= currMax+currMin;

            //deletion logic
            if (!max.isEmpty() && i - max.peekFirst() == k - 1) {
                max.removeFirst();
            }

            if (!min.isEmpty() && i - min.peekFirst() == k - 1) {
                min.removeFirst();
            }
        }
        return sum;
    }

}
