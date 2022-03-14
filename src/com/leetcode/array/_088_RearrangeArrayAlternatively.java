package com.leetcode.array;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 * <p>
 * Given an array of positive and negative numbers, arrange them in an alternate fashion such
 * that every positive number is followed by negative and vice-versa maintaining the order of appearance.
 * Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array.
 * If there are more negative numbers, they too appear in the end of the array.
 * <p>
 * Input:  arr[] = {1, 2, 3, -4, -1, 4}
 * Output: arr[] = {-4, 1, -1, 2, 3, 4}
 * <p>
 * Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
 * output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}
 */
public class _088_RearrangeArrayAlternatively {

    public static void main(String[] args) {
        int[] arr = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrangeKeepingOrderOfAppearance(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * O(n2)
     * Order of appearance is must
     * Space Complexity O(1)
     */
    public static void rearrangeKeepingOrderOfAppearance(int arr[]) {

        for (int i=0;i<arr.length;i++){
            if(ifElementsOutOfPlace(arr[i],i)){
                int index=oppositeIndex(arr[i],i,arr);
                if(index!=-1){
                    rotateSubarray(arr,i,index);
                    rotateSubarray(arr,i+1,index);
                }else{
                    return;
                }
            }
        }

    }

    private static int oppositeIndex(int element,int start,int[] arr){
        if(element==0){
            for(int i=start+1;i<arr.length;i++){
                if(arr[i]<0){
                    return i;
                }
            }
        }else{
            for (int i=start+1;i<arr.length;i++){
                if(arr[i]*element<0){
                    return i;
                }
            }
        }
        return -1;

    }

    public static void rotateSubarray(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    private static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    private static boolean ifElementsOutOfPlace(int element, int index) {
        if (element >= 0) {
            if (index % 2 == 1) {
                return false;
            }
        } else {
            if (index % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
