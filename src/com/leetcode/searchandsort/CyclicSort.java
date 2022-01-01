package com.leetcode.searchandsort;

import java.util.Arrays;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclicSort(int[] arr) {

        int index = 0;
        while (index < arr.length) {
            int correct = arr[index] - 1;
            if (arr[index] !=arr[correct]) {
                swap(correct, index, arr);
            } else {
                index++;
            }
        }
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
