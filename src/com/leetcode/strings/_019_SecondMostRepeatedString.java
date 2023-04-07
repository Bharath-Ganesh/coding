package com.leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * https://practice.geeksforgeeks.org/problems/second-most-repeated-string-in-a-sequence0534/1#
 * Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.
 * <p>
 * Note: No two strings are the second most repeated, there will be always a single string.
 * <p>
 * Input:
 * N = 6
 * arr[] = {aaa, bbb, ccc, bbb, aaa, aaa}
 * Output: bbb
 * Explanation: "bbb" is the second most
 * occurring string with frequency 2.
 */
public class _019_SecondMostRepeatedString {

    public static void main(String[] args) {
        String[] arr = {"aaa",  "ccc", "aaa", "aaa"};
        System.out.println(secFrequent(arr, arr.length));

    }

    private static String secFrequent(String arr[], int N) {
        // your code here
        Map<String, Integer> map = new HashMap<>();

        int maxFreq = 0;
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(word));
        }

        String[] bucket = new String[maxFreq + 1];
        for (String word : map.keySet()) {
            int freq = map.get(word);
            bucket[freq] = word;
        }

        String answer = "";
        for (int i = maxFreq - 1; i >= 0; i--) {
            if (Optional.ofNullable(bucket[i]).isPresent()) {
                answer = bucket[i];
                break;
            }
        }
        return answer;
    }
}
