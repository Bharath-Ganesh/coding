package com.practice.coding.freak.array;

public class FindMaxProductOfTwoIntegersInArray {

	/**
	 * Aonther approach will be sort the array initially. On sorting the maximum
	 * product will be available at two position 
	 * 1.Product of last_two numbers
	 *  2.Product of first two number
	 */
	public static void main(String args[]) {

		int[] arr = { -10, -3, 5, 6, 2 };
		int max_product = arr[0];
		

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] * arr[j]) > max_product) {
					max_product = (arr[i] * arr[j]);
				
				}
			}
		}

	}

}
