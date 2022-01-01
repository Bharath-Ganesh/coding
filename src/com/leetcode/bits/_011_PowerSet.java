package com.leetcode.bits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Input : str = "abc"
 * Output: a ab abc ac b bc c
 * Explanation : There are 7 substrings that
 * can be formed from abc.
 */
public class _011_PowerSet {

    public static void main(String[] args) {
        String word = "abc";
        System.out.println(AllPossibleStrings(word));
    }

    public static List<String> AllPossibleStrings(String word) {
        // Code here
        List<String> res = new ArrayList();
        int n = (1 << word.length());
        for (int i = 1; i < n; i++) {
            StringBuffer ans = new StringBuffer();
            int temp = i;
            for (int j = 0; j < word.length(); j++) {
                if ((temp & 1) == 1) {
                    ans.append(word.charAt(j));
                }
                temp = temp >> 1;
            }
            res.add(ans.toString());
        }
        Collections.sort(res);
        return res;
    }
}
