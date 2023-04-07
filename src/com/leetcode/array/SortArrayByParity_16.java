package com.leetcode.array;


import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 *
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 *
 * Return any array that satisfies this condition.
 *
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity_16 {

    public static void main(String[] args) {
        int[] nums = {3,1,5,7,7,9,1,2,4};
        sortArrayByParityLeetcode(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static int[] sortArrayByParity(int[] arr) {

        int i=0;
        int j=arr.length-1;

        while(i<j){
            if(arr[i]%2==0){
                i++;
            }else{
                while(arr[j]%2!=0 && i<j){
                    j--;
                }
                swap(arr,i++,j--);
            }
        }
        return arr;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int[] sortArrayByParityLeetcode(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }
}
