package com.leetcode.array;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 *Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeroes_37 {

    public static void main(String[] args) {
        int nums[]=new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {

        char a='a';
        char b='a';
        if(a==b){
            System.out.println("Equal");
        }
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                index++;
            }
        }
    }
}
