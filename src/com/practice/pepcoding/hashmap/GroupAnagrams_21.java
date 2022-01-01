package com.practice.pepcoding.hashmap;

import java.util.*;

/**
 * Group anagrams based on their occurrence
 * String[] arr={ "abcc","acbc","badc","abcd","dabb","babd","dbca","cabc"};
 * Output
 * [ [abcc,acbc,cabc],[badc,abcd,dbca],[dabb,babd] ]
 */
public class GroupAnagrams_21 {
    public static void main(String[] args) {
        GroupAnagrams_21 obj=new GroupAnagrams_21();
        String[] arr = {"eat","tea","tan","ate","nat","bat","ac","bd","aac","bbd","aacc","bbdd","acc","bdd" };
        List<List<String>> list = obj.groupAnagrams(arr);
        System.out.println(list);
//        List<List<String>> list2 = obj.groupAnagramsPepcoding(arr);
//        System.out.println(list);


    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> keyMap=new HashMap<>();

        for(String word : strs){
            TreeMap<Character,Integer> freqMap=new TreeMap<>();
            for(Character ch : word.toCharArray()){
                freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
            }
            String key=generateKey(freqMap);
            List<String> curList=keyMap.getOrDefault(key,new ArrayList());
            curList.add(word);
            keyMap.put(key,curList);
        }

        for(Map.Entry<String,List<String>> map : keyMap.entrySet()){
            res.add(map.getValue());
        }
        return res;

    }

    private String generateKey(TreeMap<Character,Integer> freqMap){
        StringBuilder res=new StringBuilder();
        for(Map.Entry<Character,Integer> map : freqMap.entrySet()){
            res.append(map.getKey() + "" + map.getValue());
        }
        return res.toString();
    }

//    private static List<List<String>> groupAnagrams(String[] arr) {
//
//        List<List<String>> output= new ArrayList<>();
//        Map<String, List<String>> map = new HashMap<>();
//        //map for acquiring final string
//        for (String word : arr) {
//            String expression = "";
//            Map<Character, Integer> freqMap = new HashMap<>();
//            for (int i = 0; i < word.length(); i++) {
//                Character ch = word.charAt(i);
//                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
//            }
//
//            for (Character ch : freqMap.keySet()) {
//                expression += "" + ch + freqMap.get(ch);
//            }
//
//            List<String> list2 = map.getOrDefault(expression, new ArrayList<>());
//            list2.add(word);
//            map.put(expression, list2);
//        }
//
//        for (String word : map.keySet()) {
//            output.add(map.get(word));
//        }
//
//        return output;
//    }
//
//
//    private static List<List<String>> groupAnagramsPepcoding(String[] arr) {
//
//        List<List<String>> output= new ArrayList<>();
//        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
//        //map for acquiring final string
//        for (String word : arr) {
//            Map<Character, Integer> freqMap = new HashMap<>();
//            for (int i = 0; i < word.length(); i++) {
//                Character ch = word.charAt(i);
//                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
//            }
//
//            List<String> list2 = map.getOrDefault(freqMap, new ArrayList<>());
//            list2.add(word);
//            map.put(freqMap, list2);
//        }
//
//        for (List<String> words: map.values()){
//            output.add(words);
//        }
//        return output;
//    }
}
