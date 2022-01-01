package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * String s = "leetcode"
 * Output: 0
 */
public class FirstUniqueCharacterInString_1 {

    public static void main(String[] args) {
        String word = "leetcode";
        System.out.println(firstUniqChar(word));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            int freq = freqMap.get(ch);
            if (freq == 1) {
                return i;
            }
        }
        return -1;
    }
}
