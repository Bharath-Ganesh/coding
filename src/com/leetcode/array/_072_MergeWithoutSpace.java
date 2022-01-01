package com.leetcode.array;

import java.util.Arrays;

/**
 * Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is sorted in non-decreasing order.
 * Merge the two arrays into one sorted array in non-decreasing order without using any extra space.
 * <p>
 * N = 4, M = 5
 * arr1[] = {1, 3, 5, 7}
 * arr2[] = {0, 2, 6, 8, 9}
 * Output: 0 1 2 3 5 6 7 8 9
 * Explanation: Since you can't use any
 * extra space, modify the given arrays
 * to form
 * arr1[] = {0, 1, 2, 3}
 * arr2[] = {5, 6, 7, 8, 9}
 */
public class _072_MergeWithoutSpace {

    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};
        mergeGapMethod(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }


    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (gap / 2) + (gap % 2);
    }

    public static void mergeGapMethod(int arr1[], int arr2[], int n, int m) {
        // code here
        int i, j;
        //Gap method can be used to merge using an extra space
        // Time complexity :  log(n)*n;
        // gap= Ciel (n1+n2)/2;
        int gap = n + m;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            //When both the pointer are on the first array
            for (i = 0; i + gap < n; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    swap(arr1, arr1, i, i + gap);
                }
            }

            //When  the 1st pointer is on the first array and second on the 2nd array
            for (j = gap > n ? gap - n : 0; j < m && i < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    swap(arr1, arr2, i, j);
                }
            }
            if (j < m) {
                //when both pointers are on the second array
                for (j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        swap(arr2, arr2, j, j + gap);
                    }
                }
            }
        }
    }

    private static void swap(int[] arr1, int[] arr2, int pos1, int pos2) {
        int temp = arr1[pos1];
        arr1[pos1] = arr2[pos2];
        arr2[pos2] = temp;
    }


    public static void merge(int arr1[], int arr2[], int m, int n) {
        // code here

        // arr2 iterator
        for (int i = n - 1; i >= 0; i--) {
            int j;
            int last = arr1[m - 1];
            // arr 1 iterator
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }

            if (j != m - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }


}
