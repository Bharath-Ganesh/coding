package com.leetcode.trees.heaps;

import java.util.Arrays;

public class IncreasedKeyAlgo {


    public static void main(String[] args) {
        IncreasedKeyAlgo obj = new IncreasedKeyAlgo();
        int[] arr = {9, 8, 7, 6, 5, 4, 3};
        int index = 5, key = 50;
        obj.increaseKeyAlgo(arr, index, key);
        System.out.println(Arrays.toString(arr));
    }

    private void increaseKeyAlgo(int[] arr, int index, int key) {
        int n = arr.length;
        if (index >= n) {
            return;
        }
        arr[index] = key;
        // Now we have to ensure heap property
        while (index > 0 && arr[findParent(index)] < arr[index]) {
            swap(index, findParent(index), arr);
            index = findParent(index);
        }
    }

    private int findParent(int index) {
        return (index + 1) / 2 - 1;
    }

    private void swap(int i, int largest, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }

}
