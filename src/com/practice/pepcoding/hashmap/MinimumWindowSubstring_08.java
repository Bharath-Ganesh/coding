package com.practice.pepcoding.hashmap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the smallest substring within the string containing all the
 * unique character of itself
 *
 * 012345678901234567
 * String exp1 = "bbacacdcbbcaadcdca"
 * unique express="abcd"
 * output : "acdcb"
 */
public class MinimumWindowSubstring_08 {

    public static void main(String[] args) {
        String exp1 = "bbacacdcbbcaadcdca";
        String smallestString = findSmallestSubStringWithinAString(exp1);
        System.out.println("Smallest substring " + smallestString);
    }

    private static String findSmallestSubStringWithinAString(String exp1) {

        //Find all the unique characters in the string using hashset
        Set<Character> uniqueCharSet = new HashSet<>();
        for (int i = 0; i < exp1.length(); i++) {
            if (!uniqueCharSet.contains(exp1.charAt(i))) {
                uniqueCharSet.add(exp1.charAt(i));
            }

        }
        String subString = minLengthSubArrayWithExp2inExp1(exp1, uniqueCharSet);
        return subString;
    }


    private static String minLengthSubArrayWithExp2inExp1(String expression1, Set uniqueCharSet) {
        String subString = "";
        Map<Character, Integer> actualCharMap = new HashMap<>();
        int i = -1;
        int j = -1;
        int minLength = expression1.length();

        while (true) {

            Boolean flag1 = false;
            Boolean flag2 = false;

            // acquire if and only if matchCount < uniqueCharSet.size()
            while (i < (expression1.length() - 1) && actualCharMap.size() < uniqueCharSet.size()) {
                //we have to increase the count and check if the count is less than the match count
                i++;
                Character ch = expression1.charAt(i);
                actualCharMap.put(ch, actualCharMap.getOrDefault(ch, 0) + 1);
                flag1 = true;
            }

            while (j < i && actualCharMap.size() == uniqueCharSet.size()) {
                // collect the expression and release
                j++;
                String currString = expression1.substring(j, i + 1);
                if (currString.length() < minLength) {
                    minLength = currString.length();
                    subString = currString;
                }

                Character charToBeRemoved = expression1.charAt(j);
                if (actualCharMap.getOrDefault(charToBeRemoved, 0) == 1) {
                    actualCharMap.remove(charToBeRemoved);
                } else {
                    actualCharMap.put(charToBeRemoved, actualCharMap.get(charToBeRemoved) - 1);
                }

                flag2 = true;
            }

            if (flag1 == false && flag2 == false) {
                break;
            }

        }


        return subString;
    }


}
