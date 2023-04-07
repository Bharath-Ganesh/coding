package com.practice.pepcoding.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a string you have to print all the palindromic substring.
 * 
 * 
 *
 */
public class PrintAllPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println("Enter a string");
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();

		Set<String> palindromicSubstring = generateSubString(inputString);
		for (String element : palindromicSubstring) {
			System.out.println(element);
		}

	}

	public static boolean isPalindrome(String word) {

		int i = 0;
		int j = word.length() - 1;
		while (i <= j) {
			if (word.charAt(i) == word.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;

	}

	/**
	 * 
	 */
	public static Set<String> generateSubString(String inputString) {
		String newString = "";
		Set<String> palindromicSubstring = new HashSet<>();

		for (int i = 0; i < inputString.length(); i++) {
			newString = "";
			for (int j = i; j < inputString.length(); j++) {
				newString += inputString.charAt(j);
				if (isPalindrome(newString)) {
					palindromicSubstring.add(newString);
				}

			}

		}
		return palindromicSubstring;
	}

}
