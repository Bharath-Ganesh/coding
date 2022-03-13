package com.practice.algorithm;

import java.util.Arrays;

public class MergeSortAlgorithm {

    public static void main(String[] args) {

        int arr[] = {2, 4, 1, 6, 8, 5, 3, 7, 78};
        int temp[] = new int[arr.length];
        mergeSortAlgorithm(arr, temp, 0, arr.length - 1);
        System.out.println(Arrays.toString(temp));
    }

    private static void mergeSortAlgorithm(int[] arr, int[] temp, int left, int right) {

        if (left < right) {
            int mid = (right - left) / 2 + left;
            mergeSortAlgorithm(arr, temp, left, mid);
            mergeSortAlgorithm(arr, temp, mid + 1, right);
            mergeArray(arr, temp, left, mid+1, right);
        }
    }

    private static void mergeArray(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int k = left;
        while (i <= mid-1 && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid-1) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for(i=left;i<=right;i++){
            arr[i]=temp[i];
        }
    }


}
