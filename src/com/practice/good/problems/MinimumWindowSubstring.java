package com.practice.good.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two string expression,
 * 
 * exp1 = "dbaecbbabdcaafbddcabgba"; exp2 ="abbcdc"; Find the minimum length of
 * the subarray with expression2 in expression1
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String desiredExpression = "abbcdc";
		String givenExpression = "dbaecbbabdcaafbddcabgba";
		String minString = minimumWindowSubstring(desiredExpression, givenExpression);
		System.out.println(minString);
	}

	public static String minimumWindowSubstring(String desiredExpression, String givenExpression) {
		String minString = "";
		Map<Character, Integer> mapDesired = new HashMap<>();
		// Map for collecting desired expression freq
		for (int i = 0; i < desiredExpression.length(); i++) {
			Character ch = desiredExpression.charAt(i);
			mapDesired.put(ch, mapDesired.getOrDefault(ch, 0) + 1);
		}
		// int maxcount variable : desired expression length

		int maxCount = desiredExpression.length();
		int count = 0;
		String potentialString = "";
		int initialIndex = -1;
		Map<Character, Integer> mapGiven = new HashMap<>();

		int i = 0;
		while (i < givenExpression.length()) {

			for (i = 0; i < givenExpression.length(); i++) {
				Character ch = givenExpression.charAt(i);
				if (mapDesired.containsKey(ch)) {
					int reqFreq = mapDesired.get(ch);
					int currFreq = mapGiven.get(ch);
					if (currFreq <= reqFreq) {
						count++;
					}
				}
				mapGiven.put(ch, mapGiven.getOrDefault(ch, 0) + 1);
				if (count == maxCount) {
					break;
				}
			}

		}

		return minString;
	}

}
