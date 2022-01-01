package com.leetcode.array;

/**
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 */
public class BinarySearch_23 {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int index=search(nums,target);
        System.out.println(index);
    }

    public static int search(int[] nums, int target) {

        int start=0;
        int last=nums.length-1;
        while(start<=last){
            int mid=(last-start)/2+start;
            int num=nums[mid];
            if(target>num){
                start=mid+1;
            }else if(target<num){
                last=mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
