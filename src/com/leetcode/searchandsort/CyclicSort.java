package com.leetcode.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        firstMissingPositive(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for(int i=0;i<n;){
            int pos = nums[i]-1; // 1
            int val = nums[i];  // 4
            if(val>0 && val<=n && val!=nums[pos]){
                swap(i, pos, nums);
            }else{
                i++;
            }
        }

        for(int i=0;i<n;i++){
            if(i+1!=nums[i]){
                return i+1;
            }
        }
        return n+1;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }






}
