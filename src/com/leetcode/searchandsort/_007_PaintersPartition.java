package com.leetcode.searchandsort;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1/
 * Dilpreet wants to paint his dog's home that has n boards with different lengths.
 * The length of ith board is given by arr[i] where arr[] is an array of n integers.
 * He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.
 * <p>
 * The problem is to find the minimum time to get this job done if all painters start together with the
 * constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only board {1} or nothing
 * but not boards {2,4,5}.
 * <p>
 * n = 5
 * k = 3
 * arr[] = {5,10,30,20,15}
 */
public class _007_PaintersPartition {

    public static void main(String[] args) {
        int arr[] = {5, 10, 30, 20, 15};
        int painters = 3;
        System.out.println(minTime(arr, arr.length, painters));
    }

    public static long minTime(int[] arr, int n, int painters) {
        //code here
        long start = arr[0];
        long end = 0l;
        long minTime = 0l;
        for (int element : arr) {
            end += element;
            if (start < element) {
                start = element;
            }
        }

        while (start <= end) {
            long mid = (end - start) / 2 + start;
            if (isPossible(arr, painters, mid)) {
                minTime = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minTime;
    }

    public static boolean isPossible(int[] arr, long painters, long partition) {
        long minPainters = 1l;
        long timeTaken = 0l;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > partition) {
                return false;
            }
            timeTaken += arr[i];
            if (timeTaken > partition) {
                minPainters++;
                timeTaken = arr[i];
                if (minPainters > painters) {
                    return false;
                }
            }

        }
        return true;
    }
}
