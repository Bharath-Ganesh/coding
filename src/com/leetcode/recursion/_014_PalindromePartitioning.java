package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * <p>
 * A palindrome string is a string that reads the same backward as forward.
 * <p>
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * <p>
 * Input: s = "a"
 * Output: [["a"]]
 */
public class _014_PalindromePartitioning {

    public static void main(String[] args) {
        String word = "aab";
        System.out.println(partition(word));
    }

    public static List<List<String>> partition(String word) {
        List<List<String>> res = new ArrayList();
        int index = 0;
        List<String> curr = new ArrayList();
        partition(word, res, curr, index);
        return res;
    }

    public static void partition(String word, List<List<String>> res, List<String> curr, int index) {

        if (index == word.length()) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int i = index; i < word.length(); i++) {
            String palindrome = word.substring(index, i + 1);
            if (isPalindrome(palindrome)) {
                curr.add(palindrome);
                partition(word, res, curr, i + 1);

                curr.remove(curr.size() - 1);
            }
        }

    }


    private static boolean isPalindrome(String word) {
        if (word.length() == 1) {
            return true;
        }

        int start = 0;
        int end = word.length() - 1;
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
