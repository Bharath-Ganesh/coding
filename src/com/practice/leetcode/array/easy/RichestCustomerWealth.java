package com.practice.leetcode.array.easy;

import java.util.Arrays;

/**
 * You are given an m x n integer grid accounts where accounts[i][j] is the
 * amount of money the i​​​​​​​​​​​th​​ customer has in the j​​​​​​​​​​​​​​
 * bank. Return the wealth that the richest customer has.
 * 
 * A customer's wealth is the amount of money they have in all their bank
 * accounts. The richest customer is the customer that has the maximum wealth.
 * 
 * Input: accounts = [[1,2,3],[3,2,1]] Output: 6 Explanation: 1st customer has
 * wealth = 1 + 2 + 3 = 6 2nd customer has wealth = 3 + 2 + 1 = 6 Both customers
 * are considered the richest with a wealth of 6 each, so return 6.
 *
 */
public class RichestCustomerWealth {

	public static void main(String[] args) {

		int[][] nums = { { 1, 2, 4 }, { 3, 2, 1 } };
		// int max = maximumWealth(nums);
		int max = maximumWealthLeetCode(nums);
		System.out.println(max);
	}

	public static int maximumWealthLeetCode(int[][] accounts) {
		return Arrays.stream(accounts).mapToInt(customerAccount -> Arrays.stream(customerAccount).sum()).max()
				.getAsInt();
	}

	/**
	 * My solution
	 */
	public static int maximumWealth(int[][] accounts) {
		int max = accounts[0][0];

		for (int i = 0; i < accounts.length; i++) {
			int sum = 0;
			for (int j = 0; j < accounts[i].length; j++) {
				sum += accounts[i][j];
			}
			if (max < sum) {
				max = sum;
			}
		}

		return max;
	}

}