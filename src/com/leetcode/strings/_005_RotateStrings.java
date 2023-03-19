package com.leetcode.strings;


/**
 * 796. Rotate String
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 * <p>
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 * <p>
 * Input: s = "abcde", goal = "abced"
 * Output: false
 * <p>
 * Input: s = "clrwmpkwru", goal = "wmpkwruclr"
 * Output: true
 */
public class _005_RotateStrings {

    public static void main(String[] args) {
        String s = "bbbacddceeb";
        String goal = "ceebbbbacdd";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal) {


        if (s.length() != goal.length()) {
            return false;
        }

        s = s + s;
        String s1 = "bharath ganesh is doing well";
        String s2 = s1.toUpperCase();
        System.out.println(s1);
        System.out.println(s2);
        StringBuilder curr = new StringBuilder();
        for (int i = 0; i < goal.length() - 1; i++) {
            curr.append(s.charAt(i));
        }

        for (int i = goal.length() - 1; i < s.length(); i++) {
            curr.append(s.charAt(i));
            if (curr.toString().equals(goal)) {
                return true;
            }
            curr.deleteCharAt(0);
        }
        return false;
    }
}
