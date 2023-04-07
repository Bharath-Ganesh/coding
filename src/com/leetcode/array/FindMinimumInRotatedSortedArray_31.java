package com.leetcode.array;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * <p>
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * <p>
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 * <p>
 * You must write an algorithm that runs in O(log n) time.
 *
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */
public class FindMinimumInRotatedSortedArray_31 {

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(findMinSecond(nums));
    }

    public static  int findMin(int[] nums) {

        int min=nums[0];
        int start=0;
        int end=nums.length-1;
        while (start<=end){
            int mid=(end-start)/2+start;
            if(nums[mid]>=nums[start]){
                min=Math.min(min,nums[start]);
                start=mid+1;
            }else{
                min=Math.min(nums[mid],min);
                end=mid-1;
            }
        }
        return min;
    }


    public static  int findMinSecond(int[] nums) {


        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(right-left)/2+left;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}
