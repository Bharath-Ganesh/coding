package com.leetcode.searchandsort;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
 * Given a sorted array arr containing n elements with possibly duplicate elements,
 * the task is to find indexes of first and last occurrences of an element x in the given array.
 * <p>
 * Input:
 * n=9, x=5
 * arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 }
 * Output:  2 5
 * Explanation: First occurrence of 5 is at index 2 and last
 * occurrence of 5 is at index 5.
 * <p>
 * Input:
 * n=9, x=7
 * arr[] = { 1, 3, 5, 5, 5, 5, 7, 123, 125 }
 * Output:  6 6
 */
public class _001_FirstAndLastOccurrence {
    public static void main(String[] args) {
        long arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
        int k = 5;
        System.out.println(find(arr, arr.length, k));
    }

    public static ArrayList<Long> find(long arr[], int n, int k) {
        // code here
        ArrayList<Long> res = new ArrayList();
        long firstIndex = findIndex(arr, k, true);
        long lastIndex = findIndex(arr, k, false);
        res.add(firstIndex);
        res.add(lastIndex);
        return res;

    }


    public static long findIndex(long arr[], int k, boolean firstOccurrence) {
        long start = 0;
        long end = arr.length - 1;
        long ans=-1;
        while (start <=end) {
            int mid = (int) ((int) (end - start) / 2 + start);
            if (arr[mid] == k) {
                //first and last occurrrence
                ans=mid;
                if (firstOccurrence) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
