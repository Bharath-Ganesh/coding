package com.leetcode.array;

/**
 * Minimum number of jumps
 * https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 * <p>
 * Given an array of N integers arr[] where each element represents the max number of steps that can be made forward from that element.
 * Find the minimum number of jumps to reach the end of the array (starting from the first element). If an element is 0, then you cannot move through that element.
 * Note: Return -1 if you can't reach the end of the array.
 * <p>
 * Input:
 * N = 11
 * arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3
 * Explanation:
 * First jump from 1st element to 2nd
 * element with value 3. Now, from here
 * we jump to 5th element with value 9,
 * and from here we will jump to last.
 * <p>
 * * arr[] = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}
 * * Output: 4
 */
public class _086_MinimumNumberOfJumps {

    public static void main(String[] args) {
        int arr[] = {0, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        System.out.println(minJumps(arr));
    }

    static int minJumps(int[] arr) {
        // your code here
        Integer[] jumps = new Integer[arr.length];
        jumps[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            int jump = arr[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= jump && i + j < arr.length; j++) {
                if (jumps[i + j] != null && jumps[i + j] < min) {
                    min = jumps[i + j];
                }
            }

            if (min != Integer.MAX_VALUE) {
                jumps[i] = min + 1;
            }
        }
        return jumps[0] == null ? -1 : jumps[0];
    }
}
