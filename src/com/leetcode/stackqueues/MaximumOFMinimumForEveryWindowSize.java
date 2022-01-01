package com.leetcode.stackqueues;

import java.util.Arrays;
import java.util.Stack;

public class MaximumOFMinimumForEveryWindowSize {

    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(Arrays.toString(maxOfMin(arr, arr.length)));
    }

    static int[] maxOfMin(int[] nums, int n) {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        int[] nsr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int element = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] >= element) {
                stack.pop();
            }

            nsr[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        int[] nsl = new int[n];
        for (int i = 0; i < n; i++) {
            int element = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] >= element) {
                stack.pop();
            }

            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int index = nsr[i] - nsl[i] - 1;
            ans[index] = Math.max(ans[index], nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ans[i + 1];
        }
        return res;
    }
}
