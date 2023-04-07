package com.leetcode.array;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 */
public class SortColors_48 {

    /**
     * Dutch National Flag Algorithm
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void sortColors(int[] nums) {

        int lowIndex=0;
        int midIndex=0;
        int highIndex=nums.length-1;

        while(midIndex<=highIndex){
            switch(nums[midIndex]){
                case 0:
                    swap(nums,midIndex++,lowIndex++);
                    break;
                case 1:
                    midIndex++;
                    break;
                case 2:
                    swap(nums,midIndex,highIndex--);
                    break;
            }
        }
    }


    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
