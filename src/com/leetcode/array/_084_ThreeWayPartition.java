package com.leetcode.array;

import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
 * Three way partitioning
 * Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
 * 1) All elements smaller than a come first.
 * 2) All elements in range a to b come next.
 * 3) All elements greater than b appear in the end.
 * The individual elements of three sets can appear in any order. You are required to return the modified array.
 *
 * n = 5
 * A[] = {1, 2, 3, 3, 4}
 * [a, b] = [1, 2]
 * Output: 1
 * Explanation: One possible arrangement is:
 * {1, 2, 3, 3, 4}. If you return a valid
 * arrangement, output will be 1.
 */
public class _084_ThreeWayPartition {

    public static void main(String[] args) {
        int[] nums={1, 2, 3, 3, 4};
        int a=1;
        int b=2;
        threeWayPartition(nums,a,b);
        System.out.println(Arrays.toString(nums));

    }

    public static void threeWayPartition(int arr[], int a, int b)
    {
        // code here
        int low=0;
        int mid=0;
        int high=arr.length-1;
        while(mid<=high){
            if(arr[mid]<a){
                swap(arr,low++,mid++);
            }else if(arr[mid]>=a && arr[mid]<=b){
                mid++;
            }else {
                swap(arr,mid,high--);
            }
        }
    }


    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
