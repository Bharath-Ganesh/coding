package com.leetcode.array;

/**
 * 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class _073_MajorityElement {

    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] arr) {

        int count = 1;
        int majorityIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[majorityIndex]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        return arr[majorityIndex];
    }
}
