package com.leetcode.array;

import java.util.ArrayList;

/**
 * Factorials of large numbers
 * https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#
 * Given an integer N, find its factorial.
 * <p>
 * Input: N = 10
 * Output: 3628800
 * Explanation :
 * 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800
 */
public class _092_FactorialOfLargeNumber {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(factorial(n));
    }

    private static ArrayList<Integer> factorial(int n) {
        //code here

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int carry = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = list.size() - 1; j >= 0; j--) {
                int temp = list.get(j) * i + carry;
                list.set(j, temp % 10);
                carry =temp/ 10;
            }
            while (carry != 0) {
                list.add(0, carry % 10);
                carry =carry/ 10;
            }
        }
        return list;
    }
}
