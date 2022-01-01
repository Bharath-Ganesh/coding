package com.leetcode.array;

import java.util.Queue;

/**
 * 1528. Shuffle String
 * Given a string s and an integer array indices of the same length.
 *
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 *
 * Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * Output: "leetcode"
 * Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.
 */
public class ShuffleString_34 {

    public static void main(String[] args) {
        int  indices[] = {4,5,6,7,0,2,1,3};
        String s="codeleet";
        System.out.println(restoreString(s,indices));
    }

    public static String restoreString(String s, int[] indices) {
        StringBuilder str=new StringBuilder(s);
        for(int i=0;i<indices.length;i++){
            str.setCharAt(indices[i],s.charAt(i));
        }
        return str.toString();
    }
}
