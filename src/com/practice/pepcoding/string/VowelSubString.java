package com.practice.pepcoding.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelSubString {

	public static void main(String[] args) {

		String substring = findSubstring("eriiqsaaaaadsadasd", 5);
		System.out.println(substring);

	}

	public static String findSubstring(String s, int k) {

		int vowel_count = 0;
		List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
		StringBuffer subString = new StringBuffer();
		for (int i = 0; i < k - 1; i++) {
			char ch = s.charAt(i);
			if (vowels.contains(ch)) {
				vowel_count++;
			}
			subString.append(ch);
		}

		String vowel_string = "";
		int max_count = 0;
		for (int i = k - 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (vowels.contains(ch)) {
				vowel_count++;
			}
			subString.append(ch);

			if (max_count < vowel_count) {
				vowel_string = subString.toString();
				max_count = vowel_count;
			}

			char charToBeDeleted = s.charAt(i - (k - 1));
			if (vowels.contains(charToBeDeleted)) {
				vowel_count--;
			}
			subString.deleteCharAt(0);
		}

		if (max_count == 0) {
			vowel_string = "Not found!";
		}

		return vowel_string;
	}

}
