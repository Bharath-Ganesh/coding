package com.leetcode.array;

import java.util.Arrays;

/**
 *
 Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of each tower either
 by increasing or decreasing them by K only once. After modifying, height should be a non-negative integer.
 Find out the minimum possible difference of the height of shortest and longest towers

 Input:
 K = 2, N = 4
 Arr[] = {1, 5, 8, 10}
 Output:
 5
 Explanation:
 The array can be modified as
 {3, 3, 6, 8}. The difference between
 the largest and the smallest is 8-3 = 5.

 K = 3, N = 5
 Arr[] = {3, 9, 12, 16, 20}
 Output:
 11

 int[] nums={5 ,5 ,8, 6, 4, 10 ,3 ,8 ,9 ,10};
 int k=5;

 K = 10, N = 5
 Arr[] = {2 6 3 4 7 2 10 3 2 1}
 Output:
 11
 */
public class _071_MinimizeTheHeights {

    public static void main(String[] args) {
        int[] nums={1,2,5,10};
        int k=4;
        System.out.println(getMinDiff(nums,nums.length,k));
    }

    static int getMinDiff(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int min=0;
        int max=0;
        int answer=arr[n-1]-arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=k){
                max=Math.max(arr[i-1]+k,arr[n-1]-k);
                min=Math.min(arr[i]-k,arr[0]+k);
                answer=Math.min(max-min,answer);
            }
        }
        return answer;
    }
}
