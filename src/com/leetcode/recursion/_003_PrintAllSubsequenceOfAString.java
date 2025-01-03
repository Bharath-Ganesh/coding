package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/print-subsequences-string/
 * <p>
 * Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String,
 * that is generated by deleting some character of a given string without changing its order.
 * <p>
 * Input : abc
 * Output : a, b, c, ab, bc, ac, abc
 * <p>
 * Input : aaa
 * Output : a, aa, aaa
 */
public class _003_PrintAllSubsequenceOfAString {

    public static void main(String[] args) {
        String word = "abc";
        System.out.println(printAllSubsequenceOfAStringTrial(word));

//        Set<String> st = new HashSet<>();
//        //subsequence(word, st);
//        System.out.println(st);
    }

    private static List<String> printAllSubsequenceOfAStringTrial(String word) {

        int n = word.length();
        List<String> result = new ArrayList<>();
        int index = 0;
        StringBuilder wordToBeFormed = new StringBuilder();
        printAllSubsequenceOfAString(index, result, wordToBeFormed, word);
        return result;
    }

    private static void printAllSubsequenceOfAString(int index, List<String> result ,StringBuilder wordToBeFormed, String word) {

        if(index == word.length()){
            return ;
        }

        wordToBeFormed.append(word.charAt(index));
        printAllSubsequenceOfAString(index+1, result, wordToBeFormed, word);
        result.add(wordToBeFormed.toString());
        wordToBeFormed.deleteCharAt(wordToBeFormed.length() - 1);
        printAllSubsequenceOfAString(index+1, result, wordToBeFormed, word);

    }

        private static List<List<Character>> printAllSubsequenceOfAString(String word) {
        List<List<Character>> res = new ArrayList<>();
        List<Character> curr = new ArrayList<>();
        int index = 0;
        printAllSubsequenceOfAString(word, res, curr, index);
        return res;
    }


    private static void printAllSubsequenceOfAString(String word, List<List<Character>> res, List<Character> curr, int index) {
        if (index >= word.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // pick at the index
        curr.add(word.charAt(index));
        printAllSubsequenceOfAString(word, res, curr, index + 1);

        curr.remove(curr.size() - 1);
        printAllSubsequenceOfAString(word, res, curr, index + 1);
        // not pick at the index
    }


    // Function computes all the subsequence of an string
    static void subsequence(String str, Set<String> st) {

        // Iterate over the entire string
        for (int i = 0; i < str.length(); i++) {
            // Iterate from the end of the string
            // to generate substrings
            for (int j = str.length(); j > i; j--) {
                String sub_str = str.substring(i, j);

                if (!st.contains(sub_str))
                    st.add(sub_str);

                // Drop kth character in the substring
                // and if its not in the set then recur
                for (int k = 1; k < sub_str.length() - 1;
                     k++) {
                    StringBuffer sb = new StringBuffer(sub_str);
                    // Drop character from the string
                    sb.deleteCharAt(k);
                    if (!st.contains(sb)) {
                        subsequence(sb.toString(), st);
                    }

                }
            }
        }
    }
}
