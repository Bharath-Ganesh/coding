package com.leetcode.bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 */
public class FindMissingAndRepeatingNumbers {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 5, 2, 9, 8, 1, 1, 7, 10, 3);
        System.out.println(Arrays.toString(missingAndRepeating(arr, arr.size())));
    }

    public static int[] missingAndRepeating(List<Integer> arr, int n) {
        // Write your code here

        int num1 = 0;
        int num2 = 0;
        int res = 0;

        for (int i = 1; i <= arr.size(); i++) {
            res = res ^ i ^  arr.get(i-1);
        }

        int rmsb = (res & (-res));

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            if ((rmsb & num) == 0) {
                num1 = num1 ^ num;
            } else {
                num2 = num2 ^ num;
            }
        }

        for (int i = 1; i <= arr.size(); i++) {
            int num = i;
            if ((rmsb & num) == 0) {
                num1 = num1 ^ num;
            } else {
                num2 = num2 ^ num;
            }
        }
        return new int[]{num1, num2};
    }
}
