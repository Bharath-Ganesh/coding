package com.leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/
 */
public class SubsequenceThatSatisfyGivenSum {

    public static void main(String[] args) {
        SubsequenceThatSatisfyGivenSum obj = new SubsequenceThatSatisfyGivenSum();
        int[] num = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        int target = 22;
        int i = obj.numSubseq(num, target);
        System.out.println(i);
    }

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0, n = nums.length;
        int l = 0, r = n - 1;
        int mod = (int) 1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1; i < n; ++i)
            pows[i] = pows[i - 1] * 2 % mod;

        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pows[r - l]) % mod;
                l++;
            }
        }
        return res;
    }
}
