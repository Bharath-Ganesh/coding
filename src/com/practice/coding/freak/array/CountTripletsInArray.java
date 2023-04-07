package com.practice.coding.freak.array;

/**
 * Given an array , count the number of tripets, which leads to an inversion.
 * if( i< j <k ) and ( A[i] > A[j] > A[k] ), then we can say that (i, j ,k )
 * formed an iversion
 * 
 * Input: A[] = [1, 9, 6, 4, 5] Output: The inversion count is 2 There are two
 * inversions of size three in the array: (9, 6, 4) and (9, 6, 5).
 */
public class CountTripletsInArray {

	public static int getInversionCount(int[] arr) {
		int inversionCount = 0;

		for (int i = 0; i < arr.length - 2; i++) {
			for (int j = i + 1; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (i < j && j < k && arr[i] > arr[j] && arr[j] > arr[k]) {

						System.out.println("(" + arr[i] + "," + arr[j] + "," + arr[k] + "," + ")");
					}
				}
			}
		}

		return inversionCount;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 9, 6, 4, 5 };

		System.out.println("The inversion count is " + getInversionCount(arr));
	}
}