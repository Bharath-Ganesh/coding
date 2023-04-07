/**
 * 
 */
package com.practice;

public class CaseString {

	/*
	 * Given a string S, the task is to change the complete string to Uppercase or
	 * Lowercase depending upon the case for the first character.
	 * 
	 */

	public static String checkCase(String name) {

		// A-Z : 65-90
		// a-z : 97-122
		String letter = "AbCd";
		StringBuffer newString = new StringBuffer(letter);
		boolean isLower = Character.isLowerCase(newString.charAt(0));
		for (int i = 0; i < letter.length(); i++) {
			if (isLower) {
				newString.setCharAt(i, Character.toLowerCase(letter.charAt(i)));
			} else {
				newString.setCharAt(i, Character.toUpperCase(letter.charAt(i)));
			}
		}
		return newString.toString();
	}

	public static void main(String[] args) {

		String ans = checkCase("Zbcd");
		System.out.println(ans);

	}

}
