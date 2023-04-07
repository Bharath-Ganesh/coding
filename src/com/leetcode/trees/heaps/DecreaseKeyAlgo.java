package com.leetcode.trees.heaps;

import java.util.Arrays;

public class DecreaseKeyAlgo {

    public static void main(String[] args) {
        DecreaseKeyAlgo obj = new DecreaseKeyAlgo();
        int[] arr = {9, 8, 7, 6, 5, 4, 3,1,2};
        int index = 1, key = 0;
        obj.decreaseAlgo(arr, index, key);
        System.out.println(Arrays.toString(arr));
    }

    private void decreaseAlgo(int[] arr, int index, int key) {
        int n = arr.length;
        if (index >= n && arr[index] < key) {
            return;
        }
        arr[index] = key;
        buildHeap(arr, index, n);

    }

    private void buildHeap(int[] arr, int index, int n) {
        int largest = index;
        int left = 2 * largest + 1;
        int right = 2 * largest + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(largest, index, arr);
            buildHeap(arr, largest, n);
        }
    }


    private void swap(int i, int largest, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
