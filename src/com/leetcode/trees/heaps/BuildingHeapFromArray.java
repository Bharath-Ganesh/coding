package com.leetcode.trees.heaps;

import java.util.Arrays;

public class BuildingHeapFromArray {

    public static void main(String[] args) {
        BuildingHeapFromArray obj = new BuildingHeapFromArray();
        int arr1[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        int arr2[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
        obj.buildHeapFromArray(arr1);
        obj.buildHeapFromArray1(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    private void buildHeapFromArray1(int[] arr) {

        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify1(arr, i, n);
        }
        for(int i=0;i<n-1;i++){
            swap(arr,0,n-1-i);
            heapify1(arr,0,n-1-i);
        }

        System.out.println(Arrays.toString(arr));

    }

    private void heapify1(int[] arr, int index, int size) {

        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < size && arr[largest] < arr[leftChild]) {
            largest = leftChild;
        }
        if (rightChild < size && arr[largest] < arr[rightChild]) {
            largest = rightChild;
        }
        if (largest != index) {
            swap(arr, largest, index);
            heapify1(arr, largest, size);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

        private void buildHeapFromArray(int[] arr) {
            //internal nodes
            //0 -> n/2-1
            int n = arr.length;
            for (int i = (n / 2) - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

    //        for(int i=n-1;i>=0;i--){
    //            swap(arr,0,i);
    //            heapify(arr,i,0);
    //        }


            for(int i=0;i<n;i++){
                swap(arr,0,n-1-i);
                heapify(arr,n-1-i,0);
            }
        }

        private void heapify(int[] arr, int n, int i) {
            int largest = i;
            int leftChild = 2 * largest + 1;
            int rightChild = 2 * largest + 2;

            if (leftChild < n && arr[leftChild] > arr[largest]) {
                largest = leftChild;
            }

            if (rightChild < n && arr[rightChild] > arr[largest]) {
                largest = rightChild;
            }

            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify(arr, n, largest);
            }
        }

}
