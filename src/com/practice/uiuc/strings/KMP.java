package com.practice.uiuc.strings;

public class KMP {

    public static void main(String[] args) {
        KMP obj = new KMP();
        System.out.println(obj.longestPrefixSuffix("bacddbbabd"));
    }

    public int longestPrefixSuffix(String s) {

        int len = 0;
        int i = 1;
        int n = s.length();
        int[] lps = new int[n];
        int maxLength = 0;
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                lps[i] = ++len;
                i++;
            }else {
                if(len != 0){
                    len = lps[len - 1];
                }else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[n-1];

    }
}
