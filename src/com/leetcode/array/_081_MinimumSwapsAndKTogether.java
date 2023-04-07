package com.leetcode.array;

/**
 * Given an array arr of n positive integers and a number k. One can apply a swap operation on the array any number of times, i.e
 * choose any two index i and j (i < j) and swap arr[i] , arr[j] .
 * Find the minimum number of swaps required to bring all the numbers less than or equal to k together, i.e. make them a contiguous subarray.
 * <p>
 * arr[ ] = {2, 1, 5, 6, 3}
 * K = 3
 * Output :
 * 1
 * Explanation:
 * To bring elements 2, 1, 3 together,
 * swap index 2 with 4 (0-based indexing),
 * i.e. element arr[2] = 5 with arr[4] = 3
 * such that final array will be-
 * arr[] = {2, 1, 3, 6, 5}
 *
 *
 *  arr[ ] = {4, 16, 3, 8, 13,2,19,4,12,2,7,17,4,19,1}
 *  K = 9
 *  Output : 3
 *
 *  arr[ ] = {20, 12, 17}
 *  K = 6
 */
public class _081_MinimumSwapsAndKTogether {

    public static void main(String[] args) {
        int[] arr={20,5,17};
        int k=6;
        System.out.println(minSwap(arr,arr.length,k));
    }

    public static int minSwap(int arr[], int n, int k) {
        //Complete the function
        int pos = 0;
        for (int number : arr) {
            if (number <= k) {
                pos++;
            }
        }
        if(pos<=1){
            return 0;
        }
        int minSwap = arr.length+1;
        int window = pos ;
        int swap = 0;
        int i = 0;
        for (i = 0; i < window - 1; i++) {
            if (arr[i] > k) {
                swap++;
            }
        }

        for (i = window - 1; i < arr.length; i++) {
            if (arr[i] > k) {
                swap++;
            }
            minSwap = Math.min(swap, minSwap);
            if (arr[(i - window) + 1] > k) {
                swap--;
            }
        }
        return minSwap;
    }
}
