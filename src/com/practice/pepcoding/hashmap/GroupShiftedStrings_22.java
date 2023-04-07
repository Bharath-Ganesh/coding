package com.practice.pepcoding.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group strings such that the distance between the corresponding characters of any two words are equal and they're
 * of equal length
 * <p>
 * String[] arr = {"acd","dfg","abc","def","wyz","yab","mop","bdfh","a","x","moqs"};
 * Output:
 * ["acd", "dfg", "mop", "wyz", "yab"],["a", "x"],["bdfh", "moqs"]["abc","def"]
 */
public class GroupShiftedStrings_22 {
    public static void main(String[] args) {
        String[] arr = {"acd", "dfg", "wyz", "yab", "abc","def","mop", "bdfh", "a", "x", "moqs","ab","de"};
        List<List<String>> output = groupShiftedStrings(arr);
        System.out.println(output);
    }

    private static List<List<String>> groupShiftedStrings(String[] arr) {
        List<List<String>> answer = new ArrayList<>();

        //Map represents the distance between the characters of a word
        Map<String,List<String>> hashKeyMap = new HashMap<>();
        for(String word : arr){
            String key="";
            for (int i=1;i<word.length();i++){
                int diff= word.charAt(i)-word.charAt(i-1);
                diff = diff > 0 ? diff : diff+26;
                key+=diff+"#";
//                if(i==(word.length()-1)){
//                    break;
//                }
            }
            List<String> words=hashKeyMap.getOrDefault(key,new ArrayList<>());
            words.add(word);
            hashKeyMap.put(key,words);
        }

        for(List<String> words : hashKeyMap.values()){
            answer.add(words);
        }

        return answer;
    }
}
