package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author bharath
 *
 */
public class MinimumDistanceBetweenEqualNumbers {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(7, 1, 3, 4, 1, 7));
		int length = minimumDistances(arr);
		System.out.println(length);
		int length2 = minimumDistancesHash(arr);
		System.out.println(length2);

	}

	/*
	 * O(n2)
	 */
	public static int minimumDistances(List<Integer> arr) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (arr.get(i) == arr.get(j)) {
					int length = j - i;
					if (length < min) {
						min = length;
					}
					break;
				}
			}
		}
		if (min == Integer.MAX_VALUE)
			min = -1;
		return min;

	}

	/*
	 * O(n)
	 */
	public static int minimumDistancesHash(List<Integer> arr) {
		int min = arr.size() + 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.size(); i++) {
			if (map.containsKey(arr.get(i))) {
				int length = i - map.get(arr.get(i));
				if (min > length)
					min = length;
				map.put(arr.get(i), i);

			} else {
				map.put(arr.get(i), i);
			}
		}
		if (min == arr.size() + 1)
			min = -1;
		return min;

	}

	
}
