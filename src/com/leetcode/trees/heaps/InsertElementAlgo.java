package com.leetcode.trees.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class InsertElementAlgo {

    public static void main(String[] args) {

        InsertElementAlgo obj = new InsertElementAlgo();
        int[] arr = {9, 8, 7, 6, 5, 4, 3};
        int key = 50;
        int[] res = obj.insertElementAlgo(arr, key);
        System.out.println(Arrays.toString(res));
    }

    private int[] insertElementAlgo(int[] arr, int key) {
        int n = arr.length;
        int[] res = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        res[arr.length] = key;
        int index = n;
        while (index > 0 && res[findParent(index)] < res[index]) {
            swap(index, findParent(index), res);
            index = findParent(index);
        }
        return res;
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
