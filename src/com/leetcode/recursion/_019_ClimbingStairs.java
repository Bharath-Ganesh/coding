package com.leetcode.recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/climbing-stairs/
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class _019_ClimbingStairs {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {

        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];

    }
}
