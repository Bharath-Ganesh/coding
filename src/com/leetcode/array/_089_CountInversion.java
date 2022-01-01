package com.leetcode.array;

import java.util.Arrays;

/**
 * Count Inversions
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#
 * <p>
 * Given an array of integers. Find the Inversion Count in the array.
 * <p>
 * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum.
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * <p>
 * Input: N = 5, arr[] = {2, 4, 1, 3, 5}
 * Output: 3
 * Explanation: The sequence 2, 4, 1, 3, 5
 * has three inversions (2, 1), (4, 1), (4, 3).
 */
public class _089_CountInversion {

    public static void main(String[] args) {
        long arr[] = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, arr.length));
    }



    static long inversionCount(long arr[], long n)
    {
        // Your Code Here
        long temp[]=new long[arr.length];
        long count=inversionCount(arr,temp,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        return count;
    }

    static long inversionCount(long[] arr,long[] temp,int low,int high){
        long count=0l;
        if(low<high){
            int mid=(high-low)/2+low;
            count+=inversionCount(arr,temp,low,mid);
            count+=inversionCount(arr,temp,mid+1,high);
            count+=merge(arr,temp,low,mid+1,high);
        }
        return count;
    }

    static long merge(long[] arr,long[] temp,int low,int mid,int high){

        long count=0l;

        int left=low;
        int right=mid;
        int index=low;
        while(left<=mid-1 && right<=high){
            if(arr[left]>arr[right]){
                count+= (mid-left);
                temp[index++]=arr[right++];
            }else{
                temp[index++]=arr[left++];
            }
        }

        while(left<=mid-1){
            temp[index++]=arr[left++];
        }

        while(right<=high){
            temp[index++]=arr[right++];
        }

        for(int i=low;i<=high;i++){
            arr[i]=temp[i];
        }
        return count;

    }


}
