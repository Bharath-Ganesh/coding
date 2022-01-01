package com.leetcode.strings;

/**
 * https://practice.geeksforgeeks.org/problems/convert-a-sentence-into-its-equivalent-mobile-numeric-keypad-sequence0547/1
 * Given a sentence in the form of a string in uppercase, convert it into its equivalent mobile numeric keypad sequence.
 * <p>
 * S = "GFG"
 * Output: 43334
 * Explanation: For 'G' press '4' one time.
 * For 'F' press '3' three times.
 */
public class _015_ConvertWordIntoEquivalentSequence {

    public static void main(String[] args) {
        String word = "GFG";
        System.out.println(printSequence(word));

    }

    private static String printSequence(String word) {
        StringBuilder sequence = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (ch == ' ') {
                sequence.append("0");
            } else if (ch == '*') {
                sequence.append("*");
            } else {
                int val = ch - 'A';
                if (val <= 14) {
                    int number = (val / 3) + 2;
                    printElement(sequence, val % 3, number);
                } else if ((val >= 15 && val <= 18) || (val >= 22 && val <= 25)) {
                    int frequency = 0;
                    if (val > 18) {
                        val -= 22;
                        frequency = val % 4;
                        printElement(sequence, frequency, 9);
                    } else {
                        val -= 15;
                        frequency = val % 4;
                        printElement(sequence, frequency, 7);
                    }
                } else {
                    val -= 19;
                    int frequency = val % 3;
                    printElement(sequence, frequency, 8);
                }
            }
        }
        return sequence.toString();

    }

    private static void printElement(StringBuilder sequence, int frequency, int number) {
        for (int j = 0; j <= frequency; j++) {
            sequence.append(number);
        }
    }
}
