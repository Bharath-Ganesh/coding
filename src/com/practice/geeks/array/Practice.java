package com.practice.geeks.array;

import java.util.HashSet;
import java.util.Set;

public class Practice {

	public static String twoStringsUsingHashMap(String s1, String s2) {

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s1.length(); i++) {
			set.add(s1.charAt(i));
		}

		for (int i = 0; i < s2.length(); i++) {
			if (set.contains(s2.charAt(i)))
				return "YES";

		}
		return "NO";
	}

	public static String twoStrings(String s1, String s2) {
		// Write your code here
		int index = 0;
		for (int i = 0; i < s1.length(); i++) {
			index = s2.indexOf(s1.charAt(i));
			if (index != -1) {
				break;
			}
		}

		if (index == -1) {

			return "NO";
		}

		return "YES";
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(twoStrings("wouldyoulikefries", "abcabcabcabcabcabc"));
		//System.out.println(twoStringsUsingHashMap("wouldyoulikefries", "abcabcabcabcabcabc"));
		long endTime = System.nanoTime();
		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in nanoseconds: " + timeElapsed);

	}
}
