package com.practice.coding.freak.array;

import java.util.Arrays;

/**
 * Replace every array element with the product of every other element without
 * using a division operator
 *
 *
 * Input: { 1, 2, 3, 4, 5 } Output: { 120, 60, 40, 30, 24 }
 */
public class ReplaceEveryArrayElementByProduct {

	public static void main(String args[]) {
		
		int product=1;
		int[] arr= { 1, 2, 3, 4, 5 };
		int[] output=new int[arr.length];
		
 		for (int i = 0; i < arr.length; i++) {
			product=product*arr[i];
		}

		for (int j = 0; j < arr.length; j++) {
			output[j]=product/arr[j];
		}
		
		System.out.println(Arrays.toString(output));
	}
}
