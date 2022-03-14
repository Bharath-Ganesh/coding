package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://practice.geeksforgeeks.org/problems/common-elements1132/1
 * <p>
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * Note: can you take care of the duplicates without using any additional Data Structure?
 * <p>
 * Input:
 * n1 = 6; A = {1, 5, 10, 20, 40, 80}
 * n2 = 5; B = {6, 7, 20, 80, 100}
 * n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
 * Output: 20 80
 * Explanation: 20 and 80 are the only
 * common elements in A, B and C.
 */
public class _075_CommonElements {

    public static void main(String[] args) {
        /////////////////////////////////////8  9  10
        int[] nums1 = {1, 5, 10, 20, 20, 20, 40, 80, 80, 80};
        int[] nums2 = {6, 7, 20, 20, 20, 80, 80, 80};
        int[] nums3 = {3, 4, 15, 20, 20, 20, 30, 70, 80, 80, 120};
        System.out.println(commonElements(nums1, nums2, nums3));
    }

    static ArrayList<Integer> commonElements(int a[], int b[], int c[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length && k < c.length) {
            if (!(result.contains(a[i]))) {
                if (a[i] == b[j] && b[j] == c[k]) {
                    result.add(a[i]);
                    i++;j++;k++;
                }
                else if (a[i] < b[j]) {
                    i++;
                } else if (b[j] < c[k]) {
                    j++;
                } else {
                    k++;
                }
            }else {
                i++;
            }
        }
        return result;
    }


}
