package com.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Find pair of numbers whose sum add up to the given sum in the provided array
 * int[] a= { 8, 7, 2, 5, 3, 1 }; given sum=10
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] arr = { 8, 7, 2, 5, 3, 1 };
		int givenSum = 10;
		twoSum(arr, givenSum);
	}

	private static void twoSum(int[] arr, int givenSum) {
		Map<Integer,Integer> map= new HashMap<>();
		int count=0;
		for(Integer element : arr) {
			if(map.containsKey(givenSum-element)) {
				System.out.printf("Element found at index %d && %d \n", map.get(givenSum-element),count);
				
			}else {
				map.put(element,count);
			}
			count++;
		}

	}

}
