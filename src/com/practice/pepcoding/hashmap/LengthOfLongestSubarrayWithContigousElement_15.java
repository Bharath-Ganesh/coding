package com.practice.pepcoding.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the length of the longest subarray with contigous element in an array
 * int arr[] = {9,2,7, 5, 6 ,23, 24, 21, 23 ,19, 17, 16, 18, 39, 0}
 * Output :
 * 4 [19, 17, 16, 18]
 */
public class LengthOfLongestSubarrayWithContigousElement_15 {

    public static void main(String[] args) {
        //           0  1  2  3  4  5   6   7   8   9   10  11  12  13 14
        int arr[] = {9, 2, 7, 5, 6, 23, 24, 21, 23, 19, 17, 16, 18, 39, 0};
        int length = lengthOfLongestSubarrayWithContigousElement(arr);
        System.out.println(length);
    }

    private static int lengthOfLongestSubarrayWithContigousElement(int[] arr) {
        int maxLength = 0;
        int initial_index = 0;
        int final_index = 0;

        //The difference between the index of the sub-array and the diff between the maximum and minimum will be the same.
        for (int i = 0; i < arr.length - 1; i++) {
            int max = arr[i];
            int min = arr[i];
            Set<Integer> set = new HashSet<>();
            set.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                //Check if duplicates
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(arr[j], max);
                min = Math.min(arr[j], min);

                if (max - min == Math.abs(j - i)) {
                    int length = (max - min) + 1;
                    if (maxLength < length) {
                        maxLength = (length);
                        initial_index = i;
                        final_index = j;
                    }
                }
            }
        }
        System.out.println("[" + initial_index + "," + final_index + "]");
        return maxLength;
    }
}
