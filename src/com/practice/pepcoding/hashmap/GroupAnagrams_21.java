package com.practice.pepcoding.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group anagrams based on their occurrence
 * String[] arr={ "abcc","acbc","badc","abcd","dabb","babd","dbca","cabc"};
 * Output
 * [ [abcc,acbc,cabc],[badc,abcd,dbca],[dabb,babd] ]
 */
public class GroupAnagrams_21 {
    public static void main(String[] args) {
        String[] arr = {"abcc", "acbc", "badc", "abcd", "dabb", "babd", "dbca", "cabc" };
        List<List<String>> list = groupAnagrams(arr);
        System.out.println(list);
        List<List<String>> list2 = groupAnagramsPepcoding(arr);
        System.out.println(list);


    }

    private static List<List<String>> groupAnagrams(String[] arr) {

        List<List<String>> output= new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        //map for acquiring final string
        for (String word : arr) {
            String expression = "";
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            for (Character ch : freqMap.keySet()) {
                expression += "" + ch + freqMap.get(ch);
            }

            List<String> list2 = map.getOrDefault(expression, new ArrayList<>());
            list2.add(word);
            map.put(expression, list2);
        }

        for (String word : map.keySet()) {
            output.add(map.get(word));
        }

        return output;
    }


    private static List<List<String>> groupAnagramsPepcoding(String[] arr) {

        List<List<String>> output= new ArrayList<>();
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        //map for acquiring final string
        for (String word : arr) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                Character ch = word.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }

            List<String> list2 = map.getOrDefault(freqMap, new ArrayList<>());
            list2.add(word);
            map.put(freqMap, list2);
        }

        for (List<String> words: map.values()){
            output.add(words);
        }
        return output;
    }
}
