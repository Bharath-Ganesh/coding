package com.leetcode.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 977. Squares of a Sorted Array
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 */
public class SquaresOfSortedArray_29 {

    public static void main(String[] args) {
        int nums[] = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {

        int left=0;
        int right=nums.length-1;
        int index=nums.length-1;
        int output[]= new int[nums.length];
        while(index>=0){
            int rs=nums[right]*nums[right];
            int ls=nums[left]*nums[left];
            if(rs>ls){
                output[index--]=rs;
                right--;
            }else{
                output[index--]=ls;
                left++;
            }
        }
        return output;

    }
}
