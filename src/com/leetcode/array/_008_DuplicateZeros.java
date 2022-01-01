package com.leetcode.array;

import java.util.Arrays;

/**
 * 1089. Duplicate Zeros
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 * <p>
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 *
 *  Input: arr = [8,4,5,0,0,0,0,7]
 *  Output:      [8,4,5,0,0,0,0,0]
 *
 */
public class _008_DuplicateZeros {

    public static void main(String[] args) {
        int arr[] = {8,4,5,0,0,0,0,7};
        duplicateZeroLeetcode(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shift(arr, i);
                i++;
            }
        }
    }


    public static void shift(int[] arr, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
    }


    public static void duplicateZeroLeetcode(int[] arr) {
        int zero=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
               zero++;
            }
        }

        int originalArrayLength=arr.length-1;
        int increasedArrayLength=arr.length+zero-1;
        while (originalArrayLength!=increasedArrayLength){
            insert(arr,originalArrayLength,increasedArrayLength--);
            if(arr[originalArrayLength]==0){
                insert(arr,originalArrayLength,increasedArrayLength--);
            }
            originalArrayLength--;
        }

    }

    private static void insert(int[] arr, int originalArrayLength, int increasedArrayLength) {
        if(increasedArrayLength < arr.length){
            arr[increasedArrayLength]=arr[originalArrayLength];
        }
    }




}
