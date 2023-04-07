package com.practice.coding.freak.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array containing duplicates, return the majority element if
 * present. A majority element appears more than n/2 times. (n array size)
 *
 */
public class FndMajorityElement {

	
	/**
	 * 
	 *  Boyer–Moore majority vote algorithm
	 */
	public static int findMajorityElement(int[] A) {
		// `m` stores the majority element (if present)
		int majorityElement = -1;
		// initialize counter `i` with 0
		int i = 0;
		// do for each element `A[j]` in the array
		
		
		//int arr[] = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };
		for (int j = 0; j < A.length; j++) {
			System.out.println(A[j]);
			
			// if counter `i` becomes 0
			if (i == 0) {
				// set the current candidate to `A[j]`
				majorityElement = A[j];

				// reset the counter to 1
				i = 1;
			}

			// otherwise, increment the counter if `A[j]` is a current candidate
			else if (majorityElement == A[j]) {
				i++;
			}
			// otherwise, decrement the counter if `A[j]` is a current candidate
			else {
				i--;
			}
		}

		return majorityElement;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		
		for (int element : arr) {
			if (map.containsKey(element)) {
				map.put(element, map.get(element) + 1);
				if (map.get(element) > (arr.length / 2)) {
					System.out.println("Majority element " + element);
				}
			} else {
				map.put(element, count + 1);
			}

		}
		
		findMajorityElement(arr);

	}

}


