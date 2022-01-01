package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Check whether two strings are anagrams if you can replace atmost k characters in expression 1 with expression 2
 * Two strings are not anagrams if their length are not equal.
 * <p>
 * String exp1="ababaddccc"
 * String exp2="bcbecabacd"
 * int k=1;
 * Output
 * Not anagrams!!!
 */
public class CheckIfTwoStringsAreKAnagrams_19 {

    public static void main(String[] args) {
        String exp1 = "ababaddccc";
        String exp2 = "bcbecabacd";
        int k = 1;
        boolean isAnagram = checkIfTwoStringsAreKAnagrams(exp1, exp2, k);
        if (isAnagram)
            System.out.println("The two strings are anagrams");
        else
            System.out.println("Not anagrams!!!");
    }

    private static boolean checkIfTwoStringsAreKAnagrams(String exp1, String exp2, int k) {
        boolean isAnagram = true;

        Map<Character, Integer> exp1Map = new HashMap<>();
        Map<Character, Integer> exp2Map = new HashMap<>();

        if (exp1.length() != exp2.length())
            return false;

        for (int i = 0; i < exp1.length(); i++) {
            exp1Map.put(exp1.charAt(i), exp1Map.getOrDefault(exp1.charAt(i), 0) + 1);
            exp2Map.put(exp2.charAt(i), exp2Map.getOrDefault(exp2.charAt(i), 0) + 1);
        }

        //loop through one of the map and store the net freq in the second map
        //secondMap - firstMap
        for (Character ch : exp1Map.keySet()) {
            if (exp2Map.containsKey(ch)) {
                int freqDiff = exp2Map.get(ch) - exp1Map.get(ch);
                exp2Map.put(ch, freqDiff);
            } else {
                exp2Map.put(ch, exp1Map.get(ch) * -1);
            }
        }

        for (Character ch : exp2Map.keySet()) {
            int freq = exp2Map.get(ch);
            if (freq > 0) {
                k -= freq;
            }
            if (k < 0) {
                return false;
            }
        }

        return isAnagram;
    }


    private static boolean checkIfTwoStringsAreKAnagramsUsingSingleMap(String exp1, String exp2, int k) {
        boolean isAnagram = true;

        Map<Character, Integer> map = new HashMap<>();


        if (exp1.length() != exp2.length())
            return false;

        for (int i = 0; i < exp1.length(); i++) {
            map.put(exp1.charAt(i), map.getOrDefault(exp1.charAt(i), 0) + 1);
        }

        //loop through one of the map and store the net freq in the second map
        //secondMap - firstMap

        //we care only about either positive or negative
        for (int i = 0; i < exp2.length(); i++) {
            Character ch = exp2.charAt(i);
            if (map.getOrDefault(ch, 0) > 0) {
                map.put(ch, map.get(ch) - 1);
            }

        }

        int count = 0;
        for (Character ch : map.keySet()) {
            count += map.get(ch);
        }

        if (count > k) {
            return false;
        }
        ;
        return isAnagram;
    }
}
