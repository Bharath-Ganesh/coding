package com.leetcode.trees.heaps;

import java.util.Arrays;

public class BuildingHeapFromArray {

    public static void main(String[] args) {
        BuildingHeapFromArray obj = new BuildingHeapFromArray();
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        obj.buildHeapFromArray(arr);
        System.out.println(Arrays.toString(arr));
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

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
