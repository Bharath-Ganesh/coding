package com.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber obj=new LetterCombinationsOfPhoneNumber();
        String digits = "23";
        System.out.println(obj.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return letterCombinations(digits, map);
    }

    public List<String> letterCombinations(String digits, Map<Character, String> map) {

        if (digits.length() == 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        char ch = digits.charAt(0);
        List<String> recList = letterCombinations(digits.substring(1),map);

        String word = map.get(ch);
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            for (String w : recList) {
                answer.add(c + w);
            }
        }
        return answer;
    }
}
