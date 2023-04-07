package com.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Array Subset of another array
 * https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1#
 * Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not.
 * Both the arrays can be sorted or unsorted. It may be assumed that elements in both array are distinct.
 * <p>
 * a1[] = {11, 1, 13, 21, 3, 7}
 * a2[] = {11, 3, 7, 1}
 * Output:
 * Yes
 * Explanation:
 * a2[] is a subset of a1[]
 */
public class _091_ArraySubsetOfAnotherArray {

    public static void main(String[] args) {
        long a1[] = {11, 1, 13, 21, 3, 7};
        long a2[] = {11, 3, 7, 1};
        System.out.println(isSubset(a1,a2,a1.length,a2.length));

    }

    public static String isSubset(long a1[], long a2[], long n, long m) {

        if (n > m) {
            return isSubset(a2, a1, m, n);
        }

        Set<Long> set = new HashSet<>();
        for (long num : a2) {
            set.add(num);
        }

        for (long num : a1) {
            if (!set.contains(num)) {
                return "No";
            }
        }
        return "Yes";
    }
}
