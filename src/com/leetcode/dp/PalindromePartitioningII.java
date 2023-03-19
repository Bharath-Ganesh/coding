package com.leetcode.dp;

import java.util.Arrays;

public class PalindromePartitioningII {

    public static void main(String[] args) {
        PalindromePartitioningII obj = new PalindromePartitioningII();
        String word = "bababcbacd";
        System.out.println(obj.minCutTabulation(word));
    }

    public int minCutTabulation(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            int min = s.length();
            String word = "";
            for (int j = i; j < s.length(); j++) {
                word += s.charAt(j);
                if (isPalindrome(word)) {
                    int cut = 1 + dp[j + 1];
                    min = Math.min(cut, min);
                }
            }
            dp[i] = min;
        }
        return dp[0]-1;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return minCut(s, dp, 0) - 1;
    }

    public int minCut(String s, int[] dp, int i) {
        if (i == s.length()) return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int min = s.length();
        for (int index = i; index < s.length(); index++) {
            if (isPalindrome(i, index, s)) {
                int cut = 1 + minCut(s, dp, index + 1);
                min = Math.min(cut, min);
            }
        }
        return dp[i] = min;
    }


    private boolean isPalindrome(int start, int end, String word) {
        int n = word.length();
        if (n == 1) return true;

        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String word) {
        int n = word.length();
        if (n == 1) return true;
        int start = 0, end = n - 1;
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


}
