package com.leetcode.array;

import java.util.Random;

/**
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the  Kth smallest element in the given array. It is given that all array elements are distinct.
 * <p>
 * N = 6
 * arr[] = 7 10 4 3 20 15
 * K = 3
 * Output : 7
 * Explanation :
 * 3rd smallest element in the given
 * array is 7.
 * <p>
 * N = 5
 * arr[] = 7 10 4 20 15
 * K = 4
 * Output : 15
 * Explanation :
 * 4th smallest element in the given
 * array is 15.
 */
public class _099_KthSmallestElementInAnArray {

    public static void main(String[] args) {
        int[] arr = {7 ,10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, k));
    }

    public static int kthSmallest(int[] arr, int k) {
        //Your code here
        int low = 0;
        int high = arr.length - 1;
        int index = k - 1;
        while (low < high) {
            int pIndex = partition(arr, low, high);
            if (pIndex == index) {
                break;
            } else if (pIndex > index) {
                high = pIndex - 1;
            } else {
                low = pIndex + 1;
            }
        }
        return arr[index];
    }

    private static int partition(int[] arr, int low, int high) {
        int rIndex = low + new Random().nextInt(high - low);
        swap(arr, high, rIndex);
        int pivotElement = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (pivotElement > arr[j]) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, high);
        return i;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
