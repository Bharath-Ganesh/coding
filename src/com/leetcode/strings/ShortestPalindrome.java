package com.leetcode.strings;

/**
 * 214. Shortest Palindrome
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        ShortestPalindrome obj = new ShortestPalindrome();
        String word = "aacecaaa";
        System.out.println(obj.shortestPalindromeKMP(word));
    }

    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = rev(s);
        for (int i = 0; i < n; i++) {
            String substring = s.substring(0, n - i);
            String revstring = rev.substring(i);
            if (substring.equals(revstring))
                return rev.substring(0, i) + s;
        }
        return "";
    }

    private String rev(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String shortestPalindromeTwoPointer(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j))
                i++;
        }
        if (i == n) {
            return s;
        }
        String remain_rev = s.substring(i, n);
        String rev = rev(remain_rev);
        return rev + shortestPalindrome(s.substring(0, i)) + s.substring(i);
    }

    public String shortestPalindromeKMP(String s) {
        int n = s.length();
        String rev = rev(s);
        String s_new = s   + "#" + rev;
        int n_new = s_new.length();
        int[] lps = computeLPS(s_new);
        String substring = rev.substring(0, n - lps[n_new - 1]);
        return  substring + s;
    }
    private int[] computeLPS(String needle){
        int len=0;
        int i=1;
        int m=needle.length();
        int[] lps=new int[m];
        while(i<m){
            if(needle.charAt(i)==needle.charAt(len)){
                lps[i]=++len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i++]=0;
                }
            }

        }
        return lps;
    }
}
