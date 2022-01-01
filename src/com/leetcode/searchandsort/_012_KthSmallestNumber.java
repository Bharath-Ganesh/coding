package com.leetcode.searchandsort;

import java.util.*;


/**
 * Dexter was good in finding the K th smallest number from a set of numbers.
 * He thought he could solve any problem related to K th smallest number. His friend Pipi challenged him with a problem.
 * He gave him various ranges of number, These numbers were arranged in increasing order(only distinct numbers to be taken into account).
 * Now he asked him to find the K th smallest number in the sequence, again and again.
 * <p>
 * int[][] ranges={{1,3}, {5,7}, {6,9} , {2,1} , {12,15}}
 * int queue={1,4,6,19}
 */
public class _012_KthSmallestNumber {

    public static void main(String args[]) {
        int[][] ranges = {{1, 3}, {5, 7}, {6, 9}, {2, 1}, {12, 15}};
        int[] kThSmallest = {1, 4, 6, 19};
        findTheKThElement(ranges, kThSmallest);

    }

    private static void findTheKThElement(int[][] ranges, int[] kThSmallest) {
        int[][] mergeIntervals = mergeIntervals(ranges);
        int[] position = findTheKThSmallestElement(mergeIntervals, kThSmallest);
        System.out.println(Arrays.toString(position));
    }

    //  (1,5) (3,7) (6,9) (10,11)
    private static int[][] mergeIntervals(int[][] range) {
        List<int[]> list = new ArrayList<>();



        Arrays.sort(range, Comparator.comparingInt(value -> value[0]));

        int start = range[0][0];
        int end = range[0][1];
        for (int interval[] : range) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        int[][] res = list.toArray(new int[0][]);
        return res;
    }

    private static int[] findTheKThSmallestElement(int[][] mergeIntervals, int[] kThSmallest) {

        int[] res = new int[kThSmallest.length];

        for (int i = 0; i < kThSmallest.length; i++) {
            int KThSmallestElement = -1;
            int k = kThSmallest[i];
            for (int j = 0; j < mergeIntervals.length; j++) {
                int start = mergeIntervals[j][0];
                int end = mergeIntervals[j][1];
                int range = end - start + 1;
                if (k > range) {
                    k -= range;
                } else {
                    KThSmallestElement = start + k - 1;
                    break;
                }
            }
            res[i] = KThSmallestElement;
        }
        return res;
    }
}
