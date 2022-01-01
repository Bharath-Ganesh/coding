package com.practice.algorithm;

import java.util.Arrays;

public class InsertionSortAlgorithm {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 3, 65, 32, 89, 0, 1, 60 };
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int counter = 0;
        for (int i = 1; i < arr.length; i++) {
            counter++;
            int value = arr[i];
            int hole = i;

            while (hole > 0 && arr[hole - 1] > value) {
                arr[hole] = arr[hole - 1];
                hole = hole - 1;
            }
            arr[hole] = value;

        }
        System.out.println("Sorted after " + counter + " iterations : " + Arrays.toString(arr));

    }

}
