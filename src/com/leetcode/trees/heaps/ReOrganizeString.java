package com.leetcode.trees.heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReOrganizeString {
    public static void main(String[] args) {
        ReOrganizeString obj = new ReOrganizeString();
        String word = "aaabbc";
        String s = obj.reorganizeString(word);
        System.out.println(s);
    }

    public String reorganizeString(String word) {

        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());

        while (pq.size() > 1){
            Character curr=pq.remove();
            Character prev=pq.remove();
            result.append(curr);
            result.append(prev);
            if(map.get(curr)>1){
                map.put(curr,map.get(curr)-1);
                pq.add(curr);
            }
            if(map.get(prev)>1) {
                map.put(prev, map.get(prev) - 1);
                pq.add(prev);
            }
        }
        if(!pq.isEmpty()){
            Character ch=pq.remove();
            if(map.get(ch)>1){
                return "";
            }
            result.append(ch);
        }
        return result.toString();
    }
}
