package com.practice.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function which takes an array and prints the majority element (if it
 * exists), otherwise prints �No Majority Element�. A majority element in an
 * array A[] of size n is an element that appears more than n/2 times (and hence
 * there is at most one such element).
 * 
 * Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
 * 
 * Output : 4 Explanation: The frequency of 4 is 5 which is greater than the
 * half of the size of the array size.
 * 
 * Input : {3, 3, 4, 2, 4, 4, 2, 4}
 * 
 * Output : No Majority Element Explanation: There is no element whose frequency
 * is greater than the half of the size of the array size.
 *
 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {3,2,3,2,2 };
		int majorityElement = findMajorityElement(arr);
		System.out.println(majorityElement);

		int maj_index = findMajorityElementCandidate(arr);
		if (isMajority(arr, maj_index))
			System.out.println("Majority element Moore's Voting Algorithm: " + arr[maj_index]);
		else
			System.out.println("No Majority Element");
	}

	/**
	 * O(n)
	 */
	private static int findMajorityElement(int[] arr) {
		int majorityElement = -1;
		int majorityElementFreq = arr.length / 2;

		Map<Integer, Integer> elementFreqMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			elementFreqMap.put(arr[i], elementFreqMap.getOrDefault(arr[i], 0) + 1);
			if (elementFreqMap.get(arr[i]) > majorityElementFreq) {
				majorityElement = arr[i];
				break;
			}
		}
		return majorityElement;
	}

	private static boolean isMajority(int[] arr, int maj_index) {
		int count;
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[maj_index]) {
				count++;
				if (count > arr.length / 2) {

					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 0(n) Moore's voting algorithm
	 */
	private static int findMajorityElementCandidate(int[] arr) {
		int maj_index = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[maj_index]) {
				count++;
			} else {
				count--;

			}
			if (count == 0) {
				maj_index = i;
				count++;
			}
		}
		return maj_index;
	}
}
