package com.practice.uiuc;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubString {

    public static void main(String[] args) {
        MinWindowSubString obj = new MinWindowSubString();
        String s = "aa", t = "aaaa";
        System.out.println(obj.minWindow(s, t));
    }

    public String minWindow(String word, String t) {

        //s = "ADOBECAODEBANC"
        // t = "AABC"
        int left = 0;
        int right = 0;
        int n = word.length();
        String result = "";
        Map<Character, Integer> desiredMap = new HashMap<>();
        for(int i=0; i< t.length(); i++){
            desiredMap.put(t.charAt(i), desiredMap.getOrDefault(t.charAt(i), 0)+1);
        }

        Map<Character, Integer> currentMap = new HashMap<>();
        int minLength = word.length() + 1;
        int desiredFreq = 0;

        for(right = 0; right < n; right++){
            Character ch = word.charAt(right);
            currentMap.put(ch, currentMap.getOrDefault(ch, 0) + 1);
            if(desiredMap.containsKey(ch) && desiredMap.get(ch) >= currentMap.getOrDefault(ch,0)){
                desiredFreq++;
            }
            while(desiredFreq == t.length()){
                int length =  (right - left)+ 1;
                if(length < minLength){
                    minLength =  length;
                    result = word.substring(left, right+1);
                }

                Character charToBeRemoved = word.charAt(left);
                int freqToBeReduced = currentMap.get(charToBeRemoved);
                if(freqToBeReduced == desiredMap.getOrDefault(charToBeRemoved, 0)){
                    desiredFreq--;
                }
                if(freqToBeReduced == 1){
                    currentMap.remove(charToBeRemoved);
                }else{
                    currentMap.put(charToBeRemoved, freqToBeReduced - 1);
                }
                left++;
            }

        }
        return result;
    }
}
