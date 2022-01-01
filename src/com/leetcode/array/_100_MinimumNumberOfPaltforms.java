package com.leetcode.array;

import java.util.Arrays;

/**
 * Given arrival and departure times of all trains that reach a railway station.
 * Find the minimum number of platforms required for the railway station so that no train is kept waiting.
 * Consider that all the trains arrive on the same day and leave on the same day.
 * Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other.
 * At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we
 * need different platforms.
 * <p>
 * Input: n = 6
 * arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
 * dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
 * Output: 3
 * Explanation:
 * Minimum 3 platforms are required to
 * safely arrive and depart all trains.
 * <p>
 * arr[] = {0900, 1100, 1235}
 * dep[] = {1000, 1200, 1240}
 */
public class _100_MinimumNumberOfPaltforms {

    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep, arr.length));
    }

    static int findPlatform(int arrival[], int departure[], int n) {
        // add your code here
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int maxPlatform = 1;
        int platformCount = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                i++;
                platformCount++;
            } else {
                j++;
                platformCount--;
            }
            maxPlatform = Math.max(maxPlatform, platformCount);
        }
        return maxPlatform;

    }
}
