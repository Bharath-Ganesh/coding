package com.practice.mycodeschool.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<>(Arrays.asList(145, 179, 12, 13, 23, 35, 67, 89, 92, 101, 120));
		int elementToBeSearched = 11;
		int result = binarySearch(elementToBeSearched, arr);
		int result2 = binarySearchRecursive(arr, 0, (arr.size() - 1), 11);
		System.out.println(result);
		System.out.println(result2);
		List<Integer> arr2 = new ArrayList<>(Arrays.asList(7, 8, 8, 9, 10, 11, 12, 14));
		System.out.println(countDuplicateElementsInASortedArray(8, arr2));

	}

	private static int binarySearchRecursive(List<Integer> arr, int low, int high, int elementToBeSearched) {
		if (low > high)
			return -1;

		int middleIndex = (low + high) / 2;
		if (elementToBeSearched == arr.get(middleIndex))
			return middleIndex;

		else if (elementToBeSearched > arr.get(middleIndex))
			return binarySearchRecursive(arr, middleIndex + 1, high, elementToBeSearched);

		else
			return binarySearchRecursive(arr, low, middleIndex - 1, elementToBeSearched);

	}

	private static int binarySearch(int elementToBeSearched, List<Integer> arr) {

		int startIndex = 0;
		int endIndex = arr.size() - 1;
		while (startIndex <= endIndex) {
			int middleIndex = (endIndex + startIndex) / 2;
			if (elementToBeSearched == arr.get(middleIndex)) {
				return middleIndex;

			} else if (elementToBeSearched > arr.get(middleIndex))
				startIndex = middleIndex + 1;

			else
				endIndex = middleIndex - 1;
		}

		return -1;

	}

	private static int countDuplicateElementsInASortedArray(int elementToBeSearched, List<Integer> arr) {

		int firstOccurenceIndex = binarySearchForDuplicateOccurence(elementToBeSearched, arr, true);
		int lastOccurenceIndex = binarySearchForDuplicateOccurence(elementToBeSearched, arr, false);
		return lastOccurenceIndex - firstOccurenceIndex + 1;

	}

	private static int binarySearchForDuplicateOccurence(int elementToBeSearched, List<Integer> arr,
			boolean searchFirst) {

		int startIndex = 0;
		int endIndex = arr.size() - 1;
		int result = -1;
		while (startIndex <= endIndex) {
			int middleIndex = (endIndex + startIndex) / 2;
			if (elementToBeSearched == arr.get(middleIndex)) {
				result = middleIndex;
				if (searchFirst) {
					endIndex = middleIndex - 1;
				} else {
					startIndex = middleIndex + 1;
				}

			} else if (elementToBeSearched > arr.get(middleIndex))
				startIndex = middleIndex + 1;

			else
				endIndex = middleIndex - 1;
		}
		return result;

	}

}
