package com.practice.pepcoding.hashmap;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an expression find total number of subarrays having all distinct characters  of the expression
 *
 * 1. You are given an array of integers(arr).
 * 2. You have to find the count of equivalent subarrays.
 * 3. A subarray is equivalent if, count of unique integers in the subarray = count of unique integers in the given array.
 *
 * String expression ="2535241314"
 * uniqueCharacter="12345"
 */
public class CountOfEquivalentSubArrays_13 {

    public static void main(String[] args) {
        String expression = "2535241314";
        int count = countOfEquivalentSubArrays(expression);
        System.out.println(count);
    }

    private static int countOfEquivalentSubArrays(String expression) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = findFreqOfDistinctCharacter(expression);
        int matchCount = 0;
        int i = -1;
        int j = -1;
        int totalCount = 0;

        while (true) {
            boolean flag1 = true;
            boolean flag2 = true;

            //2535241314
            while (i < (expression.length() - 1) && matchCount < set.size()) {
                flag1 = false;
                i++;
                Integer number = Integer.parseInt(String.valueOf(expression.charAt(i)));
                map.put(number, map.getOrDefault(number, 0) + 1);
                int freq = map.get(number);
                if (freq == 1) {
                    matchCount++;
                }
            }

            //5241
            while (j < i && matchCount == set.size()) {
                flag2=false;
                j++;
                totalCount+=(expression.length()-i);

                //remove
                Integer number = Integer.parseInt(String.valueOf(expression.charAt(j)));
                map.put(number, map.getOrDefault(number, 0) - 1);
                int freq = map.get(number);
                if (freq == 0) {
                    map.remove(number);
                    matchCount--;
                    break;
                }


            }

            if (flag1 && flag2) {
                break;
            }
        }
        return totalCount;
    }

    private static Set<Integer> findFreqOfDistinctCharacter(String expression) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < expression.length(); i++) {
            set.add(Integer.parseInt(String.valueOf(expression.charAt(i))));
        }
        return set;
    }
}
