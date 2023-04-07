package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * <p>
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 * <p>
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 */
public class RansomNote_2 {

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstructLeetcode(ransomNote,magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return false;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            int freq = freqMap.getOrDefault(ch, 0);
            if (freq == 0)
                return false;
            freqMap.put(ch, freq - 1);
        }
        return true;
    }

    public static boolean canConstructLeetcode(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return false;

        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
