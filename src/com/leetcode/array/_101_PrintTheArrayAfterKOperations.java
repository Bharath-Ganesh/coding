package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 * Given an array arr[] of size N and a number K. The task is to print the array arr[] after K operations such that at every operation,
 * replace every element arr[i] in the array with max – arr[i] where max is the maximum element in the array.
 * Examples :
 * <p>
 * Input: arr[] = {4, 8, 12, 16}, K = 4
 * Output: 0 4 8 12
 * Explanation:
 * For the given array arr[] = { 4, 8, 12, 16 }. The array is changed as follows for every operation K:
 * { 12, 8, 4, 0 } – K = 1
 * { 0, 4, 8, 12 } – K = 2
 * { 12, 8, 4, 0 } – K = 3
 * { 0, 4, 8, 12 } – K = 4
 * Input: arr[] = {8, 0, 3, 5}, K = 3
 * Output: 0 8 5 3
 * Explanation:
 * For the given array arr[] = { 8, 0, 3, 5 }. The array is changed as follows for every operation K:
 * { 0, 8, 5, 3 } – K = 1
 * { 8, 0, 3, 5 } – K = 2
 * { 0, 8, 5, 3 } – K = 3
 */
public class _101_PrintTheArrayAfterKOperations {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(20, 15, 10, 5);
        int k = 2;
        System.out.println(printArrayAfterKOperations(arr, arr.size(), k));
    }

    public static ArrayList<Integer> printArrayAfterKOperations(List<Integer> arr, int n, int k) {

        // Write your code here.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            max = Math.max(arr.get(i), max);
            min = Math.min(arr.get(i), min);
        }
        if (k % 2 == 0) {
            return printElement(max, arr);
        } else {
            return printElement(min, arr);
        }

    }

    private static ArrayList<Integer> printElement(int max, List<Integer> arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            list.add(Math.abs(max - arr.get(i)));
        }
        return list;
    }
}
