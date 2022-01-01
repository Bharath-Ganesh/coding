package com.leetcode.strings;


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
        short num=21111;
        System.out.println(num);
        String firstWord = "rat", secondWord = "car";
        boolean b = firstWord instanceof String;
        System.out.println(b);
        System.out.println(isAnagramLeetcode(firstWord,secondWord));
    }

    public boolean isAnagram(String firstWord, String secondWord) {

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
