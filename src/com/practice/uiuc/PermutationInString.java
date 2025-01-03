package com.practice.uiuc;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion("ab","eidboaoo"));
        System.out.println(obj.checkInclusion2("ab","eidboaoo"));
    }

    public boolean checkInclusion2(String s1, String s2) {

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int n1 = s1.length();
        int n2 = s2.length();

        for(int i=0; i<n1; i++){
            s1Count[s1.charAt(i)-'a']++;
            s2Count[s2.charAt(i)-'a']++;
        }

        int matches = 0;
        for(int i=0; i<26; i++){
            if(s1Count[i]==s2Count[i]) matches++;
        }

        int left = 0, right = n1;

        while(right < n2){

            if(matches == 26) return true;

            int index = s2.charAt(right)-'a';

            s2Count[index]++;
            if(s2Count[index] == s1Count[index]) matches++;
            else if(s2Count[index] == s1Count[index] + 1) matches--;


            index = s2.charAt(left)-'a';
            s2Count[index]--;
            if(s2Count[index] == s1Count[index]) matches++;
            else if(s2Count[index] == s1Count[index] + 1) matches--;

            left++;
            right++;
        }
        return matches == 26;
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> desiredMap = new HashMap<>();
        Map<Character, Integer> currMap = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            Character ch = s1.charAt(i);
            desiredMap.put(ch, desiredMap.getOrDefault(ch, 0) + 1);
        }

        int n1 = s1.length();
        int n2 = s2.length();

        int desiredFreq = 0;
        int left= 0;
        int right = 0;

        while(right < n2){

            Character ch = s2.charAt(right);
            currMap.put(ch, currMap.getOrDefault(ch, 0) + 1);
            if(desiredMap.containsKey(ch) && desiredMap.get(ch) >= currMap.get(ch)){
                desiredFreq++;
            }

            if(desiredFreq == n1) return true;

            if(right >= n1-1){
                Character charToBeRemoved = s2.charAt(left);
                int freq = currMap.get(charToBeRemoved);
                if(desiredMap.containsKey(charToBeRemoved) && freq <= desiredMap.get(charToBeRemoved)){
                    desiredFreq--;
                }

                if(freq == 1){
                    currMap.remove(charToBeRemoved);
                }else{
                    currMap.put(charToBeRemoved, freq-1);
                }
                left++;
            }
            right++;
        }
        return false;

    }
}
