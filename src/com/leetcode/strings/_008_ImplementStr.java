package com.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 28. Implement strStr()
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class _008_ImplementStr {

    public static void main(String[] args) {
        String haystack = "aaabaaa", needle = "aaab";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        if(needle.length()>haystack.length()){
            return -1;
        }

        int[] lps=new int[needle.length()];
        generateLPS(lps,needle);
        int i=0;
        int j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {
                if(j==0){
                    i++;
                }else{
                    j=lps[j-1];
                }
            }

            if(j==needle.length()){
                return i-needle.length();
            }
        }


        return -1;
    }


    private static void generateLPS(int[] lps,String needle){
        lps[0]=0;
        int prevLPS=0;
        int i=1;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(prevLPS)){
                lps[i++]=++prevLPS;
            }else{
                if(prevLPS==0){
                    lps[i++]=prevLPS;
                }else{
                    prevLPS=lps[prevLPS-1];
                }
            }
        }
    }



    public static int strStrBruteForce(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (checkPattern(haystack, i, needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static boolean checkPattern(String haystack, int index, String needle) {
        int j = 0;
        int i = index;
        if (haystack.length() - i < needle.length()) {
            return false;
        }
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
