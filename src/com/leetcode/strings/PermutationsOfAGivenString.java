package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
 */
public class PermutationsOfAGivenString {

    public static void main(String[] args) {
        PermutationsOfAGivenString obj = new PermutationsOfAGivenString();
        String word = "ABC";
        List<String> permutation = obj.find_permutation(word);
        System.out.println(permutation);
    }

    public List<String> find_permutation(String word) {
        // Code here
        List<String> result = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        findPermutation(word, result,new StringBuilder(), visited);
        return result;
    }

    public void findPermutation(String word, List<String> result,StringBuilder currWord, Set<Character> visited) {

        if (currWord.length() == word.length()) {
            result.add(currWord.toString());
            return;
        }

        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (visited.add(ch)) {
                currWord.append(ch);
                findPermutation(word, result, currWord, visited);
                currWord.deleteCharAt(currWord.length() - 1);
                visited.remove(ch);
            }
        }
    }
}
