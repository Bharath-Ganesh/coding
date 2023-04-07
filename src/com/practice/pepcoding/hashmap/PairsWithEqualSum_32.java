package com.practice.pepcoding.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * 1. You are given an array(arr) of distinct integers.
 * 2. You have to find if there are two pairs(A, B) and (C, D) present in the given array which satisfies the condition A+B = C+D.
 */
public class PairsWithEqualSum_32 {

    public static void main(String[] args) {
        Integer arr[] = {2, 9, 3, 5, 8, 6, 4};
        Boolean isPairs = pairsWithEqualSum(arr);
        System.out.println(isPairs);
    }

    private static Boolean pairsWithEqualSum(Integer[] arr) {
        Boolean isPairsExist = true;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (set.contains(sum)) {
                    return isPairsExist;
                }
                set.add(sum);
            }
        }
        return false;
    }
}
