package com.leetcode.searchandsort;

/**
 * Let's call an array arr a mountain if the following properties hold:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * Given an integer array arr that is guaranteed to be a mountain, return any
 * i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 *
 * Input: arr = [0,1,0]
 * Output: 1
 *
 */
public class _002_PeakIndexInMountainArray {

    public static void main(String[] args) {
        int[] arr={1,3,5,6,8,4,3,2,1};
        System.out.println(peakIndexInMountainArray(arr));
    }

    //the above algorithm helps in getting the maximum element
    public static int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while (start<end){
            int mid=(end-start)/2+start;
            // we know there exist atleast one element which is greater than mid : mid+1
            //so we incremented start+1
            if(arr[mid]<=arr[mid+1]){
                start=mid+1;
            }else {
                // arr[mid+1]<arr[mid]
                //mid is the greatest element so don't subtract 1 from the pivot element
                end=mid;
            }
        }
        return end;
    }
}
