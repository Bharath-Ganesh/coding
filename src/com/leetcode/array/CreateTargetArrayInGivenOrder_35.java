package com.leetcode.array;

import java.util.Arrays;

/**
 *1389. Create Target Array in the Given Order
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 *
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 */
public class CreateTargetArrayInGivenOrder_35 {

    public static void main(String[] args) {
        int[] nums={0,1,2,3,4},index={0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums,index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] res=new int[nums.length];
        return res;
    }


}
