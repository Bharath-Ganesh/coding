package com.leetcode.greedy;

import java.util.Arrays;

/**
 * Minimum Platforms
 * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
 */
public class MinimumPlatforms {
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, arr.length));
    }

    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platform = 1;
        int maxPlatform = 0;

        int arrival = 1;
        int departure = 0;

        while (arrival < n) {
            if (arr[arrival] <= dep[departure]) {
                platform++;
                arrival++;
            } else {
                platform--;
                departure++;
            }
            maxPlatform = Math.max(maxPlatform, platform);
        }
        return maxPlatform;
    }
}
