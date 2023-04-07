package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two string expression,
 * <p>
 * exp1 = "dbaecbbabdcaafbddcabgba"; exp2 ="abbcdc"; Find the minimum length of
 * the subarray with expression2 in expression1
 */
public class MinimumWindowSubstring_07 {

    public static void main(String[] args) {
        String expression1 = "dbaecbbabdcaafbddcabgba";
        String expression2 = "abbcdc";
        String subString = minLengthSubArrayWithExp2inExp1(expression1, expression2);
        System.out.println(subString);
    }

    private static String minLengthSubArrayWithExp2inExp1(String expression1, String expression2) {
        String subString = "";
        Map<Character, Integer> actualFreqMap = new HashMap<>();
        Map<Character, Integer> desiredFreqMap = findTheDesiredCount(expression2);
        int matchCount = expression2.length();
        int i = -1;
        int j = -1;
        int count = 0;
        int minLength = expression1.length();
        while (true) {

            Boolean flag1 = true;
            Boolean flag2 = true;

            // acquire if and only if matchCount < desiredMatchCount
            while ((i < expression1.length()-1) && count < matchCount) {
                //we have to increase the freq and check if the count is less than the match count
                i++;
                Character ch = expression1.charAt(i);
                actualFreqMap.put(ch, actualFreqMap.getOrDefault(ch, 0) + 1);
                int desiredFreq = desiredFreqMap.getOrDefault(ch, 0);
                if (desiredFreq >= actualFreqMap.get(ch)) {
                    count++;
                }
                flag1 = false;
            }

            while (j < expression1.length() && count == matchCount) {
                // collect the expression and release
                j++;
                String currString = expression1.substring(j, i + 1);
                if (currString.length() < minLength) {
                    minLength = currString.length();
                    subString = currString;
                }

                Character charToBeRemoved = expression1.charAt(j);
                int freq = desiredFreqMap.getOrDefault(charToBeRemoved, 0);
                int actualFreq = actualFreqMap.getOrDefault(charToBeRemoved, 0);

                if (actualFreq == 1) {
                    actualFreqMap.remove(charToBeRemoved);
                } else {
                    actualFreq-=1;
                    actualFreqMap.put(charToBeRemoved, actualFreq);
                }

                if (freq > actualFreq) {
                    count--;
                }
                flag2 = false;
            }

            if (flag1==false && flag2==false) {
                break;
            }

        }


        return subString;
    }

    private static Map<Character, Integer> findTheDesiredCount(String expression2) {
        int matchCount = 0;
        Map<Character, Integer> desiredFreqMap = new HashMap<>();
        for (int i = 0; i < expression2.length(); i++) {
            Character ch = expression2.charAt(i);
            desiredFreqMap.put(ch, desiredFreqMap.getOrDefault(ch, 0) + 1);
        }
        return desiredFreqMap;
    }


}
