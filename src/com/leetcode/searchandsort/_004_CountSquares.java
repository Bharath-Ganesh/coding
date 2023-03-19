package com.leetcode.searchandsort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/count-squares3649/1
 * Consider a sample space S consisting of all perfect squares starting from 1, 4, 9 and so on.
 * You are given a number N, you have to output the number of integers less than N in the sample space S.
 * <p>
 * Input :
 * N = 9
 * Output:
 * 2
 * Explanation:
 * 1 and 4 are the only Perfect Squares
 * less than 9. So, the Output is 2.
 */
public class _004_CountSquares {

    public static void main(String[] args) {
        int num = 3933355;
        System.out.println(binarySearch(num));


    }

    private static int binarySearch(int n) {
        double low = 1;
        double high = n;
        while (low <= high) {
            double mid = low + (high - low) / 2;
            if ( mid >=  (n / mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) high;
    }

    public static int countSquares(int num) {
        // code here
        int start = 1;
        int end = num;
        int count = 0;
        int target = num;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (mid < (double) target / mid && (mid + 1) >= ((double) target / (mid + 1))) {
                count = mid;
                break;
            } else if ((target / mid) <= mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return count;

    }


}
