package com.leetcode.trees.heaps;

import java.util.Arrays;

public class MinimumSum {

    public static void main(String[] args) {
        MinimumSum obj = new MinimumSum();
        int arr[] = {6, 8, 4, 5, 2, 3};
        String solve = obj.solve(arr, arr.length);
        System.out.println(solve);

    }

    public String solve(int[] arr, int n) {
        Arrays.sort(arr);
        Integer first = 0;
        Integer second = 0;
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        int sum = 0;
        int i;
        for (i = arr.length - 1; i > 0; i -= 2) {
            first = arr[i];
            second = arr[i - 1];
            sum = first + second + carry;
            if (sum > 0) {
                int remainder = sum % 10;
                answer.append(remainder);
                carry = sum / 10;
            }
        }
        if (i == 0) {
            sum = arr[0] + carry;
            if (sum > 0) {
                int remainder = sum % 10;
                answer.append(remainder);
                carry = sum / 10;
            }
        }
        if (carry > 0) {
            answer.append(carry);
        }
        return answer.reverse().toString();
    }
}
