package com.practice;

import java.util.HashMap;
import java.util.Map;

public class Sample {

	public static void main(String[] args) {
		String chocolates = minWindow("ADOBECODEBANC", "ABC");
		System.out.println(chocolates);

	}

	public static String minWindow(String givenExp, String desiredExp) {

		String minWindowString = "";
		Map<Character, Integer> desiredMap = new HashMap<>();
		for (int i = 0; i < desiredExp.length(); i++) {
			Character ch = desiredExp.charAt(i);
			desiredMap.put(ch, desiredMap.getOrDefault(ch, 0) + 1);
		}

		int maxCount = desiredExp.length();

		Map<Character, Integer> givenMap = new HashMap<>();
		int count = 0;
		int initialIndex = -1;
		int index = -1;
		int minLength = givenExp.length() + 1;

		while (true) {

			boolean flag1 = true;
			boolean flag2 = true;

			while (index < givenExp.length() - 1 && count < maxCount) {
				index++;
				Character ch = givenExp.charAt(index);
				givenMap.put(ch, givenMap.getOrDefault(ch, 0) + 1);
				if (desiredMap.containsKey(ch)) {
					int reqFreq = desiredMap.get(ch);
					int currFreq = givenMap.get(ch);

					if (reqFreq >= currFreq) {
						count++;
					}
				}

				flag1 = false;
			}

			while (initialIndex < index && count == maxCount) {
				initialIndex++;
				String currString = givenExp.substring(initialIndex, index + 1);
				if (currString.length() < minLength) {
					minLength = currString.length();
					minWindowString = currString;
				}

				Character ch = givenExp.charAt(initialIndex);
				int freq = givenMap.get(ch);
				if (freq == 1) {
					givenMap.remove(ch);
				} else {
					givenMap.put(ch, freq - 1);
				}

				if (givenMap.getOrDefault(ch, 0) < desiredMap.getOrDefault(ch, 0)) {
					count -= 1;
				}
				flag2 = false;
			}

			if (flag1 && flag2) {
				break;
			}

		}

		return minWindowString;
	}
}
