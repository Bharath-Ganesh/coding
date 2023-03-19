package com.leetcode.strings;

import java.util.*;

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
        _008_ImplementStr obj = new _008_ImplementStr();
        String haystack = "leetcode", needle = "leeto";
        System.out.println(obj.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int[] lps=lps(needle);

        for(int i=0;i<haystack.length();){
            for(int j=0;j<needle.length();){
                if(i<haystack.length() && haystack.charAt(i)==needle.charAt(j)){
                    if(j==needle.length()-1){
                        return (i+1)-needle.length();
                    }
                    i++;j++;
                }else{
                    if(j==0){
                        i++;
                    }else{
                        j=lps[j-1];
                    }
                }
            }
        }
        return -1;
    }


    private int[] lps(String word){
        int n=word.length();
        int prevLps=0;
        int i=1;
        int[] lps=new int[n];

        while(i<n){
            if(word.charAt(i)==word.charAt(prevLps)){
                lps[i++]=++prevLps;
            }else{
                if(prevLps==0){
                    lps[i++]=prevLps;
                }else{
                    prevLps=lps[prevLps-1];
                }
            }
        }
        return lps;

    }

//    public int strStr(String haystack, String needle) {
//
//        int n=haystack.length();
//        int m=needle.length();
//        int[] lps=computeLPS(needle);
//        int i=0,j=0;
//        while(i<n){
//
//            if(haystack.charAt(i)==needle.charAt(j)){
//                i++;j++;
//            }else{
//                if(j!=0){
//                    j=lps[j-1];
//                }else{
//                    i++;
//                }
//            }
//            if(j==m){
//                return (i)-m;
//            }
//        }
//        return -1;
//    }
//
//
//    private int[] computeLPS(String needle){
//        int n=needle.length();
//        int[] lps=new int[n];
//        int index=1,prevLPS=0;
//        while(index<n){
//            if(needle.charAt(index)==needle.charAt(prevLPS)){
//                lps[index++]=++prevLPS;
//            }else{
//                if(prevLPS!=0){
//                    prevLPS=lps[prevLPS-1];
//                }else{
//                    index++;
//                }
//            }
//        }
//        return lps;
//    }
}
