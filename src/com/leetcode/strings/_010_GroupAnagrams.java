package com.leetcode.strings;

import java.util.*;

/**
 * 49. Group Anagrams
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * <p>
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class _010_GroupAnagrams {
    public static void main(String[] args) {
        String words[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(words));
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> keyMap = new HashMap();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> wordList = keyMap.getOrDefault(key, new ArrayList<>());
            wordList.add(word);
            keyMap.put(key, wordList);
        }
        return new ArrayList<>(keyMap.values());
    }
}
