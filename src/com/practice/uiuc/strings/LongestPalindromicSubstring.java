package com.practice.uiuc.strings;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome("aaaabbaa"));
    }

    private String longestPalindrome(String s) {
        // code here
        int maxLength = 0;
        int start = 0; int end = 0;
        for(int index = 0; index < s.length(); index++){

            int length1 = findLength(index, index, s);
            int length2 = findLength(index, index + 1, s);
            int length = Math.max(length1, length2);
            if(maxLength < length){
                start = (index + 1) - (length+1)/2;
                end = index + (length/2);
                maxLength = length;
            }
        }
        String longestPalindrome = s.substring(start, end+1);
        return longestPalindrome;
    }

    private int findLength(int L, int R, String s){

        while(L >=0 && R<s.length() && s.charAt(L) == s.charAt(R)){
            L--;R++;
        }

        return (R-L)-1;
    }
}
