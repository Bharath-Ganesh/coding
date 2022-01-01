package com.leetcode.bits;

/**
 * 389. Find the Difference
 * You are given two strings s and t.

 * String t is generated by random shuffling string s and then add one more letter at a random position.

 * Return the letter that was added to t.

 * Input: s = "abcd", t = "abcde"
 * Output: "e"
 * Explanation: 'e' is the letter that was added.
 * Input: s = "", t = "y"
 * Output: "y"
 */
public class _004_FindTheDifference {

    public static void main(String[] args) {
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference(s,t));
    }

    public static char findTheDifference(String s, String t) {
        int result=0;
        for (int i=0;i<s.length();i++){
            result= result ^ (s.charAt(i)-'a') ^ (t.charAt(i)-'a');
        }
        result=result ^ (t.charAt(t.length()-1)-'a');
        char ch =(char) (result+'a');
        return ch;
    }
}