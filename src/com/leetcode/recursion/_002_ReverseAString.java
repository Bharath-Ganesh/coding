package com.leetcode.recursion;

import java.util.Arrays;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory
 * <p>
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * <p>
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class _002_ReverseAString {

    public static void main(String[] args) {
        String[] arr = {"h", "e", "l", "l", "o"};
        int start = 0;
        int end = arr.length - 1;
        reverseArrRecursively(arr, start, end);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseArrRecursively(String[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        reverseArrRecursively(arr, start+1, end-1);
        swap(arr, start, end);

    }

    private static void swap(String[] arr, int start, int end) {
        String temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }


}
