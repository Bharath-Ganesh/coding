package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UsernamePossible {

	public static void main(String[] args) {
		List<String> superheroList = new ArrayList<>(Arrays.asList("bee", "superhero", "ace"));
		List<String> result = possibleChanges(superheroList);
		System.out.println(result.stream().collect(Collectors.toList()));

	}

	public static List<String> possibleChanges(List<String> usernames) {
		List<String> result = new ArrayList<>();

		for (String username : usernames) {
			int prev_value = username.charAt(0);
			boolean flag = false;
			for (int i = 1; i < username.length(); i++) {
				int value = username.charAt(i);
				if (prev_value > value) {
					result.add("YES");
					flag = true;
					break;
				}
				prev_value = value;
			}
			if (!flag) {
				result.add("NO");
			}
		}
		return result;

	}

}
