package com.leetcode.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of length ‘N’, where each element denotes the position of a stall. Now you have ‘N’
 * stalls and an integer ‘K’ which denotes the number of cows that are aggressive. To prevent the cows from hurting each other,
 * you need to assign the cows to the stalls,
 * such that the minimum distance between any two of them is as large as possible. Return the largest minimum distance.
 * <p>
 * <p>
 * 3 2
 * int stalls[]= {1 2 3}, int cows=2;
 * output : 2
 * <p>
 * int stalls[]= {4 ,2 ,1 ,3 ,6};
 * int cows=2;
 * output : 5
 */
public class _006_AggressiveCows {
    public static void main(String[] args) {
        List<Integer> stalls = Arrays.asList(4, 2, 1, 3, 6);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(stalls);
        int cows = 2;
        System.out.println(aggressiveCows(arr, cows));
    }



    public static int aggressiveCows(ArrayList<Integer> stalls, int cows) {
        //    Write your code here.
        Collections.sort(stalls);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < stalls.size(); i++) {
            min = Math.min(stalls.get(i), min);
            max = Math.max(stalls.get(i), max);
        }
        int low = 0;
        int high = max - min;
        int maxPossibleDist = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (isPossibleCows(mid, stalls, cows)) {
                maxPossibleDist = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxPossibleDist;
    }

    public static boolean isPossibleCows(int minDistance, ArrayList<Integer> stalls, int cows) {
        int distance = 0;
        int cowsCount = 1;
        for (int i = 1; i < stalls.size(); i++) {
            distance += stalls.get(i) - stalls.get(i - 1);
            if (distance >= minDistance) {
                distance = 0;
                cowsCount += 1;
            }
            if (cowsCount == cows) {
                return true;
            }
        }
        return cowsCount >= cows;
    }


}
