package com.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static void main(String[] args) {
        LongestStringChain obj = new LongestStringChain();
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        System.out.println(obj.longestStrChain(words));
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int[] dp = new int[n];
        int maxLength = 1;
        Arrays.fill(dp, 1);

        Arrays.sort(words, Comparator.comparingInt(String::length));
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (int i = 1; i < n; i++) {
            String first = words[i];
            for (int j = 0; j < i; j++) {
                String second = words[j];
                if (compare(first, second) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (maxLength < dp[i]) maxLength = dp[i];
        }
        return maxLength;
    }



    private boolean compare(String first, String second) {

        int n = first.length();
        int m = second.length();
        if (n != m + 1) return false;
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            Character ch1 = first.charAt(i);
            Character ch2 = second.charAt(j);
            if (ch1 == ch2) {
                j++;
            }
            i++;
        }
        return j == m;
    }
}
