package com.leetcode.trees.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 */
public class KSortedArray {

    public static void main(String[] args) {
        KSortedArray obj = new KSortedArray();
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        obj.kSortedArray(arr, k);
        System.out.println(Arrays.toString(arr));
    }



    private void kSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int index;
        for (index = 0; index <= k; index++) {
            pq.add(arr[index]);
        }
        int count=0;
        while (index < arr.length) {
            arr[count++] = pq.remove();
            pq.add(arr[index++]);
        }

        while (!pq.isEmpty()) {
            arr[count++] = pq.remove();
        }
    }
}
