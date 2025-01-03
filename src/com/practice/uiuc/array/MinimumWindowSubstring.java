package com.practice.uiuc.array;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {


        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> desiredMap = new HashMap<>();
        int n1 = t.length();
        int n2 = s.length();
        for(int i = 0; i < n1; i++){
            Character ch = t.charAt(i);
            desiredMap.put(ch, desiredMap.getOrDefault(ch, 0) + 1);
        }

        String res = "";
        int desiredFreq = t.length();
        int minLength = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;


        int matches = 0;
        while(true){
            boolean flag1 = false, flag2 = false;
            // acquire strings
            while(index2 < n2 - 1 && matches < desiredFreq){
                flag1 = true;
                index2++;
                Character ch2 = s.charAt(index2);
                map.put(ch2, map.getOrDefault(ch2, 0) + 1);
                if(desiredMap.containsKey(ch2) && desiredMap.get(ch2) >= map.get(ch2)){
                    matches++;
                }
            }
            // remove: Desired freq attained
            while(index1 < index2 && matches == desiredFreq){
                flag2 = true;
                index1++;
                int length = (index2 - index1) + 1;
                if(minLength > length){
                    minLength = length;
                    res = s.substring(index1, index2 + 1);
                }

                Character ch1 = s.charAt(index1);
                int freq = map.get(ch1);


                if(desiredMap.containsKey(ch1) && desiredMap.get(ch1) >= map.getOrDefault(ch1, 0)){
                    matches--;
                }

                if(freq == 1){
                    map.remove(ch1);
                }else{
                    map.put(ch1, freq - 1);
                }

            }

            if(!flag1 && !flag2) break;
        }

        return res;
    }
}
