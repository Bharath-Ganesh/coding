package com.leetcode.trees.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 215. Kth Largest Element in an Array
 */
public class FindKLargestElement {

    public static void main(String[] args) {

        FindKLargestElement obj = new FindKLargestElement();
//        int arr[] = {602, 324, 133, 473, 153, 88, 571, 764, 902, 104, 424, 528, 601, 970, 16, 566, 29, 544, 348};
//        int k = 17;
//        int[] res = obj.kLargest(arr, arr.length, k);
//        System.out.println(Arrays.toString(res));
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k1 = 1;
        System.out.println(obj.findKthLargest(nums, k1));

    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i;
        int n = nums.length;
        for (i = 0; i < k; i++) {
            pq.add(nums[i]);
        }


        for (; i < n; i++) {
            int element = nums[i];
            if (pq.peek() < element) {
                pq.remove();
                pq.add(element);
            }
        }

        return pq.remove();
    }

    private int[] kLargest(int[] arr, int n, int k) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        int index = n - 1;
        int[] res = new int[k];
        int count = 0;
        while (count < k) {
            swap(0, index, arr);
            res[count++] = arr[index--];
            heapify(arr, index, 0);
        }
        return res;
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
            swap(i, largest, arr);
            heapify(arr, n, largest);
        }
    }

    private void swap(int i, int largest, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
