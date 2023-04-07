package com.leetcode.searchandsort;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 */
public class _018_KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr,k));
    }

    public static int findKthPositive(int[] arr, int k) {

        // 11 - 5 =6
        int n=arr.length-1;
        int missingElements=arr[n]-arr.length;
        //if we are looking for k=10;when me=6
        if(k > missingElements || missingElements==0){
            return arr[n]+ (k-missingElements);
        }

        int low=0;
        int high=n;
        while(low<=high){
            int mid=(high-low)/2+low;
            if(compute(arr[mid],mid+1)<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        //no elements to the left ; all the elements are missing
        if(high==-1){
            return k;
        }
        int elementsToRight=compute(arr[high],high+1);
        return arr[high]+ (k-elementsToRight);
    }

    public static int compute(int num1,int num2){
        return num1-num2;
    }
}
