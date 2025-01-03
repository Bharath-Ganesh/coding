package com.codingassesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
Write an algorithm to find the substring that is the same when read forwards and backwards from the given string.
The substring should also be present in both forward and backward strings.

Input: The input consists of a string s representing the puzzle.

Output: From the given string, print the substring which is the same when read forwards and backwards if there is one.
If there are multiple substrings of equal length, choose the lexicographically smallest one. If there are multiple
substrings of different lengths, choose the one with the maximum length. If there is no such substring, print “None”.
 The substring is only valid if its length is more than 1. The string only contains uppercase characters (A-Z).
 */
public class Cisco {

    public static void main(String[] args) {
        int x = 0x7FFFFFFF;

        System.out.println(x);
        System.out.println(Integer.MAX_VALUE);
        System.out.println( (-7 & 0x7FFFFFFF) % 12);
        System.out.println( (7 & 0x7FFFFFFF) % 12) ;

        String input = "ABCA";
        System.out.println(input.substring(0, 2));

        String output = findSubString(input);
        System.out.println(output);
    }

    public static String findSubString(String s) {
        if (s == null || s.length() < 1)
            return "None";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        String result = s.substring(start, end + 1);
        return result.length() > 1 ? result : "None";
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
