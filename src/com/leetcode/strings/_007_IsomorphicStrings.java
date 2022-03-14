package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 */
public class _007_IsomorphicStrings {

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s, t));

    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> charMap = new HashMap();
        Map<Character, Boolean> valMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Character val = t.charAt(i);
            if (charMap.containsKey(key)) {
                if (charMap.get(key) != val) {
                    return false;
                }
            } else {
                if (valMap.containsKey(val)) {
                    return false;
                }
                charMap.put(key, val);
                valMap.put(val, true);
            }
        }
        return true;
    }
}
