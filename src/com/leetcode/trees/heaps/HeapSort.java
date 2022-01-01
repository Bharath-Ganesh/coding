package com.leetcode.trees.heaps;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        int arr[] = {1, 3, 7, 4, 6, 12, 10, 9, 8, 5, 67};
        obj.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    private void maxHeapify(int[] arr, int index, int n) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(arr, largest, index);
            maxHeapify(arr, largest, n);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}

