package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/permutation-in-string/
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2
 * <p>
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 */
public class _021_PermutationInAString {

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }
        StringBuffer anagram = new StringBuffer();
        for (int i = 0; i < s1.length() - 1; i++) {
            anagram.append(s2.charAt(i));
        }
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            anagram.append(s2.charAt(i));
            if (isAnagram(s1, anagram.toString())) {
                return true;
            }
            anagram.deleteCharAt(0);
        }
        return false;
    }


    public static boolean isAnagram(String s1, String anagram) {
        int[] freq = new int[26];
        char[] arr = s1.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            ++freq[arr[i] - 'a'];
        }

        char[] arr2 = anagram.toCharArray();
        for (int i = 0; i < arr2.length; i++) {
            if (--freq[arr2[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
