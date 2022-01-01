package com.leetcode.array;

import java.util.Arrays;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 * representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1
 * has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 * <p>
 * int[] nums1 = {1,2,3,0,0,0}, m = 3, nums2[] = {2,5,6}, n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
public class MergeSortedArray_9 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1;
        int bIndex = m - 1;
        int sIndex = n - 1;
        while (bIndex >= 0 && sIndex >= 0) {
            if (nums1[bIndex] > nums2[sIndex]) {
                nums1[index--] = nums1[bIndex--];
            } else {
                nums1[index--] = nums2[sIndex--];
            }
        }

        while (sIndex >= 0) {
            nums1[index--] = nums2[sIndex--];
        }
    }


    
}
