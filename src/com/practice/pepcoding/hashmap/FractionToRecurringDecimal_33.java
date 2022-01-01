package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p>
 * If multiple answers are possible, return any of them.
 * <p>
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 * <p>
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 * <p>
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 * Example 4:
 * <p>
 * Input: numerator = 4, denominator = 333
 * Output: "0.(012)"
 * Example 5:
 * <p>
 * Input: numerator = 1, denominator = 5
 * Output: "0.2"
 */
public class FractionToRecurringDecimal_33 {

    public static void main(String[] args) {
        Integer denominator = 7;
        Integer numerator = 93;
        String quotient = fractionToRecurringDecimal(denominator, numerator);
        System.out.println(quotient);
    }

    private static String fractionToRecurringDecimal(Integer denominator, Integer numerator) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();
        int quotient = numerator / denominator;
        int remainder = numerator % denominator;
        answer.append(quotient);
        if (remainder == 0) {
            return answer.toString();
        } else {
            answer.append(".");
            while (remainder != 0) {
                if (map.containsKey(remainder)) {
                    answer.insert(map.get(remainder), "(");
                    answer.append(")");
                    break;
                } else {
                    map.put(remainder, answer.length());
                    remainder *= 10;
                    quotient = remainder / denominator;
                    remainder = remainder % denominator;
                    answer.append(quotient);
                }
            }
        }

        return answer.toString();
    }
}
