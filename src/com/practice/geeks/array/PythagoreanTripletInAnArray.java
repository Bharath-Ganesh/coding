package com.practice.geeks.array;


/*
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 * 
 * 	Input: arr[] = {3, 1, 4, 6, 5} 
	Output: True 
	There is a Pythagorean triplet (3, 4, 5).
	Input: arr[] = {10, 4, 6, 12, 5} 
	Output: False 
	There is no Pythagorean triplet. 
 */
public class PythagoreanTripletInAnArray {

	public static void main(String[] args) {
		int arr[] = { 10, 4, 6, 3, 5 };
		Boolean isTriplet = findPythagoreanTriplet(arr);
		System.out.println(isTriplet);
	}

	private static Boolean findPythagoreanTriplet(int[] arr) {
		sortArray(arr);
		for (int i = 0; i <= arr.length - 3; i++) {
			double a = arr[i];
			double b = arr[i + 1];
			for (int j = i + 2; j < arr.length; j++) {
				double c = Math.pow(arr[j], 2);
				double sqaure= Math.pow(a, 2) + Math.pow(b, 2);
				if(c==sqaure) {
					System.out.print(a + " " + b + " " + arr[j]);
					return true;
				}
			}
		}
		return false;
	}

	public static void sortArray(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int pivot = arr[i];
			int hole = i;
			while (hole > 0 && arr[hole - 1] > pivot) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
			arr[hole] = pivot;
		}
	}

}
