package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstingWithoutRepeating_39 {

    public static void main(String[] args) {
        //String word = "abcabcbb";
        String word = "abba";
        System.out.println(lengthOfLongestSubstringLeetcode(word));
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int maxLength = 0;
        while (true) {
            boolean flag1 = true;
            boolean flag2 = true;
            while (i < s.length() - 1) {
                flag1 = false;
                i++;
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                if (map.size() != (i - j)) {
                    break;
                } else {
                    int length = (i - j);
                    maxLength = maxLength < length ? length : maxLength;
                }
            }

            while (j < i ) {
                flag2 = false;
                j++;
                Character ch = s.charAt(j);
                int freq = map.get(ch);
                if (freq == 2) {
                    map.put(ch, freq - 1);
                    break;
                } else {
                    map.remove(ch);
                }
            }

            if (flag1 && flag2) {
                break;
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringLeetcode(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;
        int j=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                j=Math.max(j,map.get(ch)+1);
            }
            map.put(ch,i);
            maxLength=Math.max(i-j+1,maxLength);
        }
        return maxLength;
    }
}
