package com.leetcode.strings;


import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class ValidAnagram_3 {

    public static void main(String[] args) {
        ValidAnagram_3 obj=new ValidAnagram_3();
        short num=21111;
        System.out.println(num);
        String firstWord = "aacc", secondWord = "ccac";
        boolean b = firstWord instanceof String;
        System.out.println(b);
        obj.isAnagram(firstWord,secondWord);
    }

    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();

        if(n!=m){
            return false;
        }
        //freq map to store the number of occurrence of a character
        Map<Character,Integer> freqMap=new HashMap<>();
        for(int i=0;i<n;i++){
            Character ch=s.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<n;i++){
            Character ch=t.charAt(i);
            //"aacc"
            //ccac
            if(!freqMap.containsKey(ch)){
                return false;
            }
            int freq=freqMap.get(ch);
            freqMap.put(ch,freq-1);
            if(freq==0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramSecond(String firstWord, String secondWord) {

        if(firstWord.length()!=secondWord.length())
            return false;

        int arr[]=new int[26];
        for(int i=0;i<firstWord.length();i++){
            ++arr[firstWord.charAt(i)-'a'];
        }

        for(int i=0;i<secondWord.length();i++){
            if( --arr[secondWord.charAt(i)-'a'] <0)
                return false;
        }
        return true;

    }


    public static boolean isAnagramLeetcode(String s, String t) {

        if(s.length()!=t.length())
            return false;
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++){
            if(--freq[t.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }

}
