package com.leetcode.strings;

/**
 * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring obj=new LongestPalindromicSubstring();
        String word = "a";
        System.out.println(obj.longestPalindrome(word));
    }

    public String longestPalindrome(String s) {
        int n=s.length();
        String answer="";
        int maxLength=0;
        for(int i=0;i<n;i++){
            int len1=expandAroundCentre(s,i,i);
            int len2=expandAroundCentre(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len > maxLength){
                maxLength=len;
                int start=i-(len-1)/2;
                int end=i+(len/2);
                answer=s.substring(start,end+1);
            }
        }

        return answer;
    }



    private int expandAroundCentre(String word,int left,int right){

        while(left>=0 && right<word.length()-1 && word.charAt(left)==word.charAt(right)){
            left--;right++;
        }
        return right-left-1;
    }

//    public String longestPalindromeC(String s) {
//        int maxValue = Integer.MAX_VALUE;
//        System.out.println(maxValue);
//        int maxLength=0;
//        String res="";
//        for(int i=0;i<s.length();i++){
//            int len1=expandAroundCentre(s,i,i);
//            int len2=expandAroundCentre(s,i,i+1);
//            int len=Math.max(len1,len2);
//            if(len>maxLength){
//                int start=i-(len-1)/2;
//                int end=i+(len/2);
//                res=s.substring(start,end+1);
//                maxLength=len;
//            }
//        }
//        return res;
//    }
//
//    private int expandAroundCentre(String word,int l,int r){
//        int n=word.length();
//        while(l>=0 && r<n && word.charAt(l)==word.charAt(r)){
//            l--;r++;
//        }
//        return r-l-1;
//    }

//    public static String longestPalindromeExpandAroundCenter(String s) {
//        if (s == null || s.length() < 1) return "";
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);
//    }

//    private static int expandAroundCenter(String s, int left, int right) {
//        int L = left, R = right;
//        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//            L--;
//            R++;
//        }
//        return R - L - 1;
//    }
//
//    static String longestPalindrome(String word) {
//        int[][] dp = new int[word.length()][word.length()];
//        int maxLength = 0;
//        String longestPalindrome = "";
//        for (int gap = 0; gap < word.length(); gap++) {
//            for (int i = 0, j = i + gap; j < word.length(); i++, j++) {
//                if (gap == 0) {
//                    dp[i][j] = 1;
//                } else {
//                    boolean b = word.charAt(i) == word.charAt(j);
//                    if (gap == 1) {
//                        if (b) {
//                            dp[i][j] = 1;
//                        }
//                    } else {
//                        if (b && dp[i + 1][j - 1] == 1) {
//                            dp[i][j] = 1;
//                        }
//                    }
//                }
//                int length = (j - i) + 1;
//                if (dp[i][j]==1 && length > maxLength) {
//                    maxLength=length;
//                    longestPalindrome = word.substring(i, j + 1);
//                }
//            }
//        }
//        return longestPalindrome;
//    }
}
