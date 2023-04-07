package com.leetcode.dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset obj = new LargestDivisibleSubset();
        int[] nums = {1, 2, 4,5,10,15,45,225, 8};
        System.out.println(obj.largestDivisibleSubset(nums));
    }


    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxLength = 1;
        int lastIndex = 0;
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        //[0,1,0,3,2,3]
        for (int i = 1; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                lastIndex = i;
            }
        }

        int[] print = new int[maxLength];
        int length = maxLength;
        print[--length] = nums[lastIndex];
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            print[--length] = nums[lastIndex];
        }
        List<Integer> result = Arrays.stream(print).boxed().collect(Collectors.toList());
        return result;
    }
}
