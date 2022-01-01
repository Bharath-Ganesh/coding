package com.leetcode.strings;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 686. Repeated String Match
 * https://leetcode.com/problems/repeated-string-match/
 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        RepeatedStringMatch obj = new RepeatedStringMatch();
        String pattern = "aaac";
        String text = "aac";

        System.out.println(obj.repeatedStringMatchImp2(pattern, text));
    }


    private int[] computeLPS(String word) {
        int len = 0;
        int i = 1;
        int[] lps = new int[word.length()];
        while (i < word.length()) {
            if (word.charAt(i) == word.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i++] = 0;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

    public int repeatedStringMatch(String pattern, String text) {
        int a = pattern.length(), b = text.length();

        //Making LPS array using string 'text'
        int lps[] = computeLPS(text);

        //Search 'text' in 'pattern' in a circular fashion
        //variable 'i' represents the starting index of 'text' in string 'pattern'
        //variable 'j' points to the current index in both strings 'pattern' and 'text'
        //(i+j)%a represents circular next index in 'pattern', as if it were linearly repeted


        for (int i = 0, j = 0; i < a; ) {
            int index = (i + j) % a;
            if (text.charAt(j) == pattern.charAt(index)) {
                ++j;//check for next in both
            }
            if (j == b)//returns suitable answer
            {
                if ((i + j) % a > 0) {
                    return ((i + j) / a) + 1;
                }
                return (i + j) / a;
            } else if (i < a && text.charAt(j) != pattern.charAt((i + j) % a)) {
                if (j != 0) {
                    i += (j - lps[j - 1]);//updating 'i' here helps to keep pointed to the same position in 'A'
                    j = lps[j - 1];
                } else {
                    ++i;//even if no match found for the first letter of the pattern increment 'i'
                }
            }

        }
        return -1;//if not possible to represent as multiple of 'A' return '-1'
    }

    public int repeatedStringMatchImp2(String pattern, String text) {
        int a = pattern.length(), b = text.length();

        //Making LPS array using string 'text'
        int lps[] = computeLPS(text);

        for (int i = 0, j = 0; i < pattern.length(); i++, j = j != 0 ? lps[j - 1] : 0) {
            while (j < text.length() && pattern.charAt((i + j) % a) == text.charAt(j)){
                j++;
            }
            if (j == text.length()) {
                return (int) Math.ceil((float)(i+j) / a);
            }
        }
        return -1;
    }

}
