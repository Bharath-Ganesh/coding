package com.leetcode.stackqueues;

import java.util.Arrays;
import java.util.Stack;

/**
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 * <p>
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 */
public class _009_NextGreaterElement1 {

    public static void main(String[] args) {

        int[] nums1 = {3, 1, 5, 7, 9, 2, 6};
        int[] nums2 = {1, 2, 3, 5, 6, 7, 9, 11};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack();
        int[] nge = new int[nums2.length];
        stack.push(nums2[nums2.length-1]);
        nge[nums2.length - 1] = -1;
        for (int i = nums2.length - 2; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.empty() && stack.peek() <= num) {
                stack.pop();
            }
            nge[i] = stack.empty() ? -1 : stack.peek();
            stack.push(num);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    res[i] = nge[j];
                    break;
                }
            }
        }
        return res;
    }
}
