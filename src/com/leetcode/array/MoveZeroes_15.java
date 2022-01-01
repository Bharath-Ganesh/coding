package com.leetcode.array;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * <p>
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes_15 {

    public static void main(String[] args) {
        int[] nums = { 0,1,0,3,12};
        moveZeroesLeetcode(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] arr) {

        int i = 0, j = 0;
        while (j < arr.length) {
            if (arr[i] == 0) {
                while (j < arr.length) {
                    if (arr[j] != 0) {
                        break;
                    }
                    j++;
                    if(j== arr.length)
                        return;
                }
                swap(arr, i, j);
                i++;
                j++;
            } else {
                j++;
                i++;
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void moveZeroesLeetcode(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

    }



}
