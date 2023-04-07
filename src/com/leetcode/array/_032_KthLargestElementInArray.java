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
        int nums[] = {7, 10, 4 ,3 ,20, 15};
        int k=3;
        System.out.println(kthSmallest(nums,k));

    }


    public static int kthSmallest(int[] arr,int k)
    {
        //Your code here
        k=k-1;
        int low=0;
        int high=arr.length-1;
        while(low<high){
            int pivot=findPivotElementIndex(arr,low,high);
            if(pivot==k){
                low=k;
                break;
            }else if(pivot < k){
                low=pivot+1;
            }else{
                high=pivot-1;
            }
        }
        return arr[low];
    }

    public static int findPivotElementIndex(int[] arr,int low,int high){
        int randomIndex=low+ new Random().nextInt(high-low);
        swap(arr,randomIndex,high);
        int pivotIndex=low;
        for(int i=low;i<high;i++){
            if(arr[i] < arr[high]){
                swap(arr,pivotIndex++,i);
            }
        }
        swap(arr,pivotIndex,high);
        return pivotIndex;
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

//    private static int findKthLargest(int[] nums, int k) {
//        int index= nums.length-k;
//        int low=0;
//        int high=nums.length-1;
//        while(low<high){
//            int pIndex=partition(nums,low,high);
//            if(pIndex==index){
//                break;
//            }else if(pIndex<index){
//                low=pIndex+1;
//            }else {
//                high=pIndex-1;
//            }
//        }
//        return nums[index];
//    }
//
//    private static int partition(int[] nums, int low, int high) {
//      //  int randomIndex=low+new Random().nextInt(high-low);
//      //  swap(nums,randomIndex,high);
//        int pivotElement=nums[high];
//        int j=low;
//        for(int i=low;i<high;i++){
//            if(nums[i]<pivotElement){
//                swap(nums,i,j++);
//            }
//        }
//        swap(nums,j,high);
//        return j;
//
//    }
//
//    private static void swap(int nums[],int i,int j){
//        int temp=nums[i];
//        nums[i]=nums[j];
//        nums[j]=temp;
//    }


}
