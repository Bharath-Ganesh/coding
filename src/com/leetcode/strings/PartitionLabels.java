package com.leetcode.strings;

import java.util.*;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels obj = new PartitionLabels();
        String word = "eccbbbbdec";
        System.out.println(obj.partitionLabels(word));
    }

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> wordMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
        }

        Set<Character> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            int freq = wordMap.get(ch);
            set.add(ch);
            wordMap.put(ch, freq - 1);
            if (freq == 1) {
                if (compareFreq(set, wordMap)) {
                    res.add(i - start);
                    start = i;
                    set = new HashSet();
                }
            }
        }
        return res;
    }

    private boolean compareFreq(Set<Character> set, Map<Character, Integer> wordMap) {

        for (char ch : set) {
            if (wordMap.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }
}
