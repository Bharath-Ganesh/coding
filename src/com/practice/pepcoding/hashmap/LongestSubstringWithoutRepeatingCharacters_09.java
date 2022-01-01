package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the longest substring without repeating characters
 * <p>
 * String expression = "abbacbcdbadbdbbdcbxabbbbyzacn"
 * output : byzacn
 */
public class LongestSubstringWithoutRepeatingCharacters_09 {

    public static void main(String[] args) {
        String expression = "abbac  bcdbadbdbbdcbxabbbbyzacn";
        String output = longestSubstringWithoutRepeatingCharacters(expression);
        System.out.println("Longest substring without repeating characters : " + output);
    }

    private static String longestSubstringWithoutRepeatingCharacters(String expression) {
        String longestSubstring = "";
        int maxLength = -1;
        Map<Character, Integer> charMap = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {

            boolean flag1 = false;
            boolean flag2 = false;
            //acquire till it becomes invalid

            //   String expression = "abbacbcdbadbdbbdcb";
            while (i < expression.length() - 1) {
                flag1 = true;
                i++;
                Character ch = expression.charAt(i);
                charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
                if (charMap.get(ch) == 2) {
                    break;
                } else {
                    String currExpression = expression.substring(j + 1, i + 1);
                    if (currExpression.length() > maxLength) {
                        maxLength = currExpression.length();
                        longestSubstring = currExpression;
                    }
                }
            }
            //release till it becomes valid
            while (j < i) {
                j++;
                flag2 = true;
                Character ch = expression.charAt(j);
                charMap.put(ch, charMap.getOrDefault(ch, 0) - 1);
                int freq = charMap.get(ch);
                if (freq == 1) {
                    break;
                }

            }
            if (!flag1 && !flag2) {
                break;
            }
        }


        System.out.println("Max length is : " + maxLength);

        return longestSubstring;

    }
}



