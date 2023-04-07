package com.practice.pepcoding.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Anagram is an expression with each character having exact same frequency with other characters
 * Given a strings exp and a pattern, return an array of all the start indices of pattern's anagrams in exp.
 * You may return the answer in any order.
 * String exp="cbaebabacd"
 * String pattern="abc"
 * Output:
 * [0,6]
 * The substring with start index = 0 is "cba", which is an anagram of "abc"
 *
 * Example2
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 */
public class FindAllAnagrams_18 {
    public static void main(String[] args) {
        String exp = "cbacbabacd";
        String pattern = "abc";
        List<Integer> answer = findAllAnagrams(exp, pattern);
        System.out.println(answer);
    }

    private static List<Integer> findAllAnagrams(String exp, String pattern) {
        List<Integer> answer = new ArrayList<>();
        //frequency of the pattern
        Map<Character, Integer> patternFreqMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
            patternFreqMap.put(pattern.charAt(i), patternFreqMap.getOrDefault(pattern.charAt(i), 0) + 1);
        Map<Character, Integer> actualMap = new HashMap<>();
        int matchCount=0;
        for(int i=0;i<pattern.length()-1;i++){
            Character ch=exp.charAt(i);
            actualMap.put(exp.charAt(i), actualMap.getOrDefault(exp.charAt(i), 0) + 1);
            if(patternFreqMap.getOrDefault(ch,0)>=actualMap.getOrDefault(ch,0)){
                matchCount++;
            }
        }

        for (int i=pattern.length()-1;i<exp.length();i++){
            Character ch=exp.charAt(i);
            actualMap.put(exp.charAt(i), actualMap.getOrDefault(exp.charAt(i), 0) + 1);
            if(patternFreqMap.getOrDefault(ch,0)>=actualMap.getOrDefault(ch,0)){
                matchCount++;
            }

            if(matchCount==pattern.length()){
                answer.add((i + 1) - pattern.length());
            }

            Character charToBeRemoved = exp.charAt((i + 1) - pattern.length());
            if(patternFreqMap.getOrDefault(charToBeRemoved,0)>=actualMap.getOrDefault(ch,0)){
                matchCount--;
            }
            if (actualMap.getOrDefault(charToBeRemoved, 0) == 1) {
                actualMap.remove(charToBeRemoved);
            } else {
                actualMap.put(exp.charAt(i), actualMap.getOrDefault(exp.charAt(i), 0) - 1);
            }
        }

        return answer;
    }


    public static boolean compare(Map<Character, Integer> actualMap, Map<Character, Integer> patternFreqMap) {
        for (Character ch : actualMap.keySet()) {
            if (!(actualMap.getOrDefault(ch, 0) == patternFreqMap.getOrDefault(ch, 0))) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> findAllAnagramsPepcoding(String exp, String pattern) {
        List<Integer> answer = new ArrayList<>();
        //frequency of the pattern
        Map<Character, Integer> patternFreqMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
            patternFreqMap.put(pattern.charAt(i), patternFreqMap.getOrDefault(pattern.charAt(i), 0) + 1);

        Map<Character, Integer> actualMap = new HashMap<>();

        int i = -1;
        int j = -1;

        int count = 0;
        while (true) {
            boolean flag1 = true;
            while (i < exp.length() - 1) {
                //cbaebabacd
                count++;
                flag1 = false;
                i++;
                Character ch = exp.charAt(i);
                actualMap.put(exp.charAt(i), actualMap.getOrDefault(exp.charAt(i), 0) + 1);
                if (count == pattern.length()) {
                    if (compare(actualMap, patternFreqMap)) {
                        answer.add((i + 1) - pattern.length());
                    }
                    Character charToBeRemoved = exp.charAt((i + 1) - pattern.length());
                    if (actualMap.getOrDefault(charToBeRemoved, 0) == 1) {
                        actualMap.remove(charToBeRemoved);
                    } else {
                        actualMap.put(exp.charAt(i), actualMap.getOrDefault(exp.charAt(i), 0) - 1);
                    }
                    count--;
                }
            }
            if (flag1) {
                break;
            }
        }


        return answer;
    }


}
