package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 */
public class _016_PermutationInSequence {

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(getPermutation(n, k));
    }

    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList();
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            numbers.add(i);
            factorial *= i;
        }
        numbers.add(n);
        k = k - 1;

        StringBuilder ans = new StringBuilder();
        while (true) {
            if (numbers.size() == 1) {
                ans.append(numbers.get(0));
                break;
            }
            ans.append(numbers.get(k / factorial));
            numbers.remove(k / factorial);
            k = k % factorial;
            n = n - 1;
            factorial = factorial / n;
        }
        return ans.toString();
    }
}
