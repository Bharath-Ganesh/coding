package com.leetcode.searchandsort;

import java.util.Arrays;

/**
 * 1838. Frequency of the Most Frequent Element
 * The frequency of an element is the number of times it occurs in an array.
 * <p>
 * You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
 * <p>
 * Return the maximum possible frequency of an element after performing at most k operations.
 * <p>
 * Input: nums = [1,2,4], k = 5
 * Output: 3
 * Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
 * 4 has a frequency of 3.
 */
public class _021_FrequencyOfMostFrequentElement {

    public static void main(String[] args) {
        int[] nums={3,6,9};
        int k=2;
        System.out.println(maxFrequency(nums,k));
    }
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int windowSum = 0;
        while (left <= right && right < nums.length) {
            //We are trying to find a window where the elements are same
            // We can increment the value of an element by atmost K times
            // In a window , we can have atmost k operations
            //right pointer => Element to which we are modifying our left elements
            windowSum += nums[right];
            while (nums[right] * (right-left+1) > windowSum + k) {
                windowSum -= nums[left];
                left += 1;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
            right += 1;
        }
        return maxFreq;
    }
}
