package com.practice.leetcode.array.easy;

/**
 * Given an integer x, return true if x is palindrome integer.
 * 
 * An integer is a palindrome when it reads the same backward as forward. For
 * example, 121 is palindrome while 123 is not.
 * 
 * Input: x = 121 Output: true
 * 
 * Input: x = -121 Output: false Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 */
public class PalindromeNumber_Q9 {

	public static void main(String[] args) {

		int num = 223;
		Boolean bool = isPalindrome(num);
		System.out.println(bool);
	}

	public static boolean isPalindrome(int number) {

		// value of operation is used to obtain number value from an Integer

		if (number < 0) {
			return false;
		}

		String num = String.valueOf(number);

		int startIndex = 0;
		// for string length() is a function
		int lastIndex = num.length() - 1;

		while (lastIndex >= startIndex) {

			// charAt operation works better with double equal operator
			if (num.charAt(startIndex) == num.charAt(lastIndex)) {
				startIndex++;
				lastIndex--;
			} else {
				return false;
			}
		}
		return true;

	}

}
