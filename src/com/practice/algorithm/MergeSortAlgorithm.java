package com.practice.algorithm;

import java.util.Arrays;

public class MergeSortAlgorithm {

    public static void main(String[] args) {
        // 2, 4 , 5 , 8      3 , 6 , 9
        int arr[] = {2, 4, 1, 3, 5};
        // (0,4) -> (0,2), (3,4) -> (0,1),(2,2) -> (0,0) , (1,1)
        int temp[] = new int[arr.length];
        int count = mergeSortAlgorithm(arr, temp, 0, arr.length - 1);
        System.out.println(count);
        System.out.println(Arrays.toString(temp));
    }

    private static int mergeSortAlgorithm(int[] arr, int[] temp, int low, int high) {
        int count = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            count += mergeSortAlgorithm(arr, temp, low, mid);
            count += mergeSortAlgorithm(arr, temp, mid + 1, high);
            count += mergeArray(arr, temp, low, mid + 1, high);
        }
        return count;
    }

    private static int mergeArray(int[] arr, int[] temp, int low, int mid, int high) {
        int firstIndex = low;
        int secondIndex = mid;
        int index = low;
        int countInversion = 0;
        while (firstIndex < mid && secondIndex <= high) {
            if (arr[firstIndex] <=arr[secondIndex]) {
                temp[index++] = arr[firstIndex++];
            } else {
                countInversion += (mid - firstIndex);
                temp[index++] = arr[secondIndex++];
            }
        }
        while (firstIndex < mid) {
            temp[index++] = arr[firstIndex++];
        }
        while (secondIndex <= high) {
            temp[index++] = arr[secondIndex++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
        return countInversion;
    }


}
