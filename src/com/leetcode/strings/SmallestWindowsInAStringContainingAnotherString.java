package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowsInAStringContainingAnotherString {

    public static void main(String[] args) {
        SmallestWindowsInAStringContainingAnotherString obj = new SmallestWindowsInAStringContainingAnotherString();
        String word = "mpsbqedzsqyskjqydomdanqfmtqri";
        String pattern = "rrbqrnbbzyijnwfnimshbjimbfe";
        System.out.println(smallestWindow(word, pattern));
    }

    public static String smallestWindow(String word, String pattern) {
        // Your code here
        Map<Character, Integer> desiredMap = new HashMap<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < pattern.length(); i++) {
            Character ch = pattern.charAt(i);
            desiredMap.put(ch, desiredMap.getOrDefault(ch, 0) + 1);
        }

        int matchCount = 0;
        int i = -1;
        int j = -1;
        String smallestWindow = "";
        Map<Character, Integer> map = new HashMap<>();
        while (true) {
            boolean flag1 = true;
            boolean flag2 = true;

            while (i < (word.length() - 1)) {
                flag1 = false;
                i++;
                Character ch = word.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.get(ch) <= desiredMap.getOrDefault(ch, 0)) {
                    matchCount++;
                }
                if (matchCount == pattern.length()) {
                    break;
                }
            }

            while (j < i && matchCount == pattern.length()) {
                flag2 = false;
                j++;
                int length = (i - j) + 1;
                if (length < minLength) {
                    minLength = length;
                    smallestWindow = word.substring(j, i + 1);
                }
                Character ch = word.charAt(j);
                int freq = map.get(ch);
                if (freq == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, freq - 1);
                }

                if (map.getOrDefault(ch, 0) < desiredMap.getOrDefault(ch, 0)) {
                    matchCount--;
                }
            }
            if (flag1 && flag2) {
                break;
            }
        }
        return minLength==Integer.MAX_VALUE?"-1":smallestWindow;
    }
}
