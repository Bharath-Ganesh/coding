package com.leetcode.array;

import java.util.Arrays;

/**
 * 1299. Replace Elements with Greatest Element on Right Side
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right,
 * and replace the last element with -1.
 * After doing so, return the array.
 */
public class ReplaceElementWithGreatestElementOnRight_14 {

    public static void main(String[] args) {
       int[] arr = {0,0,1,1,1,2,2,3,3,4};
       // replaceElements(arr);
        System.out.println(removeDuplicates(arr));
    }

    public static int[] replaceElements(int[] arr) {


        int max=-1;
        for(int i=arr.length-1;i>=0;i--){
            int element=arr[i];
            arr[i]=max;
            max = max > element ? max : element;
        }
        return arr;

    }

    public static int removeDuplicates(int[] arr) {

        int i=0;
        int j=i+1;
        while(i<j && j<arr.length){
            if(arr[i]==arr[j]){
                j++;
            }else{
                arr[++i]=arr[j++];
            }
        }
        System.out.println(Arrays.toString(arr));
        return i+1;

    }
}

//    int k=1;
//    int i = 0;
//    int j = i + 1;
//        while (i < j && j<nums.length) {
//        if (nums[i] == nums[j]) {
//        j++;
//        } else {
//        nums[++i] = nums[j];
//        k++;
//        j++;
//        }
//        }
//        return k;
