package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1773. Count Items Matching a Rule
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color,
 * and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
 * <p>
 * The ith item is said to match the rule if one of the following is true:
 * <p>
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 * <p>
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 */
public class CountItemsMatchingARule_36 {

    public static void main(String[] args) {
        List<String> item1 = Arrays.asList("phone", "blue", "pixel");
        List<String> item2 = Arrays.asList("computer", "silver", "lenovo");
        List<String> item3 = Arrays.asList("phone", "gold", "iphone");
        List<List<String>> items = Arrays.asList(item1, item2, item3);
        String ruleKey = "color", ruleValue = "silver";
        System.out.println(countMatches(items, ruleKey, ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {


        int count = 0;
        int rl = getRuleType(ruleKey);
        for (List<String> item : items) {
            if (item.get(rl).equals(ruleValue)) {
                count++;
            }
        }
        return count;
    }


    private static int getRuleType(String ruleKey) {

        int res = 0;
        if (ruleKey.equals("type")) {
            res = 0;
        } else if (ruleKey.equals("color")) {
            res = 1;
        } else {
            res = 2;
        }
        return res;
    }
}
