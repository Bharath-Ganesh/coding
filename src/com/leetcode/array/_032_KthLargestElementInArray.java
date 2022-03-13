package com.leetcode.array;

import java.util.Arrays;
import java.util.Random;



/**
 * 215. Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6,7], k = 2
 * Output: 6
 */
public class _032_KthLargestElementInArray {

    public static void main(String[] args) {
        int nums[] = {3,4,1,2,5,8,4};
        int k=1;
        System.out.println(findKthLargest(nums,k));

    }

    private static int findKthLargest(int[] nums, int k) {
        int index= nums.length-k;
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int pIndex=partition(nums,low,high);
            if(pIndex==index){
                break;
            }else if(pIndex<index){
                low=pIndex+1;
            }else {
                high=pIndex-1;
            }
        }
        return nums[index];
    }

    private static int partition(int[] nums, int low, int high) {
      //  int randomIndex=low+new Random().nextInt(high-low);
      //  swap(nums,randomIndex,high);
        int pivotElement=nums[high];
        int j=low;
        for(int i=low;i<high;i++){
            if(nums[i]<pivotElement){
                swap(nums,i,j++);
            }
        }
        swap(nums,j,high);
        return j;

    }

    private static void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


}
