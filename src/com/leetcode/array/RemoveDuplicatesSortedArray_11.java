package com.leetcode.array;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Since it is impossible to change the length of the array in some languages, you must instead have the
 * result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * Return k after placing the final result in the first k slots of nums.
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesSortedArray_11 {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,1};
        System.out.println(removeDuplicatesLeetcode(nums));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {

        int k=1;
        int i = 0;
        int j = i + 1;
        while (i < j && j<nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j];
                k++;
                j++;
            }
        }
        return k;
    }


    public static int removeDuplicatesLeetcode(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i-1])
                nums[i++] = n;
        return i;
    }

}
