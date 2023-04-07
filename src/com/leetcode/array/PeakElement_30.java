package com.leetcode.array;

/**
 * 162. Find Peak Element
 * A peak element is an element that is strictly greater than its neighbors.
 *
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * You must write an algorithm that runs in O(log n) time.
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 */
public class PeakElement_30 {

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(findPeakElement(nums));

    }

    public static int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while (start<end){
            int mid=(end-start)/2+start;
            if( (mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                     end=mid;
                     break;
            }else if(mid!=nums.length-1 && (nums[mid] < nums[mid+1])){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return end;
    }


}
