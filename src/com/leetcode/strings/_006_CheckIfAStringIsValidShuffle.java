package com.leetcode.strings;

import java.util.Arrays;

/**
 * https://www.programiz.com/java-programming/examples/check-valid-shuffle-of-strings
 * Example: Check if a string is a valid shuffle of two other strings
 *
 * String first = "XY";
 * String second = "12";
 * String[] results = {"1XY2", "Y1X2", "Y21XX"};
 *
 * 1XY2 is a valid shuffle of XY and 12
 * Y1X2 is a valid shuffle of XY and 12
 * Y21XX is not a valid shuffle of XY and 12
 */
public class _006_CheckIfAStringIsValidShuffle {

    public static void main(String[] args) {

        String first = "XY";
        String second = "12";
        String[] results = {"1XY2", "Y1X2", "Y21XX"};

        // call the method to check if result string is
        // shuffle of the string first and second
        for (String result : results) {
            if (checkLength(first, second, result) == true && shuffleCheck(first, second, result) == true) {
                System.out.println(result + " is a valid shuffle of " + first + " and " + second);
            } else {
                System.out.println(result + " is not a valid shuffle of " + first + " and " + second);
            }
        }
    }

    private static boolean shuffleCheck(String first, String second, String result) {
        first = sortString(first);
        second = sortString(second);
        result = sortString(result);

        int i = 0, j = 0, k = 0;
        while (k != result.length()) {
            if (i < first.length() && first.charAt(i) == result.charAt(k)) {
                i++;
            } else if (j < second.length() && second.charAt(j) == result.charAt(k)) {
                j++;
            } else {
                return false;
            }
            k++;
        }
        return true;

    }

    private static String sortString(String first) {
        char[] charArray = first.toCharArray();
        Arrays.sort(charArray);

        StringBuilder modifiedString = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            modifiedString.append(charArray[i]);
        }
        return modifiedString.toString();
    }

    private static boolean checkLength(String first, String second, String result) {
        if (first.length() + second.length() != result.length()) {
            return false;
        }
        return true;
    }
}
