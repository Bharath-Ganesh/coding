package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * <p>
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 * <p>
 * Input: s = "egg", t = "add"
 * Output: true
 * <p>
 * Input: s = "foo", t = "bar"
 * Output: false
 * <p>
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsomorphicStrings_23 {

    public static void main(String[] args) {
        String exp1 = "foo";
        String exp2 = "bar";
        boolean isIsomorphic = checkIfIsomorphic(exp1, exp2);
        if (checkIfIsomorphicPepcoding(exp1,exp2)) {
            System.out.println("Two strings are isomorphic");
        } else {
            System.out.println("They are not isomorphic!");
        }
    }

    private static boolean checkIfIsomorphic(String exp1, String exp2) {
        boolean isIsomorphic = false;
        //two map for one to one map
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        if (exp1.length() != exp2.length()) {
            return isIsomorphic;
        }
        for (int i = 0; i < exp1.length(); i++) {
            Character chExp1 = exp1.charAt(i);
            Character chExp2 = exp2.charAt(i);
            if (map1.containsKey(chExp1)) {
                if (chExp1 == chExp2) {
                    continue;
                }
                if (map1.get(chExp1) != chExp2) {
                    return isIsomorphic;
                }
                if (map2.get(chExp2) != chExp1) {
                    return isIsomorphic;
                }
            } else {
                map1.put(chExp1, chExp2);
            }
            map2.put(chExp2, chExp1);
        }

        return true;
    }

    private static boolean checkIfIsomorphicPepcoding(String exp1, String exp2) {
        boolean isIsomorphic = false;
        //two map for one to one map

        // Map for storing one to one mapping
        Map<Character, Character> map1 = new HashMap<>();

        //Map for checking the multiple occurrence of characters
        Map<Character, Boolean> map2 = new HashMap<>();

        if (exp1.length() != exp2.length()) {
            return isIsomorphic;
        }

        for (int i = 0; i < exp1.length(); i++) {
            Character chExp1 = exp1.charAt(i);
            Character chExp2 = exp2.charAt(i);
            if (map1.containsKey(chExp1)) {
                if (chExp1 == chExp2) {
                    continue;
                }
                if (map1.get(chExp1) != chExp2) {
                    return isIsomorphic;
                }
            } else {
                if (map2.containsKey(chExp2)) {
                    return false;
                } else {
                    map1.put(chExp1, chExp2);
                    map2.put(chExp2, true);
                }
            }
        }

        return true;
    }
}
