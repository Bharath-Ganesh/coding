package com.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Chocolate Distribution Problem
 * https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 *
 * Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet.
 * Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
 * 1. Each student gets exactly one packet.
 * 2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
 *
 * N = 8, M = 5
 * A = {3, 4, 1, 9, 56, 7, 9, 12}
 * Output: 6
 * Explanation: The minimum difference between
 * maximum chocolates and minimum chocolates
 * is 9 - 3 = 6 by choosing following M packets :
 * {3, 4, 9, 7, 9}.
 */
public class _083_ChocolateDistributionProblem {
    public static void main(String[] args) {
        List<Long> arr=Arrays.asList(3L, 4L, 1L, 9L, 56L, 7L, 9L, 12L);
        long m=5;
        System.out.println(findMinDiff(arr,arr.size(),m));
    }

    public static long findMinDiff (List<Long> arr, long n, long m)
    {
        // your code here
        long minDiff=Long.MAX_VALUE;
        int window=(int)m;
        Collections.sort(arr);
        for(int i=window-1;i<arr.size();i++){
            minDiff=Math.min(minDiff,arr.get(i) - arr.get(i - window + 1));
        }
        return minDiff;
    }
}
