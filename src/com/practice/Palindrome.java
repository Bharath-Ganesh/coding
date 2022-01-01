/**
 * 
 */
package com.practice;

public class Palindrome {

	// To check whether a number is palindrome
	public static boolean isPalindrome(String word) {

		// two pointer approach

		int start = 0;
		int high = word.length() - 1;

		// if both characters are same then decrement last index and increment forward
		// index
		while (start <= high) {
			if (word.charAt(start) != word.charAt(high)) {
				return false;
			} else {
				start++;
				high--;
			}
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("MAAM"));

	}

}
