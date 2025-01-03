package com.practice.uiuc;

import java.util.Stack;

public class SubarrayRanges {

    public static void main(String[] args) {
        SubarrayRanges obj = new SubarrayRanges();
        obj.subArrayRanges(new int[]{1, 4, 3, 2});
    }

    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        Stack<Integer> stack = new Stack<>();

        // Find the sum of all the minimum.
        for (int right = 0; right <= n; ++right) {
            while (!stack.isEmpty() && (right == n || nums[stack.peek()] >= nums[right])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer -= (long) nums[mid] * (right - mid) * (mid - left);
            }
            stack.add(right);
        }

        // Find the sum of all the maximum.
        stack.clear();
        for (int right = 0; right <= n; ++right) {
            while (!stack.isEmpty() && (right == n || nums[stack.peek()] <= nums[right])) {
                int mid = stack.peek();
                stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                answer += (long) nums[mid] * (right - mid) * (mid - left);
            }
            stack.add(right);
        }
        return answer;
    }

}
