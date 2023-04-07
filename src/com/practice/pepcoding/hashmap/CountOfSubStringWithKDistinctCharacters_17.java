package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the count of all the substrings having at most k distinct characters
 * String expression = "aabcbcdbca"
 * Output :
 */
public class CountOfSubStringWithKDistinctCharacters_17 {

    public static void main(String[] args) {
        String expression = "aabcbcdbca";
        int k = 2;
        int count = countOfSubStringWithKDistinctCharacters(expression, k);
        System.out.println(count);
    }

    private static int countOfSubStringWithKDistinctCharacters(String expression, int k) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {

            Boolean flag1 = false;
            Boolean flag2 = false;


            while (i < (expression.length() - 1)) {

                flag1 = true;
                i++;
                Character ch = expression.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == k + 1) {
                    break;
                } else {
                    count += (i - j);
                }

            }

            while (j < i) {
                // collect the expression and release

                flag2 = true;
                j++;
                Character charToBeRemoved = expression.charAt(j);
                if (map.get(charToBeRemoved) == 1) {
                    map.remove(charToBeRemoved);
                } else {
                    map.put(charToBeRemoved, map.get(charToBeRemoved) - 1);
                }

                if (map.size() == k) {
                    count += (i - j);
                    break;
                }

            }

            if (flag1 == false && flag2 == false) {
                break;
            }

        }
        return count;

    }
}
