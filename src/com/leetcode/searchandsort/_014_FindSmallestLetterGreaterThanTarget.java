package com.leetcode.searchandsort;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * <p>
 * Given a characters array letters that is sorted in non-decreasing order and a character target,
 * return the smallest character in the array that is larger than target.
 * <p>
 * Note that the letters wrap around.
 * <p>
 * For example, if target == 'z' and letters == ['a', 'b'], the answer is 'a'.
 * <p>
 * Input: letters = {'c','f','j'}, target = 'c'
 * Output: "f"
 */
public class _014_FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'c';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        if (letters[letters.length - 1]  <= target ) {
            return letters[0];
        }

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            char ch = letters[mid];
            if (ch > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start];

    }
}
