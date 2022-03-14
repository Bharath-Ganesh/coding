package com.leetcode.array;

import java.util.Arrays;

/**
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
 * <p>
 * For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
 * The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * <p>
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * <p>
 * Input: nums = [1,2,5,4,3]
 * Output: [1,3,2,4,5]
 */
public class _096_NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,2,5,4,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        // 1 2 5 4 3
        int index = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            rotate(nums, 0, nums.length - 1);
            return;
        }

        int swapIndex = 0;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[index] < nums[i]) {
                swapIndex = i;
                break;
            }
        }


        swap(nums, index, swapIndex);
        rotate(nums, index + 1, nums.length - 1);

    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void rotate(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
