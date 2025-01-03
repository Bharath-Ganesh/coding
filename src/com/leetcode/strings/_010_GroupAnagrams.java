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
        _010_GroupAnagrams obj = new _010_GroupAnagrams();
    }

    public List<List<String>> Anagrams(String[] words) {
        // Code here
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String key = constructFreqKey(word);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        for (Map.Entry<String, List<String>> mapEntry : map.entrySet()) {
            if (mapEntry.getValue().size() > 1) {
                Collections.sort(mapEntry.getValue());
                result.add(mapEntry.getValue());
            }
        }
        return result;
    }

    public String constructFreqKey(String word) {

        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        String key = "";
        for (Map.Entry<Character, Integer> mapEntry : map.entrySet()) {
            key += mapEntry.getKey() + "" + mapEntry.getValue();
        }
        return key;
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
