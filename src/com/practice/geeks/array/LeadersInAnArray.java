package com.practice.geeks.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Write a program to print all the LEADERS in the array. An element is leader
 * if it is greater than all the elements to its right side. And the rightmost
 * element is always a leader.
 * 
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 * 
 * 
 *
 */
public class LeadersInAnArray {

	public static void main(String[] args) {
		int[] arr = { 21, 17, 19, 4, 5, 2, 3 };
		List<Integer> greaterElementArr = leadersInAnArray(arr);

		for (int i = 0; i < greaterElementArr.size(); i++) {
			System.out.printf("%d ", greaterElementArr.get(i));
		}
		System.out.println();

		List<Integer> greaterElementArrSecond = leadersInAnArrayFromEnd(arr);
		for (int i = 0; i < greaterElementArrSecond.size(); i++) {
			System.out.printf("%d ", greaterElementArrSecond.get(i));
		}

	}

	/**
	 * O(n^2)
	 */
	private static List<Integer> leadersInAnArray(int[] arr) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int currentGreater = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (currentGreater < arr[j]) {
					currentGreater = arr[j];
				}
			}
			set.add(currentGreater);
		}

		List<Integer> greaterElementArr = set.stream().collect(Collectors.toList());
		return greaterElementArr;
	}

	/**
	 * O(n)
	 */
	private static List<Integer> leadersInAnArrayFromEnd(int[] arr) {
		List<Integer> result = new ArrayList<>();
		result.add(arr[arr.length - 1]);
		int maxElement = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > maxElement) {
				maxElement = arr[i];
			}
			result.add(maxElement);
		}
		
		
		
		
		return result.stream().distinct().collect(Collectors.toList());

	}

}
