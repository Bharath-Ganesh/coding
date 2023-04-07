package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 1346. Check If N and Its Double Exist
 * <p>
 * Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
 * <p>
 * Input: arr = [10,2,5,3]
 * Output: true
 * Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
 */
public class CheckIfNAndDoubleExist_12 {

    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 3};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : arr) {
            if (hashSet.contains(num * 2) || (num % 2 == 0 && hashSet.contains(num / 2))) return true;
            hashSet.add(num);
        }
        return false;
    }

}
