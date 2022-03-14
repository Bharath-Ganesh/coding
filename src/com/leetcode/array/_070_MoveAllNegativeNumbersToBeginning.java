package com.leetcode.array;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 * <p>
 * Move all negative numbers to beginning and positive to end with constant extra space
 * <p>
 * An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that all negative numbers appear before all positive numbers
 * <p>
 * Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
 * Output: -12 -13 -5 -7 -3 -6 11 6 5
 */
public class _070_MoveAllNegativeNumbersToBeginning {

    public static void main(String[] args) {
        int[] nums = {-12, 11, 0,-2,-1,-2,-3,2,2,4,2,1,12,4,0,-13, -5, 6, -7, 5, -3, -6};
        moveAllNegativeNumbers(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveAllNegativeNumbers(int[] nums) {
        int pointer = 0;
        int posPointer = nums.length - 1;
        while (pointer <= posPointer) {
            if (nums[pointer] >= 0) {
                swap(nums,pointer,posPointer--);
            }else {
                pointer++;
            }

        }
    }

    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
