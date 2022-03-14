package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _018_ConceptualProblems {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 57, 58, 67, 6, 8, 10, 4};
        int index = 0;
        //   System.out.println(maximumOfAnArray(arr, index));


        /**
         * Find the first occurrence of a number else -1
         */
        int[] nums = {2, 6, 6, 6, 6, 5, 1, 6, 58, 67, 6, 8, 6, 6, 6, 6, 6, 6, 6, 5, 23, 23, 2, 4};
        int target = 6;
      //  System.out.println(firstOccurrenceOfIndex(nums, target, index));


        /**
         * Find the last occurrence of a number else -1
         */
        index = nums.length - 1;
       // System.out.println(lastOccurrence(nums, target, index));


        /**
         * Find the all occurrence of a number else -1
         */
        index = 0;
        int count = 0;
        int[] res = allOccurrence(nums, target, index, count);
       // System.out.println(Arrays.toString(res));


        /**
         * Sequence of words
         */
        String word="abc";
        System.out.println(subsequenceOfAString(word));
    }

    private static int firstOccurrenceOfIndex(int[] nums, int target, int index) {
        if (index == nums.length) {
            return -1;
        }
        if (nums[index] == target) {
            return index;
        }
        return firstOccurrenceOfIndex(nums, target, index + 1);
    }

    private static int lastOccurrence(int[] nums, int target, int index) {
        if (index < 0) {
            return -1;
        }
        if (nums[index] == target) {
            return index;
        }
        return lastOccurrence(nums, target, index - 1);
    }


    // 1 2 3 4 3 5
    private static int[] allOccurrence(int[] nums, int target, int index, int count) {
        if (index == nums.length) {
            return new int[count];
        }
        if (nums[index] == target) {
            int[] arr = allOccurrence(nums, target, index + 1, count + 1);
            arr[count] = index;
            return arr;
        } else {
            return allOccurrence(nums, target, index + 1, count);
        }

    }


    private static int maximumOfAnArray(int[] arr, int index) {
        if (index == arr.length) {
            return Integer.MIN_VALUE;
        }
        return Math.max(arr[index], maximumOfAnArray(arr, index + 1));
    }

    private static List<String> subsequenceOfAString(String word) {
        if (word.length() == 0) {
            List<String> emptyString = new ArrayList<>();
            emptyString.add("");
            return emptyString;
        }
        Character ch = word.charAt(0);
        String restOfTheString = word.substring(1);
        List<String> listOfWordsTillNow = subsequenceOfAString(restOfTheString);
        List<String> res = new ArrayList<>();
        for (String wordsTillNow : listOfWordsTillNow) {
            res.add(wordsTillNow);
        }
        for (String wordsTillNow : listOfWordsTillNow) {
            res.add(ch + wordsTillNow);
        }

        return res;

    }
}
