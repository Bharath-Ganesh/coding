package com.practice.geeks.array;

import java.util.Arrays;

public class TestUIUC {

    public static void main(String[] args) {

        int[] nums = {3,4,5,1};
        int target = 8;

        int low = 0;
        int high = 1;
        int pos = peakIndexInMountainArray(nums);
        System.out.println(pos);

    }


    public static int peakIndexInMountainArray(int[] nums) {

        int low = 0;
        int n = nums.length;
        int high = n-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if((mid-1>=0 && mid+1<n) && (nums[mid-1]<nums[mid]) && (nums[mid]>nums[mid+1]) ){
                return mid;
            }
            else if( (mid+1<n) && (nums[mid]<nums[mid+1]) ){
                low=mid+1;
            }else if(mid-1>=0 && (nums[mid-1]>nums[mid])){
                high = mid -1;
            }
        }

        return -1;
    }




}
