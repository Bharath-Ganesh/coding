package com.practice.geeks.array;

public class CountDuplicateElementInSortedArray {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 20, 30, 30, 30, 30, 30, 30, 40, 50, 60 };
		int elementToBeSearched = 20;
		int startIndex = binarySearch(arr, elementToBeSearched, true);
		int endIndex = binarySearch(arr, elementToBeSearched, false);

		if (startIndex == -1 || endIndex == -1) {
			System.out.println("Element does not exist");
		} else if (startIndex == endIndex) {
			System.out.println("No duplicates");
		} else {
			System.out.printf("Start Index  : %d; End index :  %d ; Total duplicates :  %d ", startIndex, endIndex,
					endIndex - startIndex + 1);
		}
	}

	private static int binarySearch(int[] arr, int elementToBeSearched, boolean isStart) {

		int low = 0;
		int high = arr.length - 1;
		int result = -1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] == elementToBeSearched) {
				result = mid;
				if (isStart) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (arr[mid] > elementToBeSearched) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return result;
	}

}
