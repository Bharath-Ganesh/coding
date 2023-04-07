package com.leetcode.array;

import java.util.Arrays;

/**
 * 1051. Height Checker
 * <p>
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height.
 * Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 * <p>
 * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith
 * student in line (0-indexed).
 * <p>
 * Return the number of indices where heights[i] != expected[i].
 * <p>
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 */
public class HeightChecker_17 {
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightCheckerLeetcode(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }

        Arrays.sort(heights);
        int notMatch = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                notMatch++;
            }
        }

        return notMatch;
    }

    public static int heightCheckerLeetcode(int[] heights) {

        int[] heightFreq = new int[101];
        for (int height : heights) {
            heightFreq[height]++;
        }
        int currHeight = 0;
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heightFreq[currHeight] == 0)
                currHeight++;

            if (currHeight != heights[i])
                result++;

            heightFreq[currHeight]--;
        }

        return result;

    }
}
