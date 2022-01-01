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
        int[] nums = {2,1,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {

        int n=nums.length;
        int index;
        for(index=n-2;index>=0;index--){
            // An increasing sequence will be observed from the end
            // find the position at which first decreasing happens
            // [1,2,6,5,4] => index=1
            if(nums[index]<nums[index+1]){
                break;
            }
        }

        //if the array element are in decreasing order
        // [5,4,3,2,1]
        if(index==-1){
            rotate(nums,0,n-1);
            return;
        }

        int swapPosition=0;
        //Now find a number greater than the nums[index];
        // This will be the starting of the next immediate permutation
        //Start looking from the back to get the minmum
        // [1,3,2]
        for(int i=nums.length-1;i>index;i--){
            if(nums[i]>nums[index]){
                swapPosition=i;
                break;
            }
        }
        swap(nums,index,swapPosition);
        rotate(nums,index+1,n-1);

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
