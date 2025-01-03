package com.codingassesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Trial {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(arr));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String word = strs[i];
            createKeyMap(map, word);
        }

        for(Map.Entry<String, List<String>> mapEntry : map.entrySet()){
            result.add(mapEntry.getValue());
        }

        return result;

    }


    public static void createKeyMap(Map<String, List<String>> map, String word){

        Map<Character, Integer> characterMap = new TreeMap<>();
        for(int i=0; i<word.length(); i++){
            Character ch = word.charAt(i);
            characterMap.put(ch, characterMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder key = new StringBuilder();
        for(Map.Entry<Character, Integer> mapEntry : characterMap.entrySet()){
            key.append(mapEntry.getKey());
            key.append(mapEntry.getValue());
        }
        List<String> anagramList = map.getOrDefault(key.toString(), new ArrayList<>());
        anagramList.add(word);
        map.put(key.toString(), anagramList);
    }
}
