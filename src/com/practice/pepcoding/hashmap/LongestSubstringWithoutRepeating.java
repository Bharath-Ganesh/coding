package com.practice.pepcoding.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * String expression="abbacbcdbadbdbbdcb"; find the longest unique substring.
 * o/p -> cdba
 *
 */
//acquire until you become invalid
//release until you become valid
public class LongestSubstringWithoutRepeating {

	/**
	 * @param expression
	 * @param finalAnswer
	 */
	public static Integer longestSubstring(String expression) {
		int max_length = -1;
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;

		// String expression="abbacbcdbadbdbbdcb";
		while (true) {
			boolean f1 = false;
			boolean f2 = false;
			while (i < expression.length() - 1) {
				i++;
				char ch = expression.charAt(i);
				map.put(ch, map.getOrDefault(ch, 0) + 1);

				if (map.get(ch) == 2) {
					break;
				} else {
					int length = i - j;
					if (length > max_length) {
						answer = length;
					}
				}
				f1 = true;

			}

			while (j < i) {
				j++;
				char ch = expression.charAt(j);
				map.put(ch, map.getOrDefault(ch, 0) - 1);

				if (map.get(ch) == 1) {
					break;
				}
				f2 = true;

			}
			if (f1 == false && f2 == false) {
				break;
			}

		}
		return answer;

	}

	public static void main(String args[]) {
		String expression = "abbacbcdbadbdbbdcb";
		int answer = longestSubstring(expression);
		System.out.println(answer);
	}

}
