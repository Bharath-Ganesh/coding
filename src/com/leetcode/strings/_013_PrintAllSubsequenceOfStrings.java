package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-subsequences-string/
 * <p>
 * Given a string, we have to find out all subsequences of it.
 * A String is a subsequence of a given String, that is generated by deleting some character of a given string without changing its order.
 * <p>
 * Input : abc
 * Output : a, b, c, ab, bc, ac, abc
 * <p>
 * Input : aaa
 * Output : a, aa, aaa
 */
public class _013_PrintAllSubsequenceOfStrings {

    public static void main(String[] args) {
        String word = "abc";
        List<String> result = new ArrayList<>();
        printAllSubsequenceOfStrings(word, new StringBuilder(), result, 0);
        System.out.println(result);
    }

    private static void printAllSubsequenceOfStrings(String word, StringBuilder currString, List<String> result, int index) {
        if (index == word.length()) {
            if(currString.length()!=0){
                result.add(currString.toString());
            }
            return;
        }
        currString.append(word.charAt(index));
        printAllSubsequenceOfStrings(word, currString, result, index + 1);
        currString.deleteCharAt(currString.length()-1);
        printAllSubsequenceOfStrings(word, currString, result, index + 1);
    }
}
