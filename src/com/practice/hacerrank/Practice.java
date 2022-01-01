package com.practice.hacerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 5, 4, 3, 2, 1, 3, 4));
		System.out.println(migratoryBirds(arr));
	}

	public static int migratoryBirds(List<Integer> arr) {
		// Write your code here
		
		String index = "Helloe".substring(0);
		System.out.println(index);

		Map<Integer, Integer> map = new HashMap<>();
		int max_frequency = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (map.containsKey(arr.get(i))) {
				int freq = map.get(arr.get(i)) + 1;
				map.put(arr.get(i), freq);
				if (freq >= max_frequency) {
					max_frequency = freq;
				}
			} else {
				map.put(arr.get(i), 1);
			}
		}

		int key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
		return key;

	}

}
